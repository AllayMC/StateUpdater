package org.allaymc.updater.block;

import org.cloudburstmc.nbt.NbtMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
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
        assertEquals("minecraft:granite", stone.getString("name"));
        assertTrue(stone.getCompound("states").isEmpty());

        var goldenRail = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:golden_rail")
                        .putInt("val", 6)
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:golden_rail", goldenRail.getString("name"));
        var goldenRailStates = goldenRail.getCompound("states");
        assertEquals(0, goldenRailStates.getByte("rail_data_bit"));
        assertEquals(0, goldenRailStates.getInt("rail_direction"));
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
                                .putString("wood_type", "oak")
                                .putString("pillar_axis", "y")
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:oak_wood", wood0.getString("name"));
        assertFalse(wood0.getCompound("states").containsKey("stripped_bit"));
        assertFalse(wood0.getCompound("states").containsKey("wood_type"));
        assertTrue(wood0.getCompound("states").containsKey("pillar_axis"));

        var wood1 = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:wood")
                        .putCompound("states", NbtMap.builder()
                                .putInt("stripped_bit", 1)
                                .putString("wood_type", "birch")
                                .putString("pillar_axis", "y")
                                .build()
                        )
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
        assertEquals("minecraft:stripped_birch_wood", wood1.getString("name"));
        assertFalse(wood1.getCompound("states").containsKey("stripped_bit"));
        assertFalse(wood1.getCompound("states").containsKey("wood_type"));
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

    @Test
    void testRequiredVersionUpdater() {
        var creakingHeart0 = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:creaking_heart")
                        .putCompound("states", NbtMap.builder()
                                .putBoolean("active", true)
                                .putBoolean("natural", true)
                                .putString("pillar_axis", "x")
                                .build()
                        )
                        .build(),
                BlockStateUpdater_1_21_60.INSTANCE.getVersion()
        );
        assertEquals("minecraft:creaking_heart", creakingHeart0.getString("name"));
        var states = creakingHeart0.getCompound("states");
        assertFalse(states.isEmpty());
        assertFalse(states.containsKey("active"));
        assertEquals("dormant", states.getString("creaking_heart_state"));
    }

    @Test
    void addsStraightCornerToStairs() {
        var stairs = updateToLatest("minecraft:oak_stairs", NbtMap.builder()
                .putBoolean("upside_down_bit", true)
                .putInt("weirdo_direction", 2)
                .build());

        var states = stairs.getCompound("states");
        assertEquals("minecraft:oak_stairs", stairs.getString("name"));
        assertEquals("none", states.getString("minecraft:corner"));
        assertTrue(states.getBoolean("upside_down_bit"));
        assertEquals(2, states.getInt("weirdo_direction"));
    }

    @Test
    void keepsAnExistingStairCorner() {
        var stairs = updateToLatest("minecraft:oak_stairs", NbtMap.builder()
                .putString("minecraft:corner", "inner_left")
                .putBoolean("upside_down_bit", false)
                .putInt("weirdo_direction", 0)
                .build());

        assertEquals("inner_left", stairs.getCompound("states").getString("minecraft:corner"));
    }

    @Test
    void addsDisconnectedSidesToFencesPanesAndBars() {
        for (var name : new String[]{"minecraft:oak_fence", "minecraft:glass_pane", "minecraft:iron_bars", "minecraft:poplar_fence"}) {
            var states = updateToLatest(name, NbtMap.EMPTY).getCompound("states");
            for (var side : new String[]{"north", "east", "south", "west"}) {
                assertEquals((byte) 0, states.getByte("minecraft:connection_" + side), name + " " + side);
            }
        }
    }

    @Test
    void keepsExistingConnections() {
        var states = updateToLatest("minecraft:oak_fence", NbtMap.builder()
                .putByte("minecraft:connection_north", (byte) 1)
                .putByte("minecraft:connection_east", (byte) 0)
                .putByte("minecraft:connection_south", (byte) 1)
                .putByte("minecraft:connection_west", (byte) 0)
                .build()).getCompound("states");

        assertEquals((byte) 1, states.getByte("minecraft:connection_north"));
        assertEquals((byte) 1, states.getByte("minecraft:connection_south"));
    }

    @Test
    void leavesUnrelatedBlocksAlone() {
        var wall = updateToLatest("minecraft:cobblestone_wall", NbtMap.builder()
                .putString("wall_connection_type_north", "short")
                .build()).getCompound("states");

        assertFalse(wall.containsKey("minecraft:connection_north"));
        assertFalse(wall.containsKey("minecraft:corner"));
    }

    @Test
    void doesNotApply12650StatesWhenTargetingAnOlderVersion() {
        var stairs = BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", "minecraft:oak_stairs")
                        .putCompound("states", NbtMap.builder()
                                .putBoolean("upside_down_bit", false)
                                .putInt("weirdo_direction", 0)
                                .build())
                        .build(),
                BlockStateUpdater_1_26_30.INSTANCE.getVersion()
        );

        assertFalse(stairs.getCompound("states").containsKey("minecraft:corner"));
    }

    private static NbtMap updateToLatest(String name, NbtMap states) {
        return BlockStateUpdaters.updateBlockState(
                NbtMap.builder()
                        .putString("name", name)
                        .putCompound("states", states)
                        .build(),
                BlockStateUpdaters.LATEST_VERSION
        );
    }
}
