# StateUpdater [![](https://jitpack.io/v/AllayMC/StateUpdater.svg)](https://jitpack.io/#AllayMC/StateUpdater)

Extracted state mappings from the Minecraft: Bedrock Edition used to update state NBT tags to the latest version.

All updaters are auto-generated!

### Usage

#### Update Item

```java
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
