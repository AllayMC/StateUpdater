package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 2024/11/04
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_40 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_40();

    private BlockStateUpdater_1_21_40() {
        super(1, 21, 40);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.removeProperty("minecraft:cherry_wood", "stripped_bit");
        context.removeProperty("minecraft:mangrove_wood", "stripped_bit");

        context.renameId("minecraft:skull", "minecraft:skeleton_skull");
    }
}
