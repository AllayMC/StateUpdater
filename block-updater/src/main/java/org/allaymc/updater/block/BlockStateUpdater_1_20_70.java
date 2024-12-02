package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_70 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_70();

    private BlockStateUpdater_1_20_70() {
        super(1, 20, 70);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:double_wooden_slab", "minecraft:", "wood_type", "_double_slab");
        context.remapState("minecraft:leaves", "minecraft:", "old_leaf_type", "_leaves");
        context.remapState("minecraft:leaves2", "minecraft:", "new_leaf_type", "_leaves");
        context.remapState("minecraft:wooden_slab", "minecraft:", "wood_type", "_slab");
        context.remapState("minecraft:wood", oldState -> oldState.match("stripped_bit", "0"), "minecraft:", "wood_type", "_wood");
        context.remapState("minecraft:wood", oldState -> oldState.match("stripped_bit", "1"), "minecraft:stripped_", "wood_type", "_wood");

        context.renameId("minecraft:grass", "minecraft:grass_block");
    }
}
