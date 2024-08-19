package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_40 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_40();

    private BlockStateUpdater_1_20_40() {
        super(1, 20, 40);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:chest", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:ender_chest", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:stonecutter_block", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:trapped_chest", "facing_direction", "minecraft:cardinal_direction");

        // TODO: remappedPropertyValues
    }
}
