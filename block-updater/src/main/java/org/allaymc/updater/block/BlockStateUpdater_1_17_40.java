package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_17_40 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_17_40();

    private BlockStateUpdater_1_17_40() {
        super(1, 17, 40);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:sculk_catalyst", "bloom", (byte) 0);
    }
}
