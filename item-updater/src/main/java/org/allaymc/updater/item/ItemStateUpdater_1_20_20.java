package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_20 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_20();

    private ItemStateUpdater_1_20_20() {
        super(1, 20, 20);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:stained_glass",
                new RemapMetaEntry(0, "minecraft:white_stained_glass"),
                new RemapMetaEntry(1, "minecraft:orange_stained_glass"),
                new RemapMetaEntry(2, "minecraft:magenta_stained_glass"),
                new RemapMetaEntry(3, "minecraft:light_blue_stained_glass"),
                new RemapMetaEntry(4, "minecraft:yellow_stained_glass"),
                new RemapMetaEntry(5, "minecraft:lime_stained_glass"),
                new RemapMetaEntry(6, "minecraft:pink_stained_glass"),
                new RemapMetaEntry(7, "minecraft:gray_stained_glass"),
                new RemapMetaEntry(8, "minecraft:light_gray_stained_glass"),
                new RemapMetaEntry(9, "minecraft:cyan_stained_glass"),
                new RemapMetaEntry(10, "minecraft:purple_stained_glass"),
                new RemapMetaEntry(11, "minecraft:blue_stained_glass"),
                new RemapMetaEntry(12, "minecraft:brown_stained_glass"),
                new RemapMetaEntry(13, "minecraft:green_stained_glass"),
                new RemapMetaEntry(14, "minecraft:red_stained_glass"),
                new RemapMetaEntry(15, "minecraft:black_stained_glass")
        );
        context.remapMeta("minecraft:stained_glass_pane",
                new RemapMetaEntry(0, "minecraft:white_stained_glass_pane"),
                new RemapMetaEntry(1, "minecraft:orange_stained_glass_pane"),
                new RemapMetaEntry(2, "minecraft:magenta_stained_glass_pane"),
                new RemapMetaEntry(3, "minecraft:light_blue_stained_glass_pane"),
                new RemapMetaEntry(4, "minecraft:yellow_stained_glass_pane"),
                new RemapMetaEntry(5, "minecraft:lime_stained_glass_pane"),
                new RemapMetaEntry(6, "minecraft:pink_stained_glass_pane"),
                new RemapMetaEntry(7, "minecraft:gray_stained_glass_pane"),
                new RemapMetaEntry(8, "minecraft:light_gray_stained_glass_pane"),
                new RemapMetaEntry(9, "minecraft:cyan_stained_glass_pane"),
                new RemapMetaEntry(10, "minecraft:purple_stained_glass_pane"),
                new RemapMetaEntry(11, "minecraft:blue_stained_glass_pane"),
                new RemapMetaEntry(12, "minecraft:brown_stained_glass_pane"),
                new RemapMetaEntry(13, "minecraft:green_stained_glass_pane"),
                new RemapMetaEntry(14, "minecraft:red_stained_glass_pane"),
                new RemapMetaEntry(15, "minecraft:black_stained_glass_pane")
        );
    }
}
