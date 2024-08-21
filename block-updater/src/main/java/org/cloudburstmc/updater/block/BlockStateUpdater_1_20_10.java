package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

public class BlockStateUpdater_1_20_10 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_10();

    private BlockStateUpdater_1_20_10() {
        super(1, 20, 10);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:observer", "facing_direction", "minecraft:facing_direction");

        context.remapValues("minecraft:observer", "facing_direction",
                new RemapValue(0, "down"),
                new RemapValue(1, "up"),
                new RemapValue(2, "north"),
                new RemapValue(3, "south"),
                new RemapValue(4, "west"),
                new RemapValue(5, "east")
        );

        context.remapState("minecraft:concrete", "minecraft:", "color", "_concrete",
                new RemapValue("silver", "light_gray")
        );

        context.remapState("minecraft:shulker_box", "minecraft:", "color", "_shulker_box",
                new RemapValue("silver", "light_gray")
        );
    }
}
