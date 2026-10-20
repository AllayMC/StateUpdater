import argparse
import json
import re
from pathlib import Path
from urllib.error import URLError
from urllib.parse import unquote, urlsplit, urlunsplit
from urllib.request import Request, urlopen

from schema_validation import property_value, validate_block_schema


PROJECT_DIRECTORY = Path(__file__).resolve().parent.parent
UPDATER_DIRECTORY = PROJECT_DIRECTORY / 'block-updater/src/main/java/org/allaymc/updater/block'
REGISTRY_PATH = UPDATER_DIRECTORY / 'BlockStateUpdaters.java'
GRADLE_PROPERTIES_PATH = PROJECT_DIRECTORY / 'gradle.properties'


def get_version(source):
    parsed = urlsplit(source)
    filename = Path(unquote(parsed.path) if parsed.scheme in ('http', 'https') else source).name
    match = re.search(
        r'_to_([0-9]+)\.([0-9]+)\.([0-9]+)'
        r'(?:\.[0-9]+)?(?:_[A-Za-z][A-Za-z0-9_-]*)?\.json$',
        filename
    )
    if not match:
        raise ValueError(
            'The schema filename must end with '
            '_to_<major>.<minor>.<patch>[.<build>][_<suffix>].json'
        )
    return tuple(int(part) for part in match.groups())


def load_schema(source):
    parsed = urlsplit(source)
    if parsed.scheme in ('http', 'https'):
        parts = parsed.path.strip('/').split('/')
        if parsed.hostname in ('github.com', 'www.github.com'):
            if len(parts) < 5 or parts[2] not in ('blob', 'raw'):
                raise ValueError('Provide a URL to a JSON file on GitHub')
            source = urlunsplit((
                'https', 'raw.githubusercontent.com',
                '/' + '/'.join(parts[:2] + parts[3:]), '', ''
            ))
        request = Request(source, headers={'User-Agent': 'StateUpdater-block-generator'})
        with urlopen(request, timeout=30) as response:
            data = json.loads(response.read().decode('utf-8-sig'))
    else:
        data = json.loads(Path(source).read_text(encoding='utf-8-sig'))

    validate_block_schema(data)
    return data


def java_string(value):
    if not isinstance(value, str):
        raise ValueError('Expected a string value')
    return json.dumps(value, ensure_ascii=True)


def format_value(value_data):
    value_type, value = property_value(value_data)
    if value_type == 'string':
        return java_string(value), value
    if value_type == 'byte':
        return f'(byte) {value}', value
    return str(value), value


def append_call(code, method, arguments, entries=()):
    call = f'        context.{method}({", ".join(arguments)}'
    if entries:
        code.append(call + ',')
        code.append('                ' + ',\n                '.join(entries))
        code.append('        );')
    else:
        code.append(call + ');')


def remap_value_sort_key(entry):
    value_type, value = property_value(entry['old'])
    return value_type == 'string', value


def generate_remap_values(data, code):
    mappers = {}
    for block, properties in data.get('remappedPropertyValues', {}).items():
        for prop, mapper_name in properties.items():
            mappers.setdefault(mapper_name, []).append((block, prop))

    for index, (mapper_name, targets) in enumerate(mappers.items()):
        entries = []
        remaps = sorted(data['remappedPropertyValuesIndex'][mapper_name], key=remap_value_sort_key)
        for entry in remaps:
            old, _ = format_value(entry['old'])
            new, _ = format_value(entry['new'])
            entries.append(f'new RemapValue({old}, {new})')
        if not entries:
            continue
        if code:
            code.append('')
        if len(targets) > 1:
            variable = f'remapValues{index}'
            code.append(f'        var {variable} = new RemapValue[]{{')
            code.append('                ' + ',\n                '.join(entries))
            code.append('        };')
            for block, prop in targets:
                append_call(code, 'remapValues', [java_string(block), java_string(prop), variable])
        else:
            block, prop = targets[0]
            append_call(code, 'remapValues', [java_string(block), java_string(prop)], entries)


def flattened_arguments(flattened):
    arguments = [java_string(flattened[key]) for key in ('prefix', 'flattenedProperty', 'suffix')]
    if 'flattenedPropertyType' in flattened:
        java_type = {'int': 'Integer', 'byte': 'Byte', 'string': 'String'}[flattened['flattenedPropertyType']]
        arguments.append(f'{java_type}.class')
    return arguments


def flattened_remaps(flattened):
    return [
        f'new RemapValue({java_string(old)}, {java_string(new)})'
        for old, new in sorted(flattened.get('flattenedValueRemaps', {}).items())
    ]


def generate_flattened_properties(data, code):
    for block, flattened in data.get('flattenedProperties', {}).items():
        arguments = [java_string(block)] + flattened_arguments(flattened)
        append_call(code, 'remapState', arguments, flattened_remaps(flattened))


def generate_remap_states(data, code):
    for block, remaps in data.get('remappedStates', {}).items():
        for remap in remaps:
            arguments = [java_string(block)]
            old_state = remap.get('oldState', {})
            if old_state:
                matches = []
                for prop, value_data in old_state.items():
                    value, _ = format_value(value_data)
                    matches.append(f'.matchValue({java_string(prop)}, {value})')
                arguments.append('oldState -> oldState' + ''.join(matches))

            editors = []
            if 'newFlattenedName' in remap:
                flattened = remap['newFlattenedName']
                arguments.extend(flattened_arguments(flattened))
                editors.extend(flattened_remaps(flattened))
            else:
                arguments.append(java_string(remap.get('newName', block)))

            copied_states = ', '.join(java_string(state) for state in remap.get('copiedState', []))
            editors.append(f'new CopyStates({copied_states})')
            for prop, value_data in (remap.get('newState') or {}).items():
                value, _ = format_value(value_data)
                editors.append(f'new NewState({java_string(prop)}, {value})')
            append_call(code, 'remapState', arguments, editors)


def generate_add_property(data, code):
    for block, properties in data.get('addedProperties', {}).items():
        for prop, value_data in properties.items():
            value, _ = format_value(value_data)
            append_call(code, 'addProperty', [java_string(block), java_string(prop), value])


def generate_remove_property(data, code):
    for block, properties in data.get('removedProperties', {}).items():
        for prop in properties:
            append_call(code, 'removeProperty', [java_string(block), java_string(prop)])


def generate_rename_property(data, code):
    for block, properties in data.get('renamedProperties', {}).items():
        for old, new in properties.items():
            append_call(code, 'renameProperty', [java_string(block), java_string(old), java_string(new)])


def generate_rename_id(data, code):
    for old, new in data.get('renamedIds', {}).items():
        append_call(code, 'renameId', [java_string(old), java_string(new)])


def render_schema_body(lines, context_name):
    result = []
    for line in '\n'.join(lines).splitlines():
        prefix = '        context.'
        if line.startswith(prefix):
            line = f'        {context_name}.' + line[len(prefix):]
        result.append('    ' + line if line else '')
    return result


def generate_class(data, version, class_name):
    remaps = []
    generate_remap_states(data, remaps)
    body = []
    for generator in (
        generate_add_property,
        generate_remove_property,
        generate_remap_values,
        generate_rename_property,
        generate_flattened_properties,
        generate_rename_id,
    ):
        section = []
        generator(data, section)
        if section:
            if body:
                body.append('')
            body.extend(section)

    code = [
        'package org.allaymc.updater.block;',
        '',
        'import org.allaymc.updater.block.context.BlockUpdaterContext;',
    ]
    body_source = '\n'.join(remaps + body)
    for type_name in ('CopyStates', 'NewState', 'RemapValue'):
        if f'new {type_name}' in body_source:
            code.append(f'import org.allaymc.updater.block.context.{type_name};')
    code.extend([
        '',
        '/**',
        ' * This file is automatically generated by tools/block_scheme_to_code.py.',
        ' * Do not edit this file manually.',
        ' */',
        f'public class {class_name} extends BlockStateUpdater {{',
        f'    public static final BlockStateUpdater INSTANCE = new {class_name}();',
        '',
        f'    private {class_name}() {{',
        f'        super({", ".join(str(part) for part in version)});',
        '    }',
        '',
        '    @Override',
        '    public void registerUpdaters(BlockUpdaterContext context) {',
    ])
    if remaps:
        code.append('        context.registerSchema(remaps -> {')
        code.extend(render_schema_body(remaps, 'remaps'))
        code.append('        }, changes -> {')
        code.extend(render_schema_body(body, 'changes'))
        code.append('        });')
    else:
        code.extend(body)
    code.extend(['    }', '}', ''])
    return '\n'.join(code)


def register_updater(version, class_name):
    source = REGISTRY_PATH.read_text(encoding='utf-8-sig')
    entries = list(re.finditer(
        r'^        updaters\.add\(BlockStateUpdater_([0-9]+)_([0-9]+)_([0-9]+)\.INSTANCE\);\n',
        source, re.MULTILINE
    ))
    if not entries:
        raise ValueError('Could not find updater registrations in BlockStateUpdaters.java')

    insert_at = entries[-1].end()
    for entry in entries:
        registered_version = tuple(int(part) for part in entry.groups())
        if registered_version == version:
            return source
        if registered_version > version and insert_at == entries[-1].end():
            insert_at = entry.start()
    registration = f'        updaters.add({class_name}.INSTANCE);\n'
    return source[:insert_at] + registration + source[insert_at:]


def update_gradle_version(version):
    source = GRADLE_PROPERTIES_PATH.read_text(encoding='utf-8-sig')
    version_string = '.'.join(str(part) for part in version)
    source, replacements = re.subn(
        r'^([ \t]*block-updater\.version[ \t]*=[ \t]*)'
        r'[0-9]+\.[0-9]+\.[0-9]+(?=-|[ \t]*$)',
        lambda match: match.group(1) + version_string,
        source, flags=re.MULTILINE
    )
    if replacements != 1:
        raise ValueError(
            'Expected exactly one block-updater.version property with a '
            'major.minor.patch version in gradle.properties'
        )
    return source


def write_source(path, source):
    encoding = 'utf-8'
    newline = '\n'
    if path.exists():
        original = path.read_bytes()
        if original.startswith(b'\xef\xbb\xbf'):
            encoding = 'utf-8-sig'
        original.decode(encoding)
        if b'\r\n' in original:
            newline = '\r\n'
        if original == source.replace('\n', newline).encode(encoding):
            return
    path.write_bytes(source.replace('\n', newline).encode(encoding))


def main():
    parser = argparse.ArgumentParser(
        description='Generates and registers a BlockStateUpdater from a JSON schema and updates its Gradle version.'
    )
    parser.add_argument(
        'source', nargs='?',
        help='GitHub/raw URL or path to a schema with a version in its filename; prompts for a URL if omitted'
    )
    args = parser.parse_args()
    try:
        source = (args.source if args.source is not None else input('JSON schema URL: ')).strip()
        if not source:
            raise ValueError('Provide a schema URL')
        version = get_version(source)
        class_name = 'BlockStateUpdater_' + '_'.join(str(part) for part in version)
        class_source = generate_class(load_schema(source), version, class_name)
        registry_source = register_updater(version, class_name)
        gradle_properties_source = update_gradle_version(version)
        output_path = UPDATER_DIRECTORY / f'{class_name}.java'
        write_source(output_path, class_source)
        write_source(REGISTRY_PATH, registry_source)
        write_source(GRADLE_PROPERTIES_PATH, gradle_properties_source)
    except (OSError, URLError, ValueError, KeyError, TypeError, EOFError) as error:
        parser.error(str(error))
    print(f'Generated updater: {output_path}')


if __name__ == '__main__':
    main()
