package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * StateUpdater Project 23/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_17_30 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_17_30();

    private BlockStateUpdater_1_17_30() {
        super(1, 16, 210); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:frame", "item_frame_photo_bit", (byte) 0);
        context.addProperty("minecraft:glow_frame", "item_frame_photo_bit", (byte) 0);
    }
}
