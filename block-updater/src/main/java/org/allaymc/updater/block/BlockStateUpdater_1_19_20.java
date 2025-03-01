package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_19_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_20();

    private BlockStateUpdater_1_19_20() {
        super(1, 19, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:muddy_mangrove_roots", "pillar_axis", "y");
    }
}
