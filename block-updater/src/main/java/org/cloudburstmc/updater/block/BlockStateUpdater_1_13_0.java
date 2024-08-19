package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

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

        // TODO: remappedPropertyValues
        // TODO: remappedStates
    }
}
