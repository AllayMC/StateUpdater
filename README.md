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

## Acknowledgements

* [BedrockItemUpgradeSchema](https://github.com/pmmp/BedrockItemUpgradeSchema)
* [BedrockBlockUpgradeSchema](https://github.com/pmmp/BedrockBlockUpgradeSchema)
* [BlockStateUpdater](https://github.com/CloudburstMC/BlockStateUpdater)
