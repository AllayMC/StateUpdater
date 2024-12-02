package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_19_70 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_70();

    private BlockStateUpdater_1_19_70() {
        super(1, 19, 70);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:wool", "minecraft:", "color", "_wool",
                new RemapValue("silver", "light_gray")
        );
    }
}
