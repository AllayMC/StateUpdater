package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_16_210 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_16_210();

    private BlockStateUpdater_1_16_210() {
        super(1, 16, 210);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.removeProperty("minecraft:stripped_crimson_hyphae", "deprecated");
        context.removeProperty("minecraft:stripped_crimson_stem", "deprecated");
        context.removeProperty("minecraft:stripped_warped_hyphae", "deprecated");
        context.removeProperty("minecraft:stripped_warped_stem", "deprecated");
    }
}
