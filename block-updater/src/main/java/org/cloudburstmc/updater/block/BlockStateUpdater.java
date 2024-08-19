package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.common.StateUpdater;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public abstract class BlockStateUpdater extends StateUpdater<BlockUpdaterContext> {
    public BlockStateUpdater(int major, int minor, int patch) {
        super(major, minor, patch);
    }
}
