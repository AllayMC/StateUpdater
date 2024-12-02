package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_20();

    private BlockStateUpdater_1_21_20() {
        super(1, 21, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:anvil", "minecraft:", "damage", "anvil",
                new RemapValue("broken", "deprecated_"),
                new RemapValue("slightly_damaged", "chipped_"),
                new RemapValue("undamaged", ""),
                new RemapValue("very_damaged", "damaged_")
        );
        context.remapState("minecraft:coral_fan_hang3", "minecraft:", "dead_bit", "horn_coral_wall_fan",
                new RemapValue("0", ""),
                new RemapValue("1", "dead_"),
                new RemapValue("dummy", "map_not_list")
        );
        context.remapState("minecraft:dirt", "minecraft:", "dirt_type", "dirt",
                new RemapValue("coarse", "coarse_"),
                new RemapValue("normal", "")
        );
        context.remapState("minecraft:double_stone_block_slab", "minecraft:", "stone_slab_type", "_double_slab",
                new RemapValue("wood", "petrified_oak")
        );
        context.remapState("minecraft:double_stone_block_slab2", "minecraft:", "stone_slab_type_2", "_double_slab",
                new RemapValue("prismarine_dark", "dark_prismarine"),
                new RemapValue("prismarine_rough", "prismarine")
        );
        context.remapState("minecraft:double_stone_block_slab3", "minecraft:", "stone_slab_type_3", "_double_slab");
        context.remapState("minecraft:double_stone_block_slab4", "minecraft:", "stone_slab_type_4", "_double_slab",
                new RemapValue("stone", "normal_stone")
        );
        context.remapState("minecraft:light_block", "minecraft:light_block_", "block_light_level", "");
        context.remapState("minecraft:monster_egg", "minecraft:infested_", "monster_egg_stone_type", "",
                new RemapValue("chiseled_stone_brick", "chiseled_stone_bricks"),
                new RemapValue("cracked_stone_brick", "cracked_stone_bricks"),
                new RemapValue("mossy_stone_brick", "mossy_stone_bricks"),
                new RemapValue("stone_brick", "stone_bricks")
        );
        context.remapState("minecraft:prismarine", "minecraft:", "prismarine_block_type", "",
                new RemapValue("bricks", "prismarine_bricks"),
                new RemapValue("dark", "dark_prismarine"),
                new RemapValue("default", "prismarine")
        );
        context.remapState("minecraft:quartz_block", "minecraft:", "chisel_type", "",
                new RemapValue("chiseled", "chiseled_quartz_block"),
                new RemapValue("default", "quartz_block"),
                new RemapValue("lines", "quartz_pillar"),
                new RemapValue("smooth", "smooth_quartz")
        );
        context.remapState("minecraft:red_sandstone", "minecraft:", "sand_stone_type", "red_sandstone",
                new RemapValue("cut", "cut_"),
                new RemapValue("default", ""),
                new RemapValue("heiroglyphs", "chiseled_"),
                new RemapValue("smooth", "smooth_")
        );
        context.remapState("minecraft:sand", "minecraft:", "sand_type", "sand",
                new RemapValue("normal", ""),
                new RemapValue("red", "red_")
        );
        context.remapState("minecraft:sandstone", "minecraft:", "sand_stone_type", "sandstone",
                new RemapValue("cut", "cut_"),
                new RemapValue("default", ""),
                new RemapValue("heiroglyphs", "chiseled_"),
                new RemapValue("smooth", "smooth_")
        );
        context.remapState("minecraft:stone_block_slab2", "minecraft:", "stone_slab_type_2", "_slab",
                new RemapValue("prismarine_dark", "dark_prismarine"),
                new RemapValue("prismarine_rough", "prismarine")
        );
        context.remapState("minecraft:stone_block_slab3", "minecraft:", "stone_slab_type_3", "_slab");
        context.remapState("minecraft:stone_block_slab4", "minecraft:", "stone_slab_type_4", "_slab",
                new RemapValue("stone", "normal_stone")
        );
        context.remapState("minecraft:stonebrick", "minecraft:", "stone_brick_type", "stone_bricks",
                new RemapValue("chiseled", "chiseled_"),
                new RemapValue("cracked", "cracked_"),
                new RemapValue("default", ""),
                new RemapValue("mossy", "mossy_"),
                new RemapValue("smooth", "")
        );

        context.remapState("minecraft:coral_fan_hang", oldState -> oldState.match("dead_bit", "0"), "minecraft:", "coral_hang_type_bit", "_coral_wall_fan",
                new RemapValue("0", "tube"),
                new RemapValue("1", "brain"),
                new RemapValue("dummy", "map_not_list")
        );
        context.remapState("minecraft:coral_fan_hang", oldState -> oldState.match("dead_bit", "1"), "minecraft:dead_", "coral_hang_type_bit", "_coral_wall_fan",
                new RemapValue("0", "tube"),
                new RemapValue("1", "brain"),
                new RemapValue("dummy", "map_not_list")
        );

        context.remapState("minecraft:coral_fan_hang2", oldState -> oldState.match("dead_bit", "0"), "minecraft:", "coral_hang_type_bit", "e_coral_wall_fan",
                new RemapValue("0", "bubbl"),
                new RemapValue("1", "fir"),
                new RemapValue("dummy", "map_not_list")
        );
        context.remapState("minecraft:coral_fan_hang2", oldState -> oldState.match("dead_bit", "1"), "minecraft:dead_", "coral_hang_type_bit", "e_coral_wall_fan",
                new RemapValue("0", "bubbl"),
                new RemapValue("1", "fir"),
                new RemapValue("dummy", "map_not_list")
        );

        context.removeProperty("minecraft:coral_fan_hang3", "coral_hang_type_bit");

        context.renameId("minecraft:yellow_flower", "minecraft:dandelion");
    }
}
