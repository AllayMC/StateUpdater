package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_14_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_14_0();

    private BlockStateUpdater_1_14_0() {
        super(1, 14, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:kelp", "age", "kelp_age");
    }
}
