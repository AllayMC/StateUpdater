package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.common.StateUpdater;

/**
 * @author IWareQ
 */
public abstract class BlockStateUpdater extends StateUpdater<BlockUpdaterContext> {
    public BlockStateUpdater(int major, int minor, int patch) {
        super(major, minor, patch);
    }
}
