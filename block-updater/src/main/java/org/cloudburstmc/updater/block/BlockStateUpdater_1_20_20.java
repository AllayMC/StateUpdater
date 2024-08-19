package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_20();

    private BlockStateUpdater_1_20_20() {
        super(1, 20, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:amethyst_cluster", "facing_direction", "minecraft:block_face");
        context.renameProperty("minecraft:bamboo_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:bamboo_mosaic_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:bamboo_mosaic_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:bamboo_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:blackstone_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:blackstone_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:cherry_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:cherry_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:cobbled_deepslate_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:cobbled_deepslate_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:crimson_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:crimson_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:deepslate_brick_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:deepslate_brick_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:deepslate_tile_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:deepslate_tile_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:double_stone_block_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:double_stone_block_slab2", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:double_stone_block_slab3", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:double_stone_block_slab4", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:double_wooden_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:exposed_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:exposed_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:large_amethyst_bud", "facing_direction", "minecraft:block_face");
        context.renameProperty("minecraft:mangrove_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:mangrove_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:medium_amethyst_bud", "facing_direction", "minecraft:block_face");
        context.renameProperty("minecraft:mud_brick_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:mud_brick_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:oxidized_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:oxidized_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:polished_blackstone_brick_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:polished_blackstone_brick_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:polished_blackstone_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:polished_blackstone_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:polished_deepslate_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:polished_deepslate_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:small_amethyst_bud", "facing_direction", "minecraft:block_face");
        context.renameProperty("minecraft:stone_block_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:stone_block_slab2", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:stone_block_slab3", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:stone_block_slab4", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:warped_double_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:warped_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_exposed_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_exposed_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_oxidized_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_oxidized_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_weathered_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:waxed_weathered_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:weathered_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:weathered_double_cut_copper_slab", "top_slot_bit", "minecraft:vertical_half");
        context.renameProperty("minecraft:wooden_slab", "top_slot_bit", "minecraft:vertical_half");

        // TODO: remappedPropertyValues
        // TODO: remappedStates
    }
}
