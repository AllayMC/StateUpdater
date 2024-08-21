package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_19_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_19_0();

    private BlockStateUpdater_1_19_0() {
        super(1, 18, 10); // IDK why schema use this version
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addProperty("minecraft:mangrove_propagule", "hanging", (byte) 0);
        context.addProperty("minecraft:mangrove_propagule", "propagule_stage", 0);
        context.addProperty("minecraft:mangrove_propagule_hanging", "hanging", (byte) 1);
        context.addProperty("minecraft:mangrove_propagule_hanging", "propagule_stage", 0);
        context.addProperty("minecraft:sculk_shrieker", "can_summon", (byte) 0);

        context.removeProperty("minecraft:mangrove_propagule", "facing_direction");
        context.removeProperty("minecraft:mangrove_propagule", "growth");
        context.removeProperty("minecraft:mangrove_propagule_hanging", "facing_direction");
        context.removeProperty("minecraft:mangrove_propagule_hanging", "growth");

        context.renameId("minecraft:double_stone_slab", "minecraft:double_stone_block_slab");
        context.renameId("minecraft:double_stone_slab2", "minecraft:double_stone_block_slab2");
        context.renameId("minecraft:double_stone_slab3", "minecraft:double_stone_block_slab3");
        context.renameId("minecraft:double_stone_slab4", "minecraft:double_stone_block_slab4");
        context.renameId("minecraft:mangrove_propagule_hanging", "minecraft:mangrove_propagule");
        context.renameId("minecraft:stone_slab", "minecraft:stone_block_slab");
        context.renameId("minecraft:stone_slab2", "minecraft:stone_block_slab2");
        context.renameId("minecraft:stone_slab3", "minecraft:stone_block_slab3");
        context.renameId("minecraft:stone_slab4", "minecraft:stone_block_slab4");
    }
}
