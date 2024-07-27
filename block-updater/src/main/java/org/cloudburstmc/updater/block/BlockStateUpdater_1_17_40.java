package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.common.CompoundTagUpdaterContext;
import org.cloudburstmc.updater.common.StateUpdater;

public class BlockStateUpdater_1_17_40 implements StateUpdater {
    public static final StateUpdater INSTANCE = new BlockStateUpdater_1_17_40();

    @Override
    public void registerUpdaters(CompoundTagUpdaterContext context) {
        context.addUpdater(1, 16, 210, true) // Palette version wasn't bumped so far
                .match("name", "minecraft:sculk_catalyst")
                .visit("states")
                .tryAdd("bloom", (byte) 0);
    }
}
