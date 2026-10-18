package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

import java.util.List;

/**
 * Adds the stair shape and horizontal connection states introduced in 1.26.50.
 * <p>
 * The block lists are taken from the BDS 1.26.52 block palette diff against 1.26.40. Blocks that
 * already carry these states (worlds saved by 1.26.50 or newer) are left untouched.
 */
public class BlockStateUpdater_1_26_50 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_26_50();

    /**
     * Stairs that gained {@code minecraft:corner}.
     */
    public static final List<String> CORNER_BLOCKS = List.of(
            "minecraft:acacia_stairs",
            "minecraft:andesite_stairs",
            "minecraft:bamboo_mosaic_stairs",
            "minecraft:bamboo_stairs",
            "minecraft:birch_stairs",
            "minecraft:blackstone_stairs",
            "minecraft:brick_stairs",
            "minecraft:cherry_stairs",
            "minecraft:cinnabar_brick_stairs",
            "minecraft:cinnabar_stairs",
            "minecraft:cobbled_deepslate_stairs",
            "minecraft:crimson_stairs",
            "minecraft:cut_copper_stairs",
            "minecraft:dark_oak_stairs",
            "minecraft:dark_prismarine_stairs",
            "minecraft:deepslate_brick_stairs",
            "minecraft:deepslate_tile_stairs",
            "minecraft:diorite_stairs",
            "minecraft:end_brick_stairs",
            "minecraft:exposed_cut_copper_stairs",
            "minecraft:granite_stairs",
            "minecraft:jungle_stairs",
            "minecraft:mangrove_stairs",
            "minecraft:mossy_cobblestone_stairs",
            "minecraft:mossy_stone_brick_stairs",
            "minecraft:mud_brick_stairs",
            "minecraft:nether_brick_stairs",
            "minecraft:normal_stone_stairs",
            "minecraft:oak_stairs",
            "minecraft:oxidized_cut_copper_stairs",
            "minecraft:pale_oak_stairs",
            "minecraft:polished_andesite_stairs",
            "minecraft:polished_blackstone_brick_stairs",
            "minecraft:polished_blackstone_stairs",
            "minecraft:polished_cinnabar_stairs",
            "minecraft:polished_deepslate_stairs",
            "minecraft:polished_diorite_stairs",
            "minecraft:polished_granite_stairs",
            "minecraft:polished_sulfur_stairs",
            "minecraft:polished_tuff_stairs",
            "minecraft:poplar_stairs",
            "minecraft:prismarine_bricks_stairs",
            "minecraft:prismarine_stairs",
            "minecraft:purpur_stairs",
            "minecraft:quartz_stairs",
            "minecraft:red_nether_brick_stairs",
            "minecraft:red_sandstone_stairs",
            "minecraft:resin_brick_stairs",
            "minecraft:sandstone_stairs",
            "minecraft:smooth_quartz_stairs",
            "minecraft:smooth_red_sandstone_stairs",
            "minecraft:smooth_sandstone_stairs",
            "minecraft:spruce_stairs",
            "minecraft:stone_brick_stairs",
            "minecraft:stone_stairs",
            "minecraft:sulfur_brick_stairs",
            "minecraft:sulfur_stairs",
            "minecraft:tuff_brick_stairs",
            "minecraft:tuff_stairs",
            "minecraft:warped_stairs",
            "minecraft:waxed_cut_copper_stairs",
            "minecraft:waxed_exposed_cut_copper_stairs",
            "minecraft:waxed_oxidized_cut_copper_stairs",
            "minecraft:waxed_weathered_cut_copper_stairs",
            "minecraft:weathered_cut_copper_stairs"
    );

    /**
     * Fences, panes and bars that gained the four {@code minecraft:connection_*} states.
     */
    public static final List<String> CONNECTION_BLOCKS = List.of(
            "minecraft:acacia_fence",
            "minecraft:bamboo_fence",
            "minecraft:birch_fence",
            "minecraft:black_stained_glass_pane",
            "minecraft:blue_stained_glass_pane",
            "minecraft:brown_stained_glass_pane",
            "minecraft:cherry_fence",
            "minecraft:copper_bars",
            "minecraft:crimson_fence",
            "minecraft:cyan_stained_glass_pane",
            "minecraft:dark_oak_fence",
            "minecraft:exposed_copper_bars",
            "minecraft:glass_pane",
            "minecraft:gray_stained_glass_pane",
            "minecraft:green_stained_glass_pane",
            "minecraft:hard_black_stained_glass_pane",
            "minecraft:hard_blue_stained_glass_pane",
            "minecraft:hard_brown_stained_glass_pane",
            "minecraft:hard_cyan_stained_glass_pane",
            "minecraft:hard_glass_pane",
            "minecraft:hard_gray_stained_glass_pane",
            "minecraft:hard_green_stained_glass_pane",
            "minecraft:hard_light_blue_stained_glass_pane",
            "minecraft:hard_light_gray_stained_glass_pane",
            "minecraft:hard_lime_stained_glass_pane",
            "minecraft:hard_magenta_stained_glass_pane",
            "minecraft:hard_orange_stained_glass_pane",
            "minecraft:hard_pink_stained_glass_pane",
            "minecraft:hard_purple_stained_glass_pane",
            "minecraft:hard_red_stained_glass_pane",
            "minecraft:hard_white_stained_glass_pane",
            "minecraft:hard_yellow_stained_glass_pane",
            "minecraft:iron_bars",
            "minecraft:jungle_fence",
            "minecraft:light_blue_stained_glass_pane",
            "minecraft:light_gray_stained_glass_pane",
            "minecraft:lime_stained_glass_pane",
            "minecraft:magenta_stained_glass_pane",
            "minecraft:mangrove_fence",
            "minecraft:nether_brick_fence",
            "minecraft:oak_fence",
            "minecraft:orange_stained_glass_pane",
            "minecraft:oxidized_copper_bars",
            "minecraft:pale_oak_fence",
            "minecraft:pink_stained_glass_pane",
            "minecraft:poplar_fence",
            "minecraft:purple_stained_glass_pane",
            "minecraft:red_stained_glass_pane",
            "minecraft:spruce_fence",
            "minecraft:trip_wire",
            "minecraft:warped_fence",
            "minecraft:waxed_copper_bars",
            "minecraft:waxed_exposed_copper_bars",
            "minecraft:waxed_oxidized_copper_bars",
            "minecraft:waxed_weathered_copper_bars",
            "minecraft:weathered_copper_bars",
            "minecraft:white_stained_glass_pane",
            "minecraft:yellow_stained_glass_pane"
    );

    private static final List<String> CONNECTION_STATES = List.of(
            "minecraft:connection_north",
            "minecraft:connection_east",
            "minecraft:connection_south",
            "minecraft:connection_west"
    );

    private BlockStateUpdater_1_26_50() {
        super(1, 26, 50);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        for (var name : CORNER_BLOCKS) {
            context.addProperty(name, "minecraft:corner", "none");
        }
        for (var name : CONNECTION_BLOCKS) {
            for (var state : CONNECTION_STATES) {
                context.addProperty(name, state, (byte) 0);
            }
        }
    }
}
