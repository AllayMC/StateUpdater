package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.CopyStates;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_40 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_40();

    private BlockStateUpdater_1_21_40() {
        super(1, 21, 40);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:brown_mushroom_block", oldState -> oldState.match("huge_mushroom_bits", "10"), "minecraft:mushroom_stem",
                new CopyStates("huge_mushroom_bits")
        );
        context.remapState("minecraft:brown_mushroom_block", oldState -> oldState.match("huge_mushroom_bits", "15"), "minecraft:mushroom_stem",
                new CopyStates("huge_mushroom_bits")
        );
        context.remapState("minecraft:brown_mushroom_block", "minecraft:brown_mushroom_block",
                new CopyStates("huge_mushroom_bits")
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

        context.removeProperty("minecraft:cherry_wood", "stripped_bit");
        context.removeProperty("minecraft:mangrove_wood", "stripped_bit");

        context.renameId("minecraft:skull", "minecraft:skeleton_skull");
    }
}
