package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.CopyStates;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_60 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_60();

    private BlockStateUpdater_1_21_60() {
        super(1, 21, 60);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var direction_00 = new RemapValue[]{
                new RemapValue(0, "south"),
                new RemapValue(1, "west"),
                new RemapValue(2, "north"),
                new RemapValue(3, "east")
        };
        context.remapValues("minecraft:acacia_door", "direction", direction_00);
        context.remapValues("minecraft:acacia_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:bamboo_door", "direction", direction_00);
        context.remapValues("minecraft:bamboo_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:birch_door", "direction", direction_00);
        context.remapValues("minecraft:birch_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:cherry_door", "direction", direction_00);
        context.remapValues("minecraft:cherry_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:copper_door", "direction", direction_00);
        context.remapValues("minecraft:crimson_door", "direction", direction_00);
        context.remapValues("minecraft:crimson_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:dark_oak_door", "direction", direction_00);
        context.remapValues("minecraft:dark_oak_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:exposed_copper_door", "direction", direction_00);
        context.remapValues("minecraft:fence_gate", "direction", direction_00);
        context.remapValues("minecraft:iron_door", "direction", direction_00);
        context.remapValues("minecraft:jungle_door", "direction", direction_00);
        context.remapValues("minecraft:jungle_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:mangrove_door", "direction", direction_00);
        context.remapValues("minecraft:mangrove_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:oxidized_copper_door", "direction", direction_00);
        context.remapValues("minecraft:pale_oak_door", "direction", direction_00);
        context.remapValues("minecraft:pale_oak_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:spruce_door", "direction", direction_00);
        context.remapValues("minecraft:spruce_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:warped_door", "direction", direction_00);
        context.remapValues("minecraft:warped_fence_gate", "direction", direction_00);
        context.remapValues("minecraft:waxed_copper_door", "direction", direction_00);
        context.remapValues("minecraft:waxed_exposed_copper_door", "direction", direction_00);
        context.remapValues("minecraft:waxed_oxidized_copper_door", "direction", direction_00);
        context.remapValues("minecraft:waxed_weathered_copper_door", "direction", direction_00);
        context.remapValues("minecraft:weathered_copper_door", "direction", direction_00);
        context.remapValues("minecraft:wooden_door", "direction", direction_00);
        context.remapValues("minecraft:creaking_heart", "active",
                new RemapValue((byte) 0, "uprooted"),
                new RemapValue((byte) 1, "dormant")
        );

        context.remapState("minecraft:red_mushroom_block", oldState -> oldState.match("huge_mushroom_bits", "10"), "minecraft:mushroom_stem",
                new CopyStates("huge_mushroom_bits")
        );
        context.remapState("minecraft:red_mushroom_block", oldState -> oldState.match("huge_mushroom_bits", "15"), "minecraft:mushroom_stem",
                new CopyStates("huge_mushroom_bits")
        );
        context.remapState("minecraft:red_mushroom_block", "minecraft:red_mushroom_block",
                new CopyStates("huge_mushroom_bits")
        );

        context.renameProperty("minecraft:acacia_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:acacia_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:bamboo_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:bamboo_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:birch_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:birch_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:cherry_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:cherry_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:creaking_heart", "active", "creaking_heart_state");
        context.renameProperty("minecraft:crimson_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:crimson_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:dark_oak_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:dark_oak_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:exposed_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:iron_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:jungle_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:jungle_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:mangrove_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:mangrove_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:oxidized_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:pale_oak_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:pale_oak_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:spruce_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:spruce_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:warped_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:warped_fence_gate", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:waxed_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:waxed_exposed_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:waxed_oxidized_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:waxed_weathered_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:weathered_copper_door", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:wooden_door", "direction", "minecraft:cardinal_direction");
    }
}
