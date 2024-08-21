# StateUpdater

Extracted block state mappings from the Minecraft: Bedrock Edition used to update versioned NBT tags found in LevelDB
worlds to the latest version.

### Usage

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
// Update legacy block to new latest items (example for update jungle planks)
NbtMap updatedNbt = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:stone")
                        .putInt("val", 1) // You can use int, short, long and byte
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
);

// or update new items to latest
NbtMap updatedNbt = BlockStateUpdaters.updateBlockState(
        NbtMap.builder()
                .putString("Name", "minecraft:coal")
                .putInt("Damage", 1) // You can use int, short, long and byte
                .build(),
        BlockStateUpdaters.LATEST_VERSION
);
```

Updating legacy meta values to block states

```java
NbtMap updatedTag = BlockStateUpdaters.updateBlockState(NbtMap.builder()
        .putString("name", "minecraft:stone")
        .putShort("val", (short) 1)
        .build(), 0);
```

## Acknowledgements

* [BedrockItemUpgradeSchema](https://github.com/pmmp/BedrockItemUpgradeSchema)
* [BedrockBlockUpgradeSchema](https://github.com/pmmp/BedrockBlockUpgradeSchema)
* [BlockStateUpdater](https://github.com/CloudburstMC/BlockStateUpdater)