package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_19_80 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_80();

    private BlockStateUpdater_1_19_80() {
        super(1, 19, 80);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        // TODO: remappedStates
    }
}
