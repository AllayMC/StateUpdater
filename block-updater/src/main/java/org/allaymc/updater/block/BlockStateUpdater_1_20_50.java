package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

public class BlockStateUpdater_1_20_50 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_50();

    private BlockStateUpdater_1_20_50() {
        super(1, 20, 50);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:planks", "minecraft:", "wood_type", "_planks");
        context.remapState("minecraft:stone", "minecraft:", "stone_type", "",
                new RemapValue("andesite_smooth", "polished_andesite"),
                new RemapValue("diorite_smooth", "polished_diorite"),
                new RemapValue("granite_smooth", "polished_granite")
        );
    }
}
