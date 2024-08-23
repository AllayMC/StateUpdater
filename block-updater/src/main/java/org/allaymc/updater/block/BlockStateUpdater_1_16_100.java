package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_16_100 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_16_100();

    private BlockStateUpdater_1_16_100() {
        super(1, 16, 0); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var facing_direction_00 = new RemapValue[]{
                new RemapValue(1, 0),
                new RemapValue(3, 0),
                new RemapValue(4, 1),
                new RemapValue(5, 3)
        };
        context.remapValues("minecraft:bee_nest", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:beehive", "facing_direction", facing_direction_00);

        context.addProperty("minecraft:chain", "pillar_axis", "y");

        context.renameProperty("minecraft:bee_nest", "facing_direction", "direction");
        context.renameProperty("minecraft:beehive", "facing_direction", "direction");
    }
}
