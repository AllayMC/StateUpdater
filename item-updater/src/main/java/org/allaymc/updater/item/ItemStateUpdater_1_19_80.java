package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_19_80 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_19_80();

    private ItemStateUpdater_1_19_80() {
        super(1, 19, 80);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:boat",
                new RemapMetaEntry(8, "minecraft:cherry_boat")
        );
        context.remapMeta("minecraft:chest_boat",
                new RemapMetaEntry(8, "minecraft:cherry_chest_boat")
        );
        context.remapMeta("minecraft:fence",
                new RemapMetaEntry(0, "minecraft:oak_fence"),
                new RemapMetaEntry(1, "minecraft:spruce_fence"),
                new RemapMetaEntry(2, "minecraft:birch_fence"),
                new RemapMetaEntry(3, "minecraft:jungle_fence"),
                new RemapMetaEntry(4, "minecraft:acacia_fence"),
                new RemapMetaEntry(5, "minecraft:dark_oak_fence")
        );
        context.remapMeta("minecraft:log",
                new RemapMetaEntry(0, "minecraft:oak_log"),
                new RemapMetaEntry(1, "minecraft:spruce_log"),
                new RemapMetaEntry(2, "minecraft:birch_log"),
                new RemapMetaEntry(3, "minecraft:jungle_log"),
                new RemapMetaEntry(5, "minecraft:spruce_log"),
                new RemapMetaEntry(6, "minecraft:birch_log"),
                new RemapMetaEntry(7, "minecraft:jungle_log"),
                new RemapMetaEntry(9, "minecraft:spruce_log"),
                new RemapMetaEntry(10, "minecraft:birch_log"),
                new RemapMetaEntry(11, "minecraft:jungle_log")
        );
        context.remapMeta("minecraft:log2",
                new RemapMetaEntry(0, "minecraft:acacia_log"),
                new RemapMetaEntry(1, "minecraft:dark_oak_log"),
                new RemapMetaEntry(5, "minecraft:dark_oak_log"),
                new RemapMetaEntry(9, "minecraft:dark_oak_log")
        );
    }
}
