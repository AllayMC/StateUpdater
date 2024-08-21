package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_20();

    private BlockStateUpdater_1_21_20() {
        super(1, 21, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameId("minecraft:yellow_flower", "minecraft:dandelion");

        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang")
                .match("coral_hang_type_bit", "0")
                .match("dead_bit", "0")
                .replaceValue("name", "minecraft:tube_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang")
                .match("coral_hang_type_bit", "0")
                .match("dead_bit", "1")
                .replaceValue("name", "minecraft:dead_tube_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang")
                .match("coral_hang_type_bit", "1")
                .match("dead_bit", "0")
                .replaceValue("name", "minecraft:brain_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang")
                .match("coral_hang_type_bit", "1")
                .match("dead_bit", "1")
                .replaceValue("name", "minecraft:dead_brain_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");

        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang2")
                .match("coral_hang_type_bit", "0")
                .match("dead_bit", "0")
                .replaceValue("name", "minecraft:bubble_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang2")
                .match("coral_hang_type_bit", "0")
                .match("dead_bit", "1")
                .replaceValue("name", "minecraft:dead_bubble_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang2")
                .match("coral_hang_type_bit", "1")
                .match("dead_bit", "0")
                .replaceValue("name", "minecraft:fire_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang2")
                .match("coral_hang_type_bit", "1")
                .match("dead_bit", "1")
                .replaceValue("name", "minecraft:dead_fire_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");

        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang3")
                .match("coral_hang_type_bit", "0")
                .match("dead_bit", "0")
                .replaceValue("name", "minecraft:horn_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang3")
                .match("coral_hang_type_bit", "0")
                .match("dead_bit", "1")
                .replaceValue("name", "minecraft:dead_horn_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang3")
                .match("coral_hang_type_bit", "1")
                .match("dead_bit", "0")
                .replaceValue("name", "minecraft:horn_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");
        context.addUpdater()
                .match("name", "minecraft:coral_fan_hang3")
                .match("coral_hang_type_bit", "1")
                .match("dead_bit", "1")
                .replaceValue("name", "minecraft:dead_horn_coral_wall_fan")
                .removeProperty("coral_hang_type_bit")
                .removeProperty("dead_bit");

        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "0")
                .replaceValue("name", "minecraft:light_block_0")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "10")
                .replaceValue("name", "minecraft:light_block_10")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "11")
                .replaceValue("name", "minecraft:light_block_11")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "12")
                .replaceValue("name", "minecraft:light_block_12")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "13")
                .replaceValue("name", "minecraft:light_block_13")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "14")
                .replaceValue("name", "minecraft:light_block_14")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "15")
                .replaceValue("name", "minecraft:light_block_15")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "1")
                .replaceValue("name", "minecraft:light_block_1")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "2")
                .replaceValue("name", "minecraft:light_block_2")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "3")
                .replaceValue("name", "minecraft:light_block_3")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "4")
                .replaceValue("name", "minecraft:light_block_4")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "5")
                .replaceValue("name", "minecraft:light_block_5")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "6")
                .replaceValue("name", "minecraft:light_block_6")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "7")
                .replaceValue("name", "minecraft:light_block_7")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "8")
                .replaceValue("name", "minecraft:light_block_8")
                .removeProperty("block_light_level");
        context.addUpdater()
                .match("name", "minecraft:light_block")
                .match("block_light_level", "9")
                .replaceValue("name", "minecraft:light_block_9")
                .removeProperty("block_light_level");

        context.addUpdater()
                .match("name", "minecraft:stonebrick")
                .match("stone_brick_type", "chiseled")
                .replaceValue("name", "minecraft:chiseled_stone_bricks")
                .removeProperty("stone_brick_type");
        context.addUpdater()
                .match("name", "minecraft:stonebrick")
                .match("stone_brick_type", "cracked")
                .replaceValue("name", "minecraft:cracked_stone_bricks")
                .removeProperty("stone_brick_type");
        context.addUpdater()
                .match("name", "minecraft:stonebrick")
                .match("stone_brick_type", "default")
                .replaceValue("name", "minecraft:stone_bricks")
                .removeProperty("stone_brick_type");
        context.addUpdater()
                .match("name", "minecraft:stonebrick")
                .match("stone_brick_type", "mossy")
                .replaceValue("name", "minecraft:mossy_stone_bricks")
                .removeProperty("stone_brick_type");
        context.addUpdater()
                .match("name", "minecraft:stonebrick")
                .match("stone_brick_type", "smooth")
                .replaceValue("name", "minecraft:stone_bricks")
                .removeProperty("stone_brick_type");

        context.remapState("minecraft:anvil", "minecraft:", "damage", "anvil",
                new RemapValue("broken", "deprecated_"),
                new RemapValue("slightly_damaged", "chipped_"),
                new RemapValue("undamaged", ""),
                new RemapValue("very_damaged", "damaged_")
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
    }
}
