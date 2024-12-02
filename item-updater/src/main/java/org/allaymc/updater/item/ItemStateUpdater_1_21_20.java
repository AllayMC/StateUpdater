package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 
 * @author IWareQ
 */
public class ItemStateUpdater_1_21_20 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_20();

    private ItemStateUpdater_1_21_20() {
        super(1, 21, 20);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:yellow_flower", "minecraft:dandelion");

        context.remapMeta("minecraft:anvil",
                new RemapMetaEntry(4, "minecraft:chipped_anvil"),
                new RemapMetaEntry(5, "minecraft:chipped_anvil"),
                new RemapMetaEntry(6, "minecraft:chipped_anvil"),
                new RemapMetaEntry(7, "minecraft:chipped_anvil"),
                new RemapMetaEntry(8, "minecraft:damaged_anvil"),
                new RemapMetaEntry(9, "minecraft:damaged_anvil"),
                new RemapMetaEntry(10, "minecraft:damaged_anvil"),
                new RemapMetaEntry(11, "minecraft:damaged_anvil")
        );
        context.remapMeta("minecraft:dirt",
                new RemapMetaEntry(1, "minecraft:coarse_dirt")
        );
        context.remapMeta("minecraft:double_stone_block_slab",
                new RemapMetaEntry(0, "minecraft:smooth_stone_double_slab"),
                new RemapMetaEntry(1, "minecraft:sandstone_double_slab"),
                new RemapMetaEntry(2, "minecraft:petrified_oak_double_slab"),
                new RemapMetaEntry(3, "minecraft:cobblestone_double_slab"),
                new RemapMetaEntry(4, "minecraft:brick_double_slab"),
                new RemapMetaEntry(5, "minecraft:stone_brick_double_slab"),
                new RemapMetaEntry(6, "minecraft:quartz_double_slab"),
                new RemapMetaEntry(7, "minecraft:nether_brick_double_slab")
        );
        context.remapMeta("minecraft:double_stone_block_slab2",
                new RemapMetaEntry(0, "minecraft:red_sandstone_double_slab"),
                new RemapMetaEntry(1, "minecraft:purpur_double_slab"),
                new RemapMetaEntry(2, "minecraft:prismarine_double_slab"),
                new RemapMetaEntry(3, "minecraft:dark_prismarine_double_slab"),
                new RemapMetaEntry(4, "minecraft:prismarine_brick_double_slab"),
                new RemapMetaEntry(5, "minecraft:mossy_cobblestone_double_slab"),
                new RemapMetaEntry(6, "minecraft:smooth_sandstone_double_slab"),
                new RemapMetaEntry(7, "minecraft:red_nether_brick_double_slab")
        );
        context.remapMeta("minecraft:double_stone_block_slab3",
                new RemapMetaEntry(0, "minecraft:end_stone_brick_double_slab"),
                new RemapMetaEntry(1, "minecraft:smooth_red_sandstone_double_slab"),
                new RemapMetaEntry(2, "minecraft:polished_andesite_double_slab"),
                new RemapMetaEntry(3, "minecraft:andesite_double_slab"),
                new RemapMetaEntry(4, "minecraft:diorite_double_slab"),
                new RemapMetaEntry(5, "minecraft:polished_diorite_double_slab"),
                new RemapMetaEntry(6, "minecraft:granite_double_slab"),
                new RemapMetaEntry(7, "minecraft:polished_granite_double_slab")
        );
        context.remapMeta("minecraft:double_stone_block_slab4",
                new RemapMetaEntry(0, "minecraft:mossy_stone_brick_double_slab"),
                new RemapMetaEntry(1, "minecraft:smooth_quartz_double_slab"),
                new RemapMetaEntry(2, "minecraft:normal_stone_double_slab"),
                new RemapMetaEntry(3, "minecraft:cut_sandstone_double_slab"),
                new RemapMetaEntry(4, "minecraft:cut_red_sandstone_double_slab")
        );
        context.remapMeta("minecraft:light_block",
                new RemapMetaEntry(0, "minecraft:light_block_0"),
                new RemapMetaEntry(1, "minecraft:light_block_1"),
                new RemapMetaEntry(2, "minecraft:light_block_2"),
                new RemapMetaEntry(3, "minecraft:light_block_3"),
                new RemapMetaEntry(4, "minecraft:light_block_4"),
                new RemapMetaEntry(5, "minecraft:light_block_5"),
                new RemapMetaEntry(6, "minecraft:light_block_6"),
                new RemapMetaEntry(7, "minecraft:light_block_7"),
                new RemapMetaEntry(8, "minecraft:light_block_8"),
                new RemapMetaEntry(9, "minecraft:light_block_9"),
                new RemapMetaEntry(10, "minecraft:light_block_10"),
                new RemapMetaEntry(11, "minecraft:light_block_11"),
                new RemapMetaEntry(12, "minecraft:light_block_12"),
                new RemapMetaEntry(13, "minecraft:light_block_13"),
                new RemapMetaEntry(14, "minecraft:light_block_14"),
                new RemapMetaEntry(15, "minecraft:light_block_15")
        );
        context.remapMeta("minecraft:monster_egg",
                new RemapMetaEntry(0, "minecraft:infested_stone"),
                new RemapMetaEntry(1, "minecraft:infested_cobblestone"),
                new RemapMetaEntry(2, "minecraft:infested_stone_bricks"),
                new RemapMetaEntry(3, "minecraft:infested_mossy_stone_bricks"),
                new RemapMetaEntry(4, "minecraft:infested_cracked_stone_bricks"),
                new RemapMetaEntry(5, "minecraft:infested_chiseled_stone_bricks")
        );
        context.remapMeta("minecraft:prismarine",
                new RemapMetaEntry(1, "minecraft:dark_prismarine"),
                new RemapMetaEntry(2, "minecraft:prismarine_bricks")
        );
        context.remapMeta("minecraft:quartz_block",
                new RemapMetaEntry(1, "minecraft:chiseled_quartz_block"),
                new RemapMetaEntry(2, "minecraft:quartz_pillar"),
                new RemapMetaEntry(3, "minecraft:smooth_quartz")
        );
        context.remapMeta("minecraft:red_sandstone",
                new RemapMetaEntry(1, "minecraft:chiseled_red_sandstone"),
                new RemapMetaEntry(2, "minecraft:cut_red_sandstone"),
                new RemapMetaEntry(3, "minecraft:smooth_red_sandstone")
        );
        context.remapMeta("minecraft:sand",
                new RemapMetaEntry(1, "minecraft:red_sand")
        );
        context.remapMeta("minecraft:sandstone",
                new RemapMetaEntry(1, "minecraft:chiseled_sandstone"),
                new RemapMetaEntry(2, "minecraft:cut_sandstone"),
                new RemapMetaEntry(3, "minecraft:smooth_sandstone")
        );
        context.remapMeta("minecraft:stone_block_slab2",
                new RemapMetaEntry(0, "minecraft:red_sandstone_slab"),
                new RemapMetaEntry(1, "minecraft:purpur_slab"),
                new RemapMetaEntry(2, "minecraft:prismarine_slab"),
                new RemapMetaEntry(3, "minecraft:dark_prismarine_slab"),
                new RemapMetaEntry(4, "minecraft:prismarine_brick_slab"),
                new RemapMetaEntry(5, "minecraft:mossy_cobblestone_slab"),
                new RemapMetaEntry(6, "minecraft:smooth_sandstone_slab"),
                new RemapMetaEntry(7, "minecraft:red_nether_brick_slab")
        );
        context.remapMeta("minecraft:stone_block_slab3",
                new RemapMetaEntry(0, "minecraft:end_stone_brick_slab"),
                new RemapMetaEntry(1, "minecraft:smooth_red_sandstone_slab"),
                new RemapMetaEntry(2, "minecraft:polished_andesite_slab"),
                new RemapMetaEntry(3, "minecraft:andesite_slab"),
                new RemapMetaEntry(4, "minecraft:diorite_slab"),
                new RemapMetaEntry(5, "minecraft:polished_diorite_slab"),
                new RemapMetaEntry(6, "minecraft:granite_slab"),
                new RemapMetaEntry(7, "minecraft:polished_granite_slab")
        );
        context.remapMeta("minecraft:stone_block_slab4",
                new RemapMetaEntry(0, "minecraft:mossy_stone_brick_slab"),
                new RemapMetaEntry(1, "minecraft:smooth_quartz_slab"),
                new RemapMetaEntry(2, "minecraft:normal_stone_slab"),
                new RemapMetaEntry(3, "minecraft:cut_sandstone_slab"),
                new RemapMetaEntry(4, "minecraft:cut_red_sandstone_slab")
        );
        context.remapMeta("minecraft:stonebrick",
                new RemapMetaEntry(0, "minecraft:stone_bricks"),
                new RemapMetaEntry(1, "minecraft:mossy_stone_bricks"),
                new RemapMetaEntry(2, "minecraft:cracked_stone_bricks"),
                new RemapMetaEntry(3, "minecraft:chiseled_stone_bricks")
        );
    }
}
