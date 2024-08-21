package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

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

        var direction_00 = new RemapValue[]{
                new RemapValue(0, "south"),
                new RemapValue(1, "west"),
                new RemapValue(2, "north"),
                new RemapValue(3, "east")
        };
        context.remapValues("minecraft:anvil", "direction", direction_00);
        context.remapValues("minecraft:big_dripleaf", "direction", direction_00);
        context.remapValues("minecraft:calibrated_sculk_sensor", "direction", direction_00);
        context.remapValues("minecraft:campfire", "direction", direction_00);
        context.remapValues("minecraft:end_portal_frame", "direction", direction_00);
        context.remapValues("minecraft:lectern", "direction", direction_00);
        context.remapValues("minecraft:pink_petals", "direction", direction_00);
        context.remapValues("minecraft:powered_comparator", "direction", direction_00);
        context.remapValues("minecraft:powered_repeater", "direction", direction_00);
        context.remapValues("minecraft:small_dripleaf_block", "direction", direction_00);
        context.remapValues("minecraft:soul_campfire", "direction", direction_00);
        context.remapValues("minecraft:unpowered_comparator", "direction", direction_00);
        context.remapValues("minecraft:unpowered_repeater", "direction", direction_00);

        var facing_direction_00 = new RemapValue[]{
                new RemapValue(0, "south"),
                new RemapValue(1, "west"),
                new RemapValue(2, "north"),
                new RemapValue(3, "south"),
                new RemapValue(4, "west"),
                new RemapValue(5, "east")
        };
        context.remapValues("minecraft:blast_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lit_blast_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lit_furnace", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:lit_smoker", "facing_direction", facing_direction_00);
        context.remapValues("minecraft:smoker", "facing_direction", facing_direction_00);

        context.remapState("minecraft:concrete_powder", "minecraft:", "color", "_concrete_powder",
                new RemapValue("silver", "light_gray")
        );

        context.remapState("minecraft:stained_hardened_clay", "minecraft:", "color", "_terracotta",
                new RemapValue("silver", "light_gray")
        );
    }
}
