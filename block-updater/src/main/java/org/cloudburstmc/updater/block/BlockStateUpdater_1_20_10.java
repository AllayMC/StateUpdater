package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_10 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_10();

    private BlockStateUpdater_1_20_10() {
        super(1, 20, 10);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:observer", "facing_direction", "minecraft:facing_direction");

        // TODO: remappedPropertyValues
        // TODO: remappedStates
    }
}
