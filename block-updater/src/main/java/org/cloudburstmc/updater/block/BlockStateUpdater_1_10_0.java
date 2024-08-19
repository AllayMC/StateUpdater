package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_10_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_10_0();

    private BlockStateUpdater_1_10_0() {
        super(1, 10, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
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

        // TODO: remappedPropertyValues
    }
}
