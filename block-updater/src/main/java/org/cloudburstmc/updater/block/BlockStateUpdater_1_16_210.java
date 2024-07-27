package org.cloudburstmc.updater.block;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.common.CompoundTagUpdaterContext;
import org.cloudburstmc.updater.common.StateUpdater;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockStateUpdater_1_16_210 implements StateUpdater {
    public static final StateUpdater INSTANCE = new BlockStateUpdater_1_16_210();

    private static void registerUpdater(CompoundTagUpdaterContext context, String name) {
        context.addUpdater(1, 16, 210)
                .match("name", name)
                .visit("states")
                .remove("deprecated");
    }

    @Override
    public void registerUpdaters(CompoundTagUpdaterContext context) {
        registerUpdater(context, "minecraft:stripped_crimson_stem");
        registerUpdater(context, "minecraft:stripped_warped_stem");
        registerUpdater(context, "minecraft:stripped_crimson_hyphae");
        registerUpdater(context, "minecraft:stripped_warped_hyphae");
    }
}
