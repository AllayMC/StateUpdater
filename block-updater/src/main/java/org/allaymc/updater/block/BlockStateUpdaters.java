package org.allaymc.updater.block;

import lombok.experimental.UtilityClass;
import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.nbt.NbtMap;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class BlockStateUpdaters {
    public static final int LATEST_VERSION;

    private static final BlockUpdaterContext CONTEXT;

    static {
        List<BlockStateUpdater> updaters = new ArrayList<>();
        updaters.add(BlockStateUpdaterBase.INSTANCE);
        updaters.add(BlockStateUpdater_1_10_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_12_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_13_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_14_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_16_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_16_100.INSTANCE);
        updaters.add(BlockStateUpdater_1_16_210.INSTANCE);
        updaters.add(BlockStateUpdater_1_17_30.INSTANCE);
        updaters.add(BlockStateUpdater_1_17_40.INSTANCE);
        updaters.add(BlockStateUpdater_1_18_10.INSTANCE);
        updaters.add(BlockStateUpdater_1_18_20.INSTANCE);
        updaters.add(BlockStateUpdater_1_18_30.INSTANCE);
        updaters.add(BlockStateUpdater_1_19_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_19_20.INSTANCE);
        updaters.add(BlockStateUpdater_1_19_60.INSTANCE);
        updaters.add(BlockStateUpdater_1_19_70.INSTANCE);
        updaters.add(BlockStateUpdater_1_19_80.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_10.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_20.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_30.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_40.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_50.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_60.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_70.INSTANCE);
        updaters.add(BlockStateUpdater_1_20_80.INSTANCE);
        updaters.add(BlockStateUpdater_1_21_0.INSTANCE);
        updaters.add(BlockStateUpdater_1_21_20.INSTANCE);
        updaters.add(BlockStateUpdater_1_21_30.INSTANCE);

        var context = new BlockUpdaterContext();
        updaters.forEach(updater -> {
            context.setVersion(updater.getVersion());
            updater.registerUpdaters(context);
        });

        CONTEXT = context;
        LATEST_VERSION = context.getLatestVersion();
    }

    public static NbtMap updateBlockState(NbtMap tag, int updateToVersion) {
        return CONTEXT.updateStates(tag, updateToVersion);
    }
}
