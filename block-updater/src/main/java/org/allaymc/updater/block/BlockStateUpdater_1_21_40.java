package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;

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
        context.addUpdater()
                .match("name", "minecraft:brown_mushroom_block")
                .visit("states")
                .match("huge_mushroom_bits", "10")
                .removeProperty("huge_mushroom_bits")
                .popVisit()
                .replaceValue("name", "minecraft:mushroom_stem");
        context.addUpdater()
                .match("name", "minecraft:brown_mushroom_block")
                .visit("states")
                .match("huge_mushroom_bits", "15")
                .removeProperty("huge_mushroom_bits")
                .popVisit()
                .replaceValue("name", "minecraft:mushroom_stem");

        context.addUpdater()
                .match("name", "minecraft:red_mushroom_block")
                .visit("states")
                .match("huge_mushroom_bits", "10")
                .removeProperty("huge_mushroom_bits")
                .popVisit()
                .replaceValue("name", "minecraft:mushroom_stem");
        context.addUpdater()
                .match("name", "minecraft:red_mushroom_block")
                .visit("states")
                .match("huge_mushroom_bits", "15")
                .removeProperty("huge_mushroom_bits")
                .popVisit()
                .replaceValue("name", "minecraft:mushroom_stem");

        context.removeProperty("minecraft:cherry_wood", "stripped_bit");
        context.removeProperty("minecraft:mangrove_wood", "stripped_bit");

        context.renameId("minecraft:skull", "minecraft:skeleton_skull");
    }
}
