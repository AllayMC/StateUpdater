package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 23/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_60 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_60();

    private BlockStateUpdater_1_20_60() {
        super(1, 20, 60);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:hard_stained_glass", "minecraft:hard_", "color", "_stained_glass",
                new RemapValue("silver", "light_gray")
        );
        context.remapState("minecraft:hard_stained_glass_pane", "minecraft:hard_", "color", "_stained_glass_pane",
                new RemapValue("silver", "light_gray")
        );
    }
}
