package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_0();

    private BlockStateUpdater_1_20_0() {
        super(1, 20, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameId("minecraft:lava_cauldron", "minecraft:cauldron");

        context.renameProperty("minecraft:carved_pumpkin", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:lit_pumpkin", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:pumpkin", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:sculk_sensor", "powered_bit", "sculk_sensor_phase");

        context.addProperty("minecraft:calibrated_sculk_sensor", "sculk_sensor_phase", 0);

        context.removeProperty("minecraft:calibrated_sculk_sensor", "powered_bit");

        // TODO: remappedPropertyValues
        // TODO: remappedStates
    }
}
