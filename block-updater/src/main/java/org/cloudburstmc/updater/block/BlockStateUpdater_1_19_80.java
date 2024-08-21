package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_19_80 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_80();

    private BlockStateUpdater_1_19_80() {
        super(1, 19, 80);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:fence", "minecraft:", "wood_type", "_fence");
        context.remapState("minecraft:log", "minecraft:", "old_log_type", "_log");
        context.remapState("minecraft:log2", "minecraft:", "new_log_type", "_log");
    }
}
