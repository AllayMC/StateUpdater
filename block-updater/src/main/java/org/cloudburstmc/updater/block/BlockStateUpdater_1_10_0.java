package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

public class BlockStateUpdater_1_10_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_10_0();

    private BlockStateUpdater_1_10_0() {
        super(1, 10, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var facing_direction_00 = new RemapValue[]{
                new RemapValue(0, 2),
                new RemapValue(1, 2),
                new RemapValue(3, 0),
                new RemapValue(4, 1),
                new RemapValue(5, 3),
                new RemapValue(6, 2),
                new RemapValue(7, 2)
        };
        context.remapValues("minecraft:blast_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:smoker", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:chemistry_table", "mapped_type",
                new RemapValue(0, "compound_creator"),
                new RemapValue(1, "material_reducer"),
                new RemapValue(2, "element_constructor"),
                new RemapValue(3, "lab_table")
        );
        context.remapValues("minecraft:cobblestone_wall", "mapped_type",
                new RemapValue(0, "cobblestone"),
                new RemapValue(1, "mossy_cobblestone"),
                new RemapValue(2, "granite"),
                new RemapValue(3, "diorite"),
                new RemapValue(4, "andesite"),
                new RemapValue(5, "sandstone"),
                new RemapValue(6, "brick"),
                new RemapValue(7, "stone_brick"),
                new RemapValue(8, "mossy_stone_brick"),
                new RemapValue(9, "nether_brick"),
                new RemapValue(10, "end_brick"),
                new RemapValue(11, "prismarine"),
                new RemapValue(12, "red_sandstone"),
                new RemapValue(13, "red_nether_brick"),
                new RemapValue(14, "cobblestone"),
                new RemapValue(15, "cobblestone")
        );
        context.remapValues("minecraft:coral", "mapped_type",
                new RemapValue(0, "blue"),
                new RemapValue(1, "pink"),
                new RemapValue(2, "purple"),
                new RemapValue(3, "red"),
                new RemapValue(4, "yellow"),
                new RemapValue(5, "blue"),
                new RemapValue(6, "blue"),
                new RemapValue(7, "blue"),
                new RemapValue(8, "blue"),
                new RemapValue(9, "blue"),
                new RemapValue(10, "blue"),
                new RemapValue(11, "blue"),
                new RemapValue(12, "blue"),
                new RemapValue(13, "blue"),
                new RemapValue(14, "blue"),
                new RemapValue(15, "blue")
        );

        var mapped_type_03 = new RemapValue[]{
                new RemapValue(0, "blue"),
                new RemapValue(1, "pink"),
                new RemapValue(2, "purple"),
                new RemapValue(3, "red"),
                new RemapValue(4, "yellow"),
                new RemapValue(5, "blue"),
                new RemapValue(6, "blue"),
                new RemapValue(7, "blue")
        };
        context.remapValues("minecraft:coral_block", "mapped_type", mapped_type_03);
        context.remapValues("minecraft:coral_fan", "mapped_type", mapped_type_03);
        context.remapValues("minecraft:coral_fan_dead", "mapped_type", mapped_type_03);
        context.remapValues("minecraft:dirt", "mapped_type",
                new RemapValue(0, "normal"),
                new RemapValue(1, "coarse")
        );
        context.remapValues("minecraft:double_plant", "mapped_type",
                new RemapValue(0, "sunflower"),
                new RemapValue(1, "syringa"),
                new RemapValue(2, "grass"),
                new RemapValue(3, "fern"),
                new RemapValue(4, "rose"),
                new RemapValue(5, "paeonia"),
                new RemapValue(6, "sunflower"),
                new RemapValue(7, "sunflower")
        );
        context.remapValues("minecraft:monster_egg", "mapped_type",
                new RemapValue(0, "stone"),
                new RemapValue(1, "cobblestone"),
                new RemapValue(2, "stone_brick"),
                new RemapValue(3, "mossy_stone_brick"),
                new RemapValue(4, "cracked_stone_brick"),
                new RemapValue(5, "chiseled_stone_brick"),
                new RemapValue(6, "stone"),
                new RemapValue(7, "stone")
        );
        context.remapValues("minecraft:prismarine", "mapped_type",
                new RemapValue(0, "default"),
                new RemapValue(1, "dark"),
                new RemapValue(2, "bricks"),
                new RemapValue(3, "default")
        );
        context.remapValues("minecraft:red_flower", "mapped_type",
                new RemapValue(0, "poppy"),
                new RemapValue(1, "orchid"),
                new RemapValue(2, "allium"),
                new RemapValue(3, "houstonia"),
                new RemapValue(4, "tulip_red"),
                new RemapValue(5, "tulip_orange"),
                new RemapValue(6, "tulip_white"),
                new RemapValue(7, "tulip_pink"),
                new RemapValue(8, "oxeye"),
                new RemapValue(9, "cornflower"),
                new RemapValue(10, "lily_of_the_valley"),
                new RemapValue(11, "poppy"),
                new RemapValue(12, "poppy"),
                new RemapValue(13, "poppy"),
                new RemapValue(14, "poppy"),
                new RemapValue(15, "poppy")
        );
        context.remapValues("minecraft:sand", "mapped_type",
                new RemapValue(0, "normal"),
                new RemapValue(1, "red")
        );
        context.remapValues("minecraft:seagrass", "mapped_type",
                new RemapValue(0, "default"),
                new RemapValue(1, "double_top"),
                new RemapValue(2, "double_bot"),
                new RemapValue(3, "default")
        );
        context.remapValues("minecraft:sponge", "mapped_type",
                new RemapValue(0, "dry"),
                new RemapValue(1, "wet")
        );
        context.remapValues("minecraft:stone", "mapped_type",
                new RemapValue(0, "stone"),
                new RemapValue(1, "granite"),
                new RemapValue(2, "granite_smooth"),
                new RemapValue(3, "diorite"),
                new RemapValue(4, "diorite_smooth"),
                new RemapValue(5, "andesite"),
                new RemapValue(6, "andesite_smooth"),
                new RemapValue(7, "stone")
        );
        context.remapValues("minecraft:stonebrick", "mapped_type",
                new RemapValue(0, "default"),
                new RemapValue(1, "mossy"),
                new RemapValue(2, "cracked"),
                new RemapValue(3, "chiseled"),
                new RemapValue(4, "smooth"),
                new RemapValue(5, "default"),
                new RemapValue(6, "default"),
                new RemapValue(7, "default")
        );
        context.remapValues("minecraft:structure_block", "mapped_type",
                new RemapValue(0, "data"),
                new RemapValue(1, "save"),
                new RemapValue(2, "load"),
                new RemapValue(3, "corner"),
                new RemapValue(4, "invalid"),
                new RemapValue(5, "export"),
                new RemapValue(6, "data"),
                new RemapValue(7, "data")
        );
        context.remapValues("minecraft:tallgrass", "mapped_type",
                new RemapValue(0, "default"),
                new RemapValue(1, "tall"),
                new RemapValue(2, "fern"),
                new RemapValue(3, "snow")
        );

        context.addProperty("minecraft:bell", "attachment", "standing");
        context.addProperty("minecraft:bone_block", "deprecated", 0);
        context.addProperty("minecraft:grindstone", "attachment", "standing");
        context.addProperty("minecraft:hay_block", "deprecated", 0);

        context.removeProperty("minecraft:bone_block", "mapped_type");
        context.removeProperty("minecraft:element_\\d+", "mapped_type", true);
        context.removeProperty("minecraft:grass", "mapped_type");
        context.removeProperty("minecraft:hay_block", "mapped_type");
        context.removeProperty("minecraft:nether_brick_fence", "mapped_type");
        context.removeProperty("minecraft:yellow_flower", "mapped_type");

        context.renameProperty("minecraft:blast_furnace", "facing_direction", "direction");
        context.renameProperty("minecraft:brown_mushroom_block", "mapped_type", "huge_mushroom_bits");
        context.renameProperty("minecraft:chemistry_table", "mapped_type", "chemistry_table_type");
        context.renameProperty("minecraft:cobblestone_wall", "mapped_type", "wall_block_type");
        context.renameProperty("minecraft:coral", "mapped_type", "coral_color");
        context.renameProperty("minecraft:coral_block", "mapped_type", "coral_color");
        context.renameProperty("minecraft:coral_fan", "mapped_type", "coral_color");
        context.renameProperty("minecraft:coral_fan_dead", "mapped_type", "coral_color");
        context.renameProperty("minecraft:coral_fan_hang", "mapped_type", "coral_hang_type_bit");
        context.renameProperty("minecraft:coral_fan_hang2", "mapped_type", "coral_hang_type_bit");
        context.renameProperty("minecraft:coral_fan_hang3", "mapped_type", "coral_hang_type_bit");
        context.renameProperty("minecraft:dirt", "mapped_type", "dirt_type");
        context.renameProperty("minecraft:double_plant", "mapped_type", "double_plant_type");
        context.renameProperty("minecraft:double_stone_slab", "mapped_type", "stone_slab_type");
        context.renameProperty("minecraft:double_stone_slab2", "mapped_type", "stone_slab_type_2");
        context.renameProperty("minecraft:double_stone_slab3", "mapped_type", "stone_slab_type_3");
        context.renameProperty("minecraft:double_stone_slab4", "mapped_type", "stone_slab_type_4");
        context.renameProperty("minecraft:double_wooden_slab", "mapped_type", "wood_type");
        context.renameProperty("minecraft:fence", "mapped_type", "wood_type");
        context.renameProperty("minecraft:leaves", "mapped_type", "old_leaf_type");
        context.renameProperty("minecraft:leaves2", "mapped_type", "new_leaf_type");
        context.renameProperty("minecraft:log", "mapped_type", "old_log_type");
        context.renameProperty("minecraft:log2", "mapped_type", "new_log_type");
        context.renameProperty("minecraft:monster_egg", "mapped_type", "monster_egg_stone_type");
        context.renameProperty("minecraft:planks", "mapped_type", "wood_type");
        context.renameProperty("minecraft:portal", "axis", "portal_axis");
        context.renameProperty("minecraft:prismarine", "mapped_type", "prismarine_block_type");
        context.renameProperty("minecraft:purpur_block", "mapped_type", "chisel_type");
        context.renameProperty("minecraft:quartz_block", "mapped_type", "chisel_type");
        context.renameProperty("minecraft:red_flower", "mapped_type", "flower_type");
        context.renameProperty("minecraft:red_mushroom_block", "mapped_type", "huge_mushroom_bits");
        context.renameProperty("minecraft:red_sandstone", "mapped_type", "sand_stone_type");
        context.renameProperty("minecraft:sand", "mapped_type", "sand_type");
        context.renameProperty("minecraft:sandstone", "mapped_type", "sand_stone_type");
        context.renameProperty("minecraft:seagrass", "mapped_type", "sea_grass_type");
        context.renameProperty("minecraft:smoker", "facing_direction", "direction");
        context.renameProperty("minecraft:sponge", "mapped_type", "sponge_type");
        context.renameProperty("minecraft:stone", "mapped_type", "stone_type");
        context.renameProperty("minecraft:stone_slab", "mapped_type", "stone_slab_type");
        context.renameProperty("minecraft:stone_slab2", "mapped_type", "stone_slab_type_2");
        context.renameProperty("minecraft:stone_slab3", "mapped_type", "stone_slab_type_3");
        context.renameProperty("minecraft:stone_slab4", "mapped_type", "stone_slab_type_4");
        context.renameProperty("minecraft:stonebrick", "mapped_type", "stone_brick_type");
        context.renameProperty("minecraft:structure_block", "mapped_type", "structure_block_type");
        context.renameProperty("minecraft:tallgrass", "mapped_type", "tall_grass_type");
        context.renameProperty("minecraft:wooden_slab", "mapped_type", "wood_type");
    }
}
