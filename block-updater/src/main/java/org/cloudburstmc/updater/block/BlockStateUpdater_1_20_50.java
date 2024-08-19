package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_50 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_50();

    private BlockStateUpdater_1_20_50() {
        super(1, 20, 50);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        // TODO: remappedStates
    }
}
