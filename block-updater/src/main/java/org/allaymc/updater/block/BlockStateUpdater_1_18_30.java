package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_18_30 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_18_30();

    private BlockStateUpdater_1_18_30() {
        super(1, 18, 30);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameId("minecraft:concretePowder", "minecraft:concrete_powder");
        context.renameId("minecraft:invisibleBedrock", "minecraft:invisible_bedrock");
        context.renameId("minecraft:movingBlock", "minecraft:moving_block");
        context.renameId("minecraft:mysterious_frame", "minecraft:reinforced_deepslate");
        context.renameId("minecraft:mysterious_frame_slot", "minecraft:reinforced_deepslate");
        context.renameId("minecraft:pistonArmCollision", "minecraft:piston_arm_collision");
        context.renameId("minecraft:seaLantern", "minecraft:sea_lantern");
        context.renameId("minecraft:stickyPistonArmCollision", "minecraft:sticky_piston_arm_collision");
        context.renameId("minecraft:tripWire", "minecraft:trip_wire");
    }
}
