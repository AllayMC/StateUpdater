package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_14_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_14_0();

    private BlockStateUpdater_1_14_0() {
        super(1, 15, 0); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:kelp", "age", "kelp_age");
    }
}