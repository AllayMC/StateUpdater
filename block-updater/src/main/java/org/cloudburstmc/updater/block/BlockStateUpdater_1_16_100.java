package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

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
        context.renameProperty("minecraft:bee_nest", "facing_direction", "direction");
        context.renameProperty("minecraft:beehive", "facing_direction", "direction");

        context.addProperty("minecraft:chain", "pillar_axis", "y");

        // TODO: remappedPropertyValues
    }
}
