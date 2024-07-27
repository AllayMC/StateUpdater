package org.cloudburstmc.updater.block;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.block.context.BlockUpdater;
import org.cloudburstmc.updater.common.context.UpdaterContext;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockStateUpdater_1_10_0 implements BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_10_0();

    @Override
    public void registerUpdaters(UpdaterContext<BlockUpdater, BlockUpdater.Builder> context) {
        // TODO: mapped types. (I'm not sure if these are needed)
    }
}
