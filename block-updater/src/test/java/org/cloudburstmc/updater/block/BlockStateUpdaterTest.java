package org.cloudburstmc.updater.block;

import org.cloudburstmc.nbt.NbtMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
class BlockStateUpdaterTest {
    @Test
    void update_from_legacy() {
        var stone = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:stone")
                        .putInt("val", 1)
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals(stone.getString("name"), "minecraft:granite");
        assertTrue(stone.getCompound("states").isEmpty());

        var goldenRail = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:golden_rail")
                        .putInt("val", 6)
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals(goldenRail.getString("name"), "minecraft:golden_rail");
        var goldenRailStates = goldenRail.getCompound("states");
        assertEquals(goldenRailStates.getByte("rail_data_bit"), 0);
        assertEquals(goldenRailStates.getInt("rail_direction"), 0);
    }

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
        assertEquals(anvil.getString("name"), "minecraft:damaged_anvil");
        assertEquals(anvil.getCompound("states").getInt("minecraft:cardinal_direction"), 3);
    }
}