package org.allaymc.updater.block;

import org.cloudburstmc.nbt.NbtMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author IWareQ
 */
class BlockStateUpdaterTest {
    @Test
    void remapState() {
        var anvil = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:anvil")
                        .putCompound("states", NbtMap.builder()
                                .putString("damage", "very_damaged")
                                .putInt("direction", 3)
                                .build())
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:damaged_anvil", anvil.getString("name"));
        assertEquals("east", anvil.getCompound("states").getString("minecraft:cardinal_direction"));
    }

    @Test
    void testRenameId() {
        var dandelion = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:yellow_flower")
                        .putCompound("states", NbtMap.EMPTY)
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:dandelion", dandelion.getString("name"));
    }

    @Test
    void testStonebrick() {
        var defaultStoneBricks = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:stonebrick")
                        .putCompound("states", NbtMap.builder()
                                .putString("stone_brick_type", "default")
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:stone_bricks", defaultStoneBricks.getString("name"));
    }

    @Test
    void testRemapWood() {
        var wood0 = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:wood")
                        .putCompound("states", NbtMap.builder()
                                .putInt("stripped_bit", 0)
                                .putString("wood_type", "birch")
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:birch_wood", wood0.getString("name"));
        assertTrue(wood0.getCompound("states").containsKey("pillar_axis"));

        var wood1 = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:wood")
                        .putCompound("states", NbtMap.builder()
                                .putInt("stripped_bit", 1)
                                .putString("wood_type", "birch")
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:stripped_birch_wood", wood1.getString("name"));
        assertTrue(wood1.getCompound("states").containsKey("pillar_axis"));
    }

    @Test
    void testRemapTnt() {
        var tnt0 = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:tnt")
                        .putCompound("states", NbtMap.builder()
                                .putBoolean("allow_underwater_bit", false)
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:tnt", tnt0.getString("name"));
        assertTrue(tnt0.getCompound("states").isEmpty());

        var tnt1 = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:tnt")
                        .putCompound("states", NbtMap.builder()
                                .putBoolean("allow_underwater_bit", true)
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:underwater_tnt", tnt1.getString("name"));
        assertTrue(tnt1.getCompound("states").isEmpty());
    }
}