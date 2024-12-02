package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_20();

    private BlockStateUpdater_1_20_20() {
        super(1, 20, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var facing_direction_00 = new RemapValue[]{
                new RemapValue(0, "down"),
                new RemapValue(1, "up"),
                new RemapValue(2, "north"),
                new RemapValue(3, "south"),
                new RemapValue(4, "west"),
                new RemapValue(5, "east")
        };
        context.remapValues("minecraft:amethyst_cluster", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:large_amethyst_bud", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:medium_amethyst_bud", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:small_amethyst_bud", "facing_direction", facing_direction_00);

        var top_slot_bit_00 = new RemapValue[]{
                new RemapValue((byte) 0, "bottom"),
                new RemapValue((byte) 1, "top")
        };
        context.remapValues("minecraft:bamboo_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:bamboo_mosaic_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:bamboo_mosaic_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:bamboo_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:blackstone_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:blackstone_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:cherry_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:cherry_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:cobbled_deepslate_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:cobbled_deepslate_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:crimson_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:crimson_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:deepslate_brick_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:deepslate_brick_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:deepslate_tile_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:deepslate_tile_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:double_stone_block_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:double_stone_block_slab2", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:double_stone_block_slab3", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:double_stone_block_slab4", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:double_wooden_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:exposed_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:exposed_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:mangrove_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:mangrove_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:mud_brick_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:mud_brick_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:oxidized_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:oxidized_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:polished_blackstone_brick_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:polished_blackstone_brick_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:polished_blackstone_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:polished_blackstone_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:polished_deepslate_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:polished_deepslate_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:stone_block_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:stone_block_slab2", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:stone_block_slab3", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:stone_block_slab4", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:warped_double_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:warped_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_exposed_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_exposed_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_oxidized_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_oxidized_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_weathered_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:waxed_weathered_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:weathered_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:weathered_double_cut_copper_slab", "top_slot_bit", top_slot_bit_00);
        context.remapValues("minecraft:wooden_slab", "top_slot_bit", top_slot_bit_00);

        context.remapState("minecraft:stained_glass", "minecraft:", "color", "_stained_glass",
                new RemapValue("silver", "light_gray")
        );
        context.remapState("minecraft:stained_glass_pane", "minecraft:", "color", "_stained_glass_pane",
                new RemapValue("silver", "light_gray")
        );

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
    }
}
