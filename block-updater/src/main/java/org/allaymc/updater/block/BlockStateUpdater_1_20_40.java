package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 23/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_40 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_40();

    private BlockStateUpdater_1_20_40() {
        super(1, 20, 40);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var facing_direction_00 = new RemapValue[]{
                new RemapValue(0, "north"),
                new RemapValue(1, "north"),
                new RemapValue(2, "north"),
                new RemapValue(3, "south"),
                new RemapValue(4, "west"),
                new RemapValue(5, "east")
        };
        context.remapValues("minecraft:chest", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:ender_chest", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:stonecutter_block", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:trapped_chest", "facing_direction", facing_direction_00);

        context.renameProperty("minecraft:chest", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:ender_chest", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:stonecutter_block", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:trapped_chest", "facing_direction", "minecraft:cardinal_direction");
    }
}
