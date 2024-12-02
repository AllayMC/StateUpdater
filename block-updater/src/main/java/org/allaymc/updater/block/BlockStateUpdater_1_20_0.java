package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_0();

    private BlockStateUpdater_1_20_0() {
        super(1, 20, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var direction_00 = new RemapValue[]{
                new RemapValue(0, "south"),
                new RemapValue(1, "west"),
                new RemapValue(2, "north"),
                new RemapValue(3, "east")
        };
        context.remapValues("minecraft:carved_pumpkin", "direction", direction_00);
        context.remapValues("minecraft:lit_pumpkin", "direction", direction_00);
        context.remapValues("minecraft:pumpkin", "direction", direction_00);
        context.remapValues("minecraft:sculk_sensor", "powered_bit",
                new RemapValue((byte) 0, 0),
                new RemapValue((byte) 1, 1)
        );

        context.remapState("minecraft:carpet", "minecraft:", "color", "_carpet",
                new RemapValue("silver", "light_gray")
        );
        context.remapState("minecraft:coral", oldState -> oldState.match("dead_bit", "0"), "minecraft:", "coral_color", "_coral",
                new RemapValue("blue", "tube"),
                new RemapValue("pink", "brain"),
                new RemapValue("purple", "bubble"),
                new RemapValue("red", "fire"),
                new RemapValue("yellow", "horn")
        );
        context.remapState("minecraft:coral", oldState -> oldState.match("dead_bit", "1"), "minecraft:dead_", "coral_color", "_coral",
                new RemapValue("blue", "tube"),
                new RemapValue("pink", "brain"),
                new RemapValue("purple", "bubble"),
                new RemapValue("red", "fire"),
                new RemapValue("yellow", "horn")
        );

        context.addProperty("minecraft:calibrated_sculk_sensor", "sculk_sensor_phase", 0);

        context.removeProperty("minecraft:calibrated_sculk_sensor", "powered_bit");

        context.renameProperty("minecraft:carved_pumpkin", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:lit_pumpkin", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:pumpkin", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:sculk_sensor", "powered_bit", "sculk_sensor_phase");

        context.renameId("minecraft:lava_cauldron", "minecraft:cauldron");
    }
}
