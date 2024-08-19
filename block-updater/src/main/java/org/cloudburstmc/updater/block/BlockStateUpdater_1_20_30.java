package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;

public class BlockStateUpdater_1_20_30 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_30();

    private BlockStateUpdater_1_20_30() {
        super(1, 20, 30);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.renameProperty("minecraft:anvil", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:big_dripleaf", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:blast_furnace", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:calibrated_sculk_sensor", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:campfire", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:end_portal_frame", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:furnace", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:lectern", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:lit_blast_furnace", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:lit_furnace", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:lit_smoker", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:pink_petals", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:powered_comparator", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:powered_repeater", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:small_dripleaf_block", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:smoker", "facing_direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:soul_campfire", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:unpowered_comparator", "direction", "minecraft:cardinal_direction");
        context.renameProperty("minecraft:unpowered_repeater", "direction", "minecraft:cardinal_direction");

        // TODO: remappedPropertyValues
        // TODO: remappedStates
    }
}
