package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_12_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_12_0();

    private BlockStateUpdater_1_12_0() {
        super(1, 12, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:blast_furnace", "direction", "facing_direction");
        context.renameProperty("minecraft:composter", "fill_level", "composter_fill_level");
        context.renameProperty("minecraft:coral_fan", "direction", "coral_fan_direction");
        context.renameProperty("minecraft:coral_fan_dead", "direction", "coral_fan_direction");
        context.renameProperty("minecraft:smoker", "direction", "facing_direction");

        context.addProperty("minecraft:barrel", "open_bit", (byte) 0);
        context.addProperty("minecraft:bell", "toggle_bit", (byte) 0);
        context.addProperty("minecraft:campfire", "direction", 0);
        context.addProperty("minecraft:campfire", "extinguished", (byte) 0);
        context.addProperty("minecraft:lectern", "powered_bit", (byte) 0);

        // TODO: remappedPropertyValues
    }
}
