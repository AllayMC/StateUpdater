package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdater;
import org.cloudburstmc.updater.common.context.UpdaterContext;

public class BlockStateUpdater_1_19_0 implements BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_0();

    @Override
    public void registerUpdaters(UpdaterContext<BlockUpdater, BlockUpdater.Builder> context) {
        context.addUpdater(1, 18, 10, true) // Here we go again Mojang
                .renameId("minecraft:stone_slab", "minecraft:stone_block_slab")
                .renameId("minecraft:stone_slab2", "minecraft:stone_block_slab2")
                .renameId("minecraft:stone_slab3", "minecraft:stone_block_slab3")
                .renameId("minecraft:stone_slab4", "minecraft:stone_block_slab4")
                .renameId("minecraft:double_stone_slab", "minecraft:double_stone_block_slab")
                .renameId("minecraft:double_stone_slab2", "minecraft:double_stone_block_slab2")
                .renameId("minecraft:double_stone_slab3", "minecraft:double_stone_block_slab3")
                .renameId("minecraft:double_stone_slab4", "minecraft:double_stone_block_slab4");

        context.addUpdater(1, 18, 10, true) // Here we go again Mojang
                .match("name", "minecraft:sculk_shrieker")
                .visit("states")
                .addProperty("can_summon", (byte) 0);
    }
}
