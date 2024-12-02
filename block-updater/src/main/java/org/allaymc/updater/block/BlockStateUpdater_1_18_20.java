package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_18_20 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_18_20();

    private BlockStateUpdater_1_18_20() {
        super(1, 18, 10); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:ochre_froglight", "pillar_axis", "y");
        context.addProperty("minecraft:pearlescent_froglight", "pillar_axis", "y");
        context.addProperty("minecraft:verdant_froglight", "pillar_axis", "y");

        context.renameId("minecraft:frog_egg", "minecraft:frog_spawn");
    }
}
