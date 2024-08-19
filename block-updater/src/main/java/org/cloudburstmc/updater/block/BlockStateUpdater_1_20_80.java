package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_80 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_80();

    private BlockStateUpdater_1_20_80() {
        super(1, 20, 80);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.removeProperty("minecraft:bamboo_sapling", "sapling_type");

        // TODO: remappedStates
    }
}
