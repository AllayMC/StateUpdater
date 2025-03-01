package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_19_60 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_60();

    private BlockStateUpdater_1_19_60() {
        super(1, 19, 60);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.removeProperty("minecraft:chiseled_bookshelf", "last_interacted_slot");
    }
}
