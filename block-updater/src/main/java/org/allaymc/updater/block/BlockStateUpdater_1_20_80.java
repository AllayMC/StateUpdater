package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * @author IWareQ
 */
public class BlockStateUpdater_1_20_80 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_20_80();

    private BlockStateUpdater_1_20_80() {
        super(1, 20, 80);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.remapState("minecraft:coral_fan", "minecraft:", "coral_color", "_coral_fan",
                new RemapValue("blue", "tube"),
                new RemapValue("pink", "brain"),
                new RemapValue("purple", "bubble"),
                new RemapValue("red", "fire"),
                new RemapValue("yellow", "horn")
        );
        context.remapState("minecraft:coral_fan_dead", "minecraft:dead_", "coral_color", "_coral_fan",
                new RemapValue("blue", "tube"),
                new RemapValue("pink", "brain"),
                new RemapValue("purple", "bubble"),
                new RemapValue("red", "fire"),
                new RemapValue("yellow", "horn")
        );
        context.remapState("minecraft:red_flower", "minecraft:", "flower_type", "",
                new RemapValue("houstonia", "azure_bluet"),
                new RemapValue("orchid", "blue_orchid"),
                new RemapValue("oxeye", "oxeye_daisy"),
                new RemapValue("tulip_orange", "orange_tulip"),
                new RemapValue("tulip_pink", "pink_tulip"),
                new RemapValue("tulip_red", "red_tulip"),
                new RemapValue("tulip_white", "white_tulip")
        );
        context.remapState("minecraft:sapling", "minecraft:", "sapling_type", "_sapling");

        context.removeProperty("minecraft:bamboo_sapling", "sapling_type");
    }
}
