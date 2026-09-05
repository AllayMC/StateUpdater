package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_26_30 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_26_30();

    private BlockStateUpdater_1_26_30() {
        super(1, 26, 30);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:potent_sulfur", "potent_sulfur_state", "dry");
    }
}
