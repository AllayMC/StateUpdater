package org.cloudburstmc.updater.block;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.block.context.BlockUpdater;
import org.cloudburstmc.updater.common.CompoundTagUpdaterContext;
import org.cloudburstmc.updater.common.context.UpdaterContext;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockStateUpdater_1_12_0 implements BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_12_0();

    @Override
    public void registerUpdaters(CompoundTagUpdaterContext context) {
        context.addUpdater(1, 12, 0)
                .match("name", "minecraft:coral_fan")
                .visit("states")
                .rename("direction", "coral_fan_direction");

        context.addUpdater(1, 12, 0)
                .match("name", "minecraft:coral_fan_dead")
                .visit("states")
                .rename("direction", "coral_fan_direction");
    }

    @Override
    public void registerUpdaters(UpdaterContext<BlockUpdater, BlockUpdater.Builder> context) {

    }
}
