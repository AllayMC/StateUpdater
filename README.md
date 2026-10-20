# StateUpdater

![Block Updater](https://img.shields.io/maven-central/v/org.allaymc.stateupdater/block-updater?label=block-updater)
![Item Updater](https://img.shields.io/maven-central/v/org.allaymc.stateupdater/item-updater?label=item-updater)

Extracted state mappings from the Minecraft: Bedrock Edition used to update state NBT tags to the latest version.

All updaters are auto-generated!

### Usage

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    // block-updater
    implementation("org.allaymc.stateupdater:block-updater:<version>")
    // item-updater
    implementation("org.allaymc.stateupdater:item-updater:<version>")
}
```

#### Update Item

```java
// Update legacy items to new latest items (example for update jungle planks)
NbtMap updatedNbt = ItemStateUpdaters.updateItemState(
        NbtMap.builder()
                .putString("Id", "5")
                .putInt("Damage", 3) // You can use int, short, long and byte
                .build(),
        ItemStateUpdaters.LATEST_VERSION
);

// or update new items to latest
NbtMap updatedNbt = ItemStateUpdaters.updateItemState(
        NbtMap.builder()
                .putString("Name", "minecraft:coal")
                .putInt("Damage", 1) // You can use int, short, long and byte
                .build(),
        ItemStateUpdaters.LATEST_VERSION
);
```

#### Update Block

```java
// Update legacy block
NbtMap updatedNbt = BlockStateUpdaters.updateBlockState(
        NbtMap.builder()
                .putString("name", "minecraft:stone")
                .putInt("val", 1) // You can use int, short, long and byte
                .build(),
        BlockStateUpdaters.LATEST_VERSION
);

// or update block
NbtMap updatedNbt = BlockStateUpdaters.updateBlockState(
        NbtMap.builder()
                .putString("name", "minecraft:anvil")
                .putCompound("states", NbtMap.builder()
                        .putString("damage", "very_damaged")
                        .putInt("direction", 3)
                        .build())
                .build(),
        BlockStateUpdaters.LATEST_VERSION
);
```

## Generating updaters

The generators in `tools/` require Python 3.9 or newer and use only the standard library. Run the following commands from the repository root. On systems without the Windows `py` launcher, use `python3` instead.

### Item schemas

```shell
py tools/item_scheme_to_code.py "https://github.com/opencollab-incubator/BedrockItemUpgradeSchema/blob/master/id_meta_upgrade_schema/0261_1.26.10_to_1.26.20.json"
```

### Block schemas

```shell
py tools/block_scheme_to_code.py "https://github.com/opencollab-incubator/BedrockBlockUpgradeSchema/blob/master/0351_1.26.40_to_1.26.50.json"
```

Both scripts accept GitHub `blob`/`raw` URLs, direct HTTP(S) JSON URLs, or local JSON paths. GitHub file links are converted to raw download URLs automatically. Omit the argument to enter a URL interactively:

```shell
py tools/item_scheme_to_code.py
py tools/block_scheme_to_code.py
```

For a local file, keep the original versioned filename:

```shell
py tools/item_scheme_to_code.py "C:/schemas/0271_1.26.20_to_1.26.40.31_beta.json"
py tools/block_scheme_to_code.py "C:/schemas/0351_1.26.40_to_1.26.50.json"
```

### Version and generated files

The target version comes from the filename after `_to_`, using the format `<major>.<minor>.<patch>[.<build>][_<suffix>].json`. Build numbers and suffixes are omitted from the Java class and Gradle version: `1.26.40.31_beta` becomes `1.26.40`.

Each run performs these steps:

1. Downloads or reads the JSON and validates its structure, value types and mapping references before writing files.
2. Creates the complete Java class with imports, `INSTANCE`, the version constructor, `registerUpdaters`, and an automatic-generation comment.
3. Registers the class in version order, without adding duplicate registrations.
4. Updates the corresponding property in `gradle.properties`, preserving its revision suffix, for example `1.26.20-R1` -> `1.26.40-R1`.

| Generator                 | Generated class directory                                                                              | Registration file                               | Gradle property         |
|---------------------------|--------------------------------------------------------------------------------------------------------|-------------------------------------------------|-------------------------|
| `item_scheme_to_code.py`  | `item-updater/src/main/java/org/allaymc/updater/item/ItemStateUpdater_<major>_<minor>_<patch>.java`    | `ItemStateUpdaters.java` in the same directory  | `item-updater.version`  |
| `block_scheme_to_code.py` | `block-updater/src/main/java/org/allaymc/updater/block/BlockStateUpdater_<major>_<minor>_<patch>.java` | `BlockStateUpdaters.java` in the same directory | `block-updater.version` |

Running the generator again for the same normalized version replaces the generated class. Multiple input schemas targeting that version are not merged. Change the source JSON and regenerate instead of editing generated Java files manually. Output paths are resolved relative to the scripts, so they also work when invoked from another directory.

## Acknowledgements

* [BedrockItemUpgradeSchema](https://github.com/pmmp/BedrockItemUpgradeSchema)
* [BedrockBlockUpgradeSchema](https://github.com/pmmp/BedrockBlockUpgradeSchema)
* [BlockStateUpdater](https://github.com/CloudburstMC/BlockStateUpdater)
