package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_21_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_0();

    private BlockStateUpdater_1_21_0() {
        super(1, 21, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:trial_spawner", "ominous", (byte) 0);
        context.addProperty("minecraft:vault", "ominous", (byte) 0);

        // TODO: remappedStates
    }
}
