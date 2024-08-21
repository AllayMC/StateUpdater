package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

public class BlockStateUpdater_1_13_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_13_0();

    private BlockStateUpdater_1_13_0() {
        super(1, 14, 0); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:bone_block", "direction", "pillar_axis");
        context.renameProperty("minecraft:frame", "weirdo_direction", "facing_direction");
        context.renameProperty("minecraft:hay_block", "direction", "pillar_axis");
        context.renameProperty("minecraft:lever", "facing_direction", "lever_direction");
        context.renameProperty("minecraft:purpur_block", "direction", "pillar_axis");
        context.renameProperty("minecraft:quartz_block", "direction", "pillar_axis");
        context.renameProperty("minecraft:stripped_acacia_log", "direction", "pillar_axis");
        context.renameProperty("minecraft:stripped_birch_log", "direction", "pillar_axis");
        context.renameProperty("minecraft:stripped_dark_oak_log", "direction", "pillar_axis");
        context.renameProperty("minecraft:stripped_jungle_log", "direction", "pillar_axis");
        context.renameProperty("minecraft:stripped_oak_log", "direction", "pillar_axis");
        context.renameProperty("minecraft:stripped_spruce_log", "direction", "pillar_axis");

        context.addProperty("minecraft:coral", "dead_bit", (byte) 0);
        context.addProperty("minecraft:wood", "pillar_axis", "y");

        var facing_direction_00 = new RemapValue[]{
                new RemapValue(6, 0),
                new RemapValue(7, 0)
        };
        context.remapValues("minecraft:acacia_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:acacia_wall_sign", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:barrel", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:birch_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:birch_wall_sign", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:black_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:blast_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:blue_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:brown_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:chain_command_block", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:chest", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:command_block", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:cyan_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:dark_oak_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:darkoak_wall_sign", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:dispenser", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:dropper", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:ender_chest", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:gray_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:green_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:hopper", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:jigsaw", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:jungle_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:jungle_wall_sign", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:ladder", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:light_blue_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lime_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lit_blast_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lit_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lit_smoker", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:magenta_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:observer", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:orange_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:pink_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:piston", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:pistonArmCollision", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:purple_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:red_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:repeating_command_block", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:silver_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:skull", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:smoker", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:spruce_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:spruce_wall_sign", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:sticky_piston", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:stone_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:stonecutter_block", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:trapped_chest", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:wall_banner", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:wall_sign", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:white_glazed_terracotta", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:wooden_button", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:yellow_glazed_terracotta", "facing_direction", facing_direction_00);

        var rail_direction_00 = new RemapValue[]{
                new RemapValue(6, 0),
                new RemapValue(7, 0)
        };
        context.remapValues("minecraft:activator_rail", "rail_direction", rail_direction_00);
        context.remapValues("minecraft:detector_rail", "rail_direction", rail_direction_00);
        context.remapValues("minecraft:golden_rail", "rail_direction", rail_direction_00);

        var direction_00 = new RemapValue[]{
                new RemapValue(0, "y"),
                new RemapValue(1, "x"),
                new RemapValue(2, "z"),
                new RemapValue(3, "y")
        };
        context.remapValues("minecraft:bone_block", "direction", direction_00);
        context.remapValues("minecraft:hay_block", "direction", direction_00);
        context.remapValues("minecraft:purpur_block", "direction", direction_00);
        context.remapValues("minecraft:quartz_block", "direction", direction_00);
        context.remapValues("minecraft:stripped_acacia_log", "direction", direction_00);
        context.remapValues("minecraft:stripped_birch_log", "direction", direction_00);
        context.remapValues("minecraft:stripped_dark_oak_log", "direction", direction_00);
        context.remapValues("minecraft:stripped_jungle_log", "direction", direction_00);
        context.remapValues("minecraft:stripped_oak_log", "direction", direction_00);
        context.remapValues("minecraft:stripped_spruce_log", "direction", direction_00);
        context.remapValues("minecraft:cake", "bite_counter",
                new RemapValue(7, 0)
        );

        var fill_level_00 = new RemapValue[]{
                new RemapValue(7, 6)
        };
        context.remapValues("minecraft:cauldron", "fill_level", fill_level_00);
        context.remapValues("minecraft:lava_cauldron", "fill_level", fill_level_00);
        context.remapValues("minecraft:chorus_flower", "age",
                new RemapValue(6, 0),
                new RemapValue(7, 0)
        );
        context.remapValues("minecraft:cocoa", "age",
                new RemapValue(3, 0)
        );
        context.remapValues("minecraft:composter", "composter_fill_level",
                new RemapValue(9, 0),
                new RemapValue(10, 0),
                new RemapValue(11, 0),
                new RemapValue(12, 0),
                new RemapValue(13, 0),
                new RemapValue(14, 0),
                new RemapValue(15, 0)
        );
        context.remapValues("minecraft:frame", "weirdo_direction",
                new RemapValue(0, 5),
                new RemapValue(1, 4),
                new RemapValue(2, 3),
                new RemapValue(3, 2)
        );
        context.remapValues("minecraft:lever", "facing_direction",
                new RemapValue(0, "down_east_west"),
                new RemapValue(1, "east"),
                new RemapValue(2, "west"),
                new RemapValue(3, "south"),
                new RemapValue(4, "north"),
                new RemapValue(5, "up_north_south"),
                new RemapValue(6, "up_east_west"),
                new RemapValue(7, "down_north_south")
        );
        context.remapValues("minecraft:rail", "rail_direction",
                new RemapValue(10, 0),
                new RemapValue(11, 0),
                new RemapValue(12, 0),
                new RemapValue(13, 0),
                new RemapValue(14, 0),
                new RemapValue(15, 0)
        );

        context.addUpdater()
                .match("name", "minecraft:end_rod")
                .match("facing_direction", "6")
                .replaceValue("name", "minecraft:light_block")
                .addProperty("block_light_level", 14)
                .removeProperty("facing_direction");
        context.addUpdater()
                .match("name", "minecraft:end_rod")
                .match("facing_direction", "7")
                .replaceValue("name", "minecraft:light_block")
                .addProperty("block_light_level", 14)
                .removeProperty("facing_direction");

        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "3")
                .match("old_log_type", "birch")
                .replaceValue("name", "minecraft:wood")
                .addProperty("pillar_axis", "y")
                .addProperty("stripped_bit", (byte) 0)
                .addProperty("wood_type", "birch")
                .removeProperty("direction")
                .removeProperty("old_log_type");
        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "3")
                .match("old_log_type", "jungle")
                .replaceValue("name", "minecraft:wood")
                .addProperty("pillar_axis", "y")
                .addProperty("stripped_bit", (byte) 0)
                .addProperty("wood_type", "jungle")
                .removeProperty("direction")
                .removeProperty("old_log_type");
        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "3")
                .match("old_log_type", "oak")
                .replaceValue("name", "minecraft:wood")
                .addProperty("pillar_axis", "y")
                .addProperty("stripped_bit", (byte) 0)
                .addProperty("wood_type", "oak")
                .removeProperty("direction")
                .removeProperty("old_log_type");
        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "3")
                .match("old_log_type", "spruce")
                .replaceValue("name", "minecraft:wood")
                .addProperty("pillar_axis", "y")
                .addProperty("stripped_bit", (byte) 0)
                .addProperty("wood_type", "spruce")
                .removeProperty("direction")
                .removeProperty("old_log_type");
        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "0")
                .addProperty("pillar_axis", "y")
                .removeProperty("direction");
        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "1")
                .addProperty("pillar_axis", "x")
                .removeProperty("direction");
        context.addUpdater()
                .match("name", "minecraft:log")
                .match("direction", "2")
                .addProperty("pillar_axis", "z")
                .removeProperty("direction");

        context.addUpdater()
                .match("name", "minecraft:log2")
                .match("direction", "3")
                .match("new_log_type", "acacia")
                .replaceValue("name", "minecraft:wood")
                .addProperty("pillar_axis", "y")
                .addProperty("stripped_bit", (byte) 0)
                .addProperty("wood_type", "acacia")
                .removeProperty("direction")
                .removeProperty("new_log_type");
        context.addUpdater()
                .match("name", "minecraft:log2")
                .match("direction", "3")
                .match("new_log_type", "dark_oak")
                .replaceValue("name", "minecraft:wood")
                .addProperty("pillar_axis", "y")
                .addProperty("stripped_bit", (byte) 0)
                .addProperty("wood_type", "dark_oak")
                .removeProperty("direction")
                .removeProperty("new_log_type");
        context.addUpdater()
                .match("name", "minecraft:log2")
                .match("direction", "0")
                .addProperty("pillar_axis", "y")
                .removeProperty("direction");
        context.addUpdater()
                .match("name", "minecraft:log2")
                .match("direction", "1")
                .addProperty("pillar_axis", "x")
                .removeProperty("direction");
        context.addUpdater()
                .match("name", "minecraft:log2")
                .match("direction", "2")
                .addProperty("pillar_axis", "z")
                .removeProperty("direction");
    }
}
