package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.CopyStates;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_110 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_110();

    private BlockStateUpdater_1_21_110() {
        super(1, 21, 110);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameId("minecraft:chain", "minecraft:iron_chain");
        context.addProperty("minecraft:lightning_rod", "powered_bit", (byte) 0);
    }
}
