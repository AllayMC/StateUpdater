import json

import pyperclip


def generate_rename_id(data, code: list[str]):
    if 'renamedIds' not in data:
        return

    for old, new in data['renamedIds'].items():
        code.append(f'context.renameId("{old}", "{new}");')


def generate_remap_meta(data, code: list[str]):
    if 'remappedMetas' in data:
        code.append('')
    else:
        return

    for item, remaps in data['remappedMetas'].items():
        remaps_code = []
        for old_meta, new_item in sorted(remaps.items(), key=lambda x: int(x[0])):
            remaps_code.append(f'new RemapMetaEntry({old_meta}, "{new_item}")')

        code.append(f'context.remapMeta("{item}",\n{',\n'.join(remaps_code)}\n);')


with open('scheme.json') as file:
    data = json.loads(file.read())

code = list()

generate_rename_id(data, code)
generate_remap_meta(data, code)


def remove_empty_line(index):
    if len(code[index].strip()) == 0:
        del code[index]


remove_empty_line(0)
remove_empty_line(-1)

final_code = '\n'.join(code)
pyperclip.copy(final_code)
print(final_code)
