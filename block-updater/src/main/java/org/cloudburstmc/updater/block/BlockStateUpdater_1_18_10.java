package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_18_10 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_18_10();

    private BlockStateUpdater_1_18_10() {
        super(1, 18, 10);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.removeProperty("minecraft:skull", "no_drop_bit");

        // TODO: remappedPropertyValues
    }
}
