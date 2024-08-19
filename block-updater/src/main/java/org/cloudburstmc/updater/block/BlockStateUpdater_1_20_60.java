package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_60 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_60();

    private BlockStateUpdater_1_20_60() {
        super(1, 20, 60);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        // TODO: remappedStates
    }
}
