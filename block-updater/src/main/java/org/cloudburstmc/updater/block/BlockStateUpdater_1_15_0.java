package org.cloudburstmc.updater.block;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.common.CompoundTagUpdaterContext;
import org.cloudburstmc.updater.common.StateUpdater;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockStateUpdater_1_15_0 implements StateUpdater {
    public static final StateUpdater INSTANCE = new BlockStateUpdater_1_15_0();

    @Override
    public void registerUpdaters(CompoundTagUpdaterContext context) {
        context.addUpdater(1, 15, 0)
                .match("name", "minecraft:kelp")
                .visit("states")
                .edit("age", helper -> {
                    int age = (int) helper.getTag();
                    helper.replaceWith("kelp_age", age);
                });
    }
}
