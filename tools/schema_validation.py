import re


def require_object(value, path, allowed=None, required=()):
    if not isinstance(value, dict):
        raise ValueError(f'{path} must be a JSON object')
    missing = set(required) - value.keys()
    if missing:
        raise ValueError(f'{path} is missing required fields: {", ".join(sorted(missing))}')
    if allowed is not None:
        unknown = value.keys() - set(allowed)
        if unknown:
            raise ValueError(f'{path} has unknown fields: {", ".join(sorted(unknown))}')
    return value


def require_string(value, path):
    if not isinstance(value, str):
        raise ValueError(f'{path} must be a string')


def require_array(value, path):
    if not isinstance(value, list):
        raise ValueError(f'{path} must be an array')
    return value


def require_integer(value, path, minimum=None, maximum=None):
    if isinstance(value, bool) or not (
        isinstance(value, int) or isinstance(value, float) and value.is_integer()
    ):
        raise ValueError(f'{path} must be an integer')
    value = int(value)
    if minimum is not None and value < minimum or maximum is not None and value > maximum:
        raise ValueError(f'{path} is outside the supported range: {minimum}..{maximum}')
    return value


def validate_string_map(value, path):
    for key, entry in require_object(value, path).items():
        require_string(entry, f'{path}[{key!r}]')


def validate_string_array(value, path):
    for index, entry in enumerate(require_array(value, path)):
        require_string(entry, f'{path}[{index}]')


def property_value(value, path='Property value'):
    require_object(value, path, allowed=('int', 'byte', 'string'))
    if len(value) != 1:
        raise ValueError(f'{path} must contain exactly one type and value')
    value_type, entry = next(iter(value.items()))
    if value_type == 'string':
        require_string(entry, path)
    else:
        minimum, maximum = (-128, 127) if value_type == 'byte' else (-2147483648, 2147483647)
        entry = require_integer(entry, path, minimum, maximum)
    return value_type, entry


def validate_state(value, path, nullable=False):
    if nullable and value is None:
        return
    for prop, entry in require_object(value, path).items():
        property_value(entry, f'{path}[{prop!r}]')


def validate_flatten_rule(value, path):
    require_object(
        value, path,
        allowed=('prefix', 'flattenedProperty', 'suffix', 'flattenedPropertyType', 'flattenedValueRemaps'),
        required=('prefix', 'flattenedProperty', 'suffix')
    )
    for field in ('prefix', 'flattenedProperty', 'suffix'):
        require_string(value[field], f'{path}.{field}')
    if 'flattenedPropertyType' in value and value['flattenedPropertyType'] not in ('int', 'byte', 'string'):
        raise ValueError(f'{path}.flattenedPropertyType must be int, byte or string')
    if 'flattenedValueRemaps' in value:
        validate_string_map(value['flattenedValueRemaps'], f'{path}.flattenedValueRemaps')


def validate_item_schema(data):
    require_object(data, 'Schema', allowed=('renamedIds', 'remappedMetas'))
    validate_string_map(data.get('renamedIds', {}), 'renamedIds')
    for item, remaps in require_object(data.get('remappedMetas', {}), 'remappedMetas').items():
        path = f'remappedMetas[{item!r}]'
        validate_string_map(remaps, path)
        seen_metas = set()
        for meta in remaps:
            if not re.fullmatch(r'-?[0-9]+', meta):
                raise ValueError(f'{path}[{meta!r}] must use an integer metadata key')
            value = require_integer(int(meta), path, -2147483648, 2147483647)
            if value in seen_metas:
                raise ValueError(f'{path} has duplicate numeric metadata keys for {value}')
            seen_metas.add(value)


def validate_block_schema(data):
    version_fields = ('maxVersionMajor', 'maxVersionMinor', 'maxVersionPatch', 'maxVersionRevision')
    sections = (
        'renamedIds', 'renamedProperties', 'addedProperties', 'removedProperties',
        'remappedPropertyValues', 'remappedPropertyValuesIndex', 'flattenedProperties', 'remappedStates',
    )
    require_object(data, 'Schema', allowed=version_fields + sections, required=version_fields)
    for field in version_fields:
        require_integer(data[field], field, minimum=0)
    for section in sections:
        require_object(data.get(section, {}), section)

    validate_string_map(data.get('renamedIds', {}), 'renamedIds')
    for block, properties in data.get('renamedProperties', {}).items():
        validate_string_map(properties, f'renamedProperties[{block!r}]')
    for block, properties in data.get('addedProperties', {}).items():
        validate_state(properties, f'addedProperties[{block!r}]')
    for block, properties in data.get('removedProperties', {}).items():
        validate_string_array(properties, f'removedProperties[{block!r}]')

    index = data.get('remappedPropertyValuesIndex', {})
    for mapper, entries in index.items():
        path = f'remappedPropertyValuesIndex[{mapper!r}]'
        for offset, entry in enumerate(require_array(entries, path)):
            entry_path = f'{path}[{offset}]'
            require_object(entry, entry_path, allowed=('old', 'new'), required=('old', 'new'))
            property_value(entry['old'], f'{entry_path}.old')
            property_value(entry['new'], f'{entry_path}.new')
    for block, properties in data.get('remappedPropertyValues', {}).items():
        path = f'remappedPropertyValues[{block!r}]'
        validate_string_map(properties, path)
        for prop, mapper in properties.items():
            if mapper not in index:
                raise ValueError(f'{path}[{prop!r}] references missing value mapper {mapper!r}')

    for block, flattened in data.get('flattenedProperties', {}).items():
        validate_flatten_rule(flattened, f'flattenedProperties[{block!r}]')
        if block in data.get('renamedIds', {}):
            raise ValueError(f'{block!r} cannot have both renamedIds and flattenedProperties rules')

    for block, remaps in data.get('remappedStates', {}).items():
        path = f'remappedStates[{block!r}]'
        for offset, remap in enumerate(require_array(remaps, path)):
            entry_path = f'{path}[{offset}]'
            require_object(
                remap, entry_path,
                allowed=('oldState', 'newState', 'newName', 'newFlattenedName', 'copiedState'),
                required=('oldState', 'newState')
            )
            if ('newName' in remap) == ('newFlattenedName' in remap):
                raise ValueError(f'{entry_path} must specify exactly one of newName and newFlattenedName')
            validate_state(remap['oldState'], f'{entry_path}.oldState', nullable=True)
            validate_state(remap['newState'], f'{entry_path}.newState', nullable=True)
            if 'newName' in remap:
                require_string(remap['newName'], f'{entry_path}.newName')
            else:
                validate_flatten_rule(remap['newFlattenedName'], f'{entry_path}.newFlattenedName')
            if 'copiedState' in remap:
                validate_string_array(remap['copiedState'], f'{entry_path}.copiedState')
