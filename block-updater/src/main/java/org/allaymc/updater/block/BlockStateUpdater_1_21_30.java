package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_30 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_30();

    private BlockStateUpdater_1_21_30() {
        super(1, 21, 30);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:chemistry_table", "minecraft:", "chemistry_table_type", "");
        context.remapState("minecraft:cobblestone_wall", "minecraft:", "wall_block_type", "_wall",
                new RemapValue("end_brick", "end_stone_brick")
        );
        context.remapState("minecraft:colored_torch_bp", "minecraft:colored_torch_", "color_bit", "",
                new RemapValue("0", "blue"),
                new RemapValue("1", "purple"),
                new RemapValue("dummy", "map_not_list")
        );
        context.remapState("minecraft:colored_torch_rg", "minecraft:colored_torch_", "color_bit", "",
                new RemapValue("0", "red"),
                new RemapValue("1", "green"),
                new RemapValue("dummy", "map_not_list")
        );
        context.remapState("minecraft:purpur_block", "minecraft:", "chisel_type", "",
                new RemapValue("chiseled", "deprecated_purpur_block_1"),
                new RemapValue("default", "purpur_block"),
                new RemapValue("lines", "purpur_pillar"),
                new RemapValue("smooth", "deprecated_purpur_block_2")
        );
        context.remapState("minecraft:sponge", "minecraft:", "sponge_type", "sponge",
                new RemapValue("dry", ""),
                new RemapValue("wet", "wet_")
        );
        context.remapState("minecraft:tnt", "minecraft:", "allow_underwater_bit", "tnt",
                new RemapValue("0", ""),
                new RemapValue("1", "underwater_"),
                new RemapValue("dummy", "map_not_list")
        );

        context.removeProperty("minecraft:structure_void", "structure_void_type");
    }
}
