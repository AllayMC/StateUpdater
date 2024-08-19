package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_70 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_70();

    private BlockStateUpdater_1_20_70() {
        super(1, 20, 70);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameId("minecraft:grass", "minecraft:grass_block");

        // TODO: remappedStates
    }
}
