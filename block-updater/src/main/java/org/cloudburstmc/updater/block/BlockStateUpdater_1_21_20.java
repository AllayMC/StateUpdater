package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_20();

    private BlockStateUpdater_1_21_20() {
        super(1, 21, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameId("minecraft:yellow_flower", "minecraft:dandelion");

        // TODO: remappedStates
    }
}
