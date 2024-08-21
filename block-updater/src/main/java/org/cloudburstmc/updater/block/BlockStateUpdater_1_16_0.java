package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

public class BlockStateUpdater_1_16_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_16_0();

    private BlockStateUpdater_1_16_0() {
        super(1, 16, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapValues("minecraft:cobblestone_wall", "wall_block_type",
                new RemapValue("blackstone", "cobblestone"),
                new RemapValue("polished_blackstone", "cobblestone"),
                new RemapValue("polished_blackstone_brick", "cobblestone")
        );

        context.addProperty("minecraft:cobblestone_wall", "wall_connection_type_east", "none");
        context.addProperty("minecraft:cobblestone_wall", "wall_connection_type_north", "none");
        context.addProperty("minecraft:cobblestone_wall", "wall_connection_type_south", "none");
        context.addProperty("minecraft:cobblestone_wall", "wall_connection_type_west", "none");
        context.addProperty("minecraft:cobblestone_wall", "wall_post_bit", (byte) 0);
        context.addProperty("minecraft:jigsaw", "rotation", 0);
        context.addProperty("minecraft:melon_stem", "facing_direction", 0);
        context.addProperty("minecraft:pumpkin_stem", "facing_direction", 0);

        context.removeProperty("minecraft:blackstone_wall", "wall_block_type");
        context.removeProperty("minecraft:polished_blackstone_brick_wall", "wall_block_type");
        context.removeProperty("minecraft:polished_blackstone_wall", "wall_block_type");

        context.renameId("minecraft:basalt_block", "minecraft:basalt");
        context.renameId("minecraft:blue_fire", "minecraft:soul_fire");
        context.renameId("minecraft:blue_nether_wart_block", "minecraft:warped_wart_block");
        context.renameId("minecraft:crimson_trap_door", "minecraft:crimson_trapdoor");
        context.renameId("minecraft:polished_basalt_block", "minecraft:polished_basalt");
        context.renameId("minecraft:shroomlight_block", "minecraft:shroomlight");
        context.renameId("minecraft:soul_soil_block", "minecraft:soul_soil");
        context.renameId("minecraft:target_block", "minecraft:target");
        context.renameId("minecraft:weeping_vines_block", "minecraft:weeping_vines");
        context.renameId("minecraft:lodestone_block", "minecraft:lodestone");
        context.renameId("minecraft:twisting_vines_block", "minecraft:twisting_vines");
    }
}
