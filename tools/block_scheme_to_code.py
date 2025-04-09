import json

import pyperclip


def format_value(val_dict):
    val_type, value = next(iter(val_dict.items()))
    if val_type == 'string':
        return f'"{value}"', value
    elif val_type == 'byte':
        return f'(byte) {value}', value
    elif val_type == 'int':
        return int(value), value
    else:
        raise ValueError(f'Unsupported value type: {val_type}')


def generate_remap_values(data, code: list[str]):
    if 'remappedPropertyValues' not in data:
        return

    mappers = {}
    for block, properties in data['remappedPropertyValues'].items():
        for _, mapper_name in properties.items():
            mapper = mappers.get(mapper_name, [])
            mapper.append(block)
            mappers[mapper_name] = mapper

    for mapper_name, blocks in mappers.items():
        remap_entries = data['remappedPropertyValuesIndex'][mapper_name]
        vals = {}
        for entry in remap_entries:
            old, _ = format_value(entry['old'])
            new, _ = format_value(entry['new'])
            vals[old] = new

        sorted_vals = sorted(vals.items())
        remap_values_code = ',\n'.join(
            [f'new RemapValue({old}, {new})' for old, new in sorted_vals]
        )
        if len(blocks) > 1:
            code.append('')
            code.append(f'var {mapper_name} = new RemapValue[]{{')
            code.append(remap_values_code)
            code.append('};')
            for block in blocks:
                code.append(f'context.remapValues("{block}", "{mapper_name[:-3]}", {mapper_name});')
        else:
            code.append(f'context.remapValues("{blocks[0]}", "{mapper_name[:-3]}",')
            code.append(remap_values_code)
            code.append(');')


def generate_flattened_properties(data, code: list[str]):
    if 'flattenedProperties' in data:
        code.append('')
    else:
        return

    for block, data in data['flattenedProperties'].items():
        prefix = data['prefix']
        flattened_property = data['flattenedProperty']
        suffix = data['suffix']
        remaps = data.get('flattenedValueRemaps', {})

        value_remaps_code = []
        for old, new in sorted(remaps.items()):
            if old == "dummy" and new == "map_not_list":
                continue

            value_remaps_code.append(f'new RemapValue("{old}", "{new}")')

        code.append(f'context.remapState("{block}", "{prefix}", "{flattened_property}", "{suffix}");')
        if len(value_remaps_code) > 0:
            code[-1] = code[-1].replace(');', ',')
            code.append(',\n'.join(value_remaps_code))
            code.append(');')

        code.append('')


def generate_remap_states(data, code: list[str]):
    if 'remappedStates' in data:
        code.append('')
    else:
        return

    for block, remaps in data['remappedStates'].items():
        for remap in remaps:
            old_state = remap.get('oldState', [])
            new_state = remap.get('newState', [])

            prefix = ''
            flattened_property = ''
            suffix = ''
            state_editor_code = []
            if 'newFlattenedName' in remap:
                new_flattened_name = remap['newFlattenedName']
                prefix = new_flattened_name['prefix']
                flattened_property = new_flattened_name['flattenedProperty']
                suffix = new_flattened_name['suffix']

                if 'flattenedValueRemaps' in new_flattened_name:
                    for old, new in sorted(new_flattened_name['flattenedValueRemaps'].items()):
                        if old == "dummy" and new == "map_not_list":
                            continue

                        state_editor_code.append(f'new RemapValue("{old}", "{new}")')
            elif 'newName' in remap:
                prefix = remap['newName']

            if 'copiedState' in remap:
                copied_state = remap['copiedState']
                copied_states_code = ', '.join(f'"{state}"' for state in copied_state)
                state_editor_code.append(f'new CopyStates({copied_states_code})')

            if new_state:
                for prop, value in new_state.items():
                    value, _ = format_value(value)
                    state_editor_code.append(f'new NewState("{prop}", {value})')

            old_state_code = ''
            if old_state:
                old_state_code = 'oldState -> oldState'
                matches_code = []
                for state in old_state:
                    _, value = format_value(old_state[state])
                    matches_code.append(f'.match("{state}", "{value}")')

                old_state_code += ''.join(matches_code) + ', '

            pfs = []
            if prefix:
                pfs.append(f'"{prefix}"')

            if flattened_property:
                pfs.append(f'"{flattened_property}"')

            if suffix:
                pfs.append(f'"{suffix}"')

            code.append(
                f'context.remapState("{block}", {old_state_code}{", ".join(pfs)});')
            if len(state_editor_code) > 0:
                code[-1] = code[-1].replace(');', ',')
                code.append(',\n'.join(state_editor_code))
                code.append(');')

        code.append('')


def generate_add_property(data, code: list[str]):
    if 'addedProperties' in data:
        code.append('')
    else:
        return

    for block, props in data['addedProperties'].items():
        for prop, value in props.items():
            value, _ = format_value(value)
            code.append(f'context.addProperty("{block}", "{prop}", {value});')


def generate_remove_property(data, code: list[str]):
    if 'removedProperties' in data:
        code.append('')
    else:
        return

    for block, props in data['removedProperties'].items():
        for prop in props:
            code.append(f'context.removeProperty("{block}", "{prop}");')


def generate_rename_property(data, code: list[str]):
    if 'renamedProperties' in data:
        code.append('')
    else:
        return

    for block, props in data['renamedProperties'].items():
        for old_prop, new_prop in props.items():
            code.append(f'context.renameProperty("{block}", "{old_prop}", "{new_prop}");')


def generate_rename_id(data, code: list[str]):
    if 'renamedIds' in data:
        code.append('')
    else:
        return

    for old, new in data['renamedIds'].items():
        code.append(f'context.renameId("{old}", "{new}");')


with open('scheme.json') as file:
    data = json.loads(file.read())

code = list()

generate_remap_values(data, code)
generate_flattened_properties(data, code)
generate_remap_states(data, code)
generate_add_property(data, code)
generate_remove_property(data, code)
generate_rename_property(data, code)
generate_rename_id(data, code)


def remove_empty_line(index):
    if len(code[index].strip()) == 0:
        del code[index]


remove_empty_line(0)
remove_empty_line(-1)

final_code = '\n'.join(code)
pyperclip.copy(final_code)
print(final_code)
