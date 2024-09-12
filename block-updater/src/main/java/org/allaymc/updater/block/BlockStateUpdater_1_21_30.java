package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 2024/09/12
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_21_30 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_30();

    private BlockStateUpdater_1_21_30() {
        super(1, 21, 20);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:chemistry_table", "minecraft:", "chemistry_table_type", "");
        context.remapState("minecraft:cobblestone_wall", "minecraft:", "wall_block_type", "_wall",
                new RemapValue("end_brick", "end_stone_brick")
        );

        context.addUpdater()
                .match("name", "minecraft:colored_torch_bp")
                .visit("states")
                .match("color_bit", "0")
                .removeProperty("color_bit")
                .popVisit()
                .replaceValue("name", "minecraft:colored_torch_blue");
        context.addUpdater()
                .match("name", "minecraft:colored_torch_bp")
                .visit("states")
                .match("color_bit", "1")
                .removeProperty("color_bit")
                .popVisit()
                .replaceValue("name", "minecraft:colored_torch_purple");

        context.addUpdater()
                .match("name", "minecraft:colored_torch_rg")
                .visit("states")
                .match("color_bit", "0")
                .removeProperty("color_bit")
                .popVisit()
                .replaceValue("name", "minecraft:colored_torch_red");
        context.addUpdater()
                .match("name", "minecraft:colored_torch_rg")
                .visit("states")
                .match("color_bit", "1")
                .removeProperty("color_bit")
                .popVisit()
                .replaceValue("name", "minecraft:colored_torch_green");

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

        context.addUpdater()
                .match("name", "minecraft:tnt")
                .visit("states")
                .match("allow_underwater_bit", "0")
                .removeProperty("allow_underwater_bit")
                .popVisit()
                .replaceValue("name", "minecraft:tnt");
        context.addUpdater()
                .match("name", "minecraft:tnt")
                .visit("states")
                .match("allow_underwater_bit", "1")
                .removeProperty("allow_underwater_bit")
                .popVisit()
                .replaceValue("name", "minecraft:underwater_tnt");

        context.removeProperty("minecraft:structure_void", "structure_void_type");
    }
}
