package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_17_40 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_17_40();

    private BlockStateUpdater_1_17_40() {
        super(1, 16, 210); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:sculk_catalyst", "bloom", (byte) 0);
    }
}
