package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_0 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_0();

    private ItemStateUpdater_1_20_0() {
        super(1, 20, 0);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:record_relic", "minecraft:music_disc_relic");

        context.remapMeta("minecraft:carpet",
                new RemapMetaEntry(0, "minecraft:white_carpet"),
                new RemapMetaEntry(1, "minecraft:orange_carpet"),
                new RemapMetaEntry(2, "minecraft:magenta_carpet"),
                new RemapMetaEntry(3, "minecraft:light_blue_carpet"),
                new RemapMetaEntry(4, "minecraft:yellow_carpet"),
                new RemapMetaEntry(5, "minecraft:lime_carpet"),
                new RemapMetaEntry(6, "minecraft:pink_carpet"),
                new RemapMetaEntry(7, "minecraft:gray_carpet"),
                new RemapMetaEntry(8, "minecraft:light_gray_carpet"),
                new RemapMetaEntry(9, "minecraft:cyan_carpet"),
                new RemapMetaEntry(10, "minecraft:purple_carpet"),
                new RemapMetaEntry(11, "minecraft:blue_carpet"),
                new RemapMetaEntry(12, "minecraft:brown_carpet"),
                new RemapMetaEntry(13, "minecraft:green_carpet"),
                new RemapMetaEntry(14, "minecraft:red_carpet"),
                new RemapMetaEntry(15, "minecraft:black_carpet")
        );
        context.remapMeta("minecraft:coral",
                new RemapMetaEntry(0, "minecraft:tube_coral"),
                new RemapMetaEntry(1, "minecraft:brain_coral"),
                new RemapMetaEntry(2, "minecraft:bubble_coral"),
                new RemapMetaEntry(3, "minecraft:fire_coral"),
                new RemapMetaEntry(4, "minecraft:horn_coral"),
                new RemapMetaEntry(8, "minecraft:dead_tube_coral"),
                new RemapMetaEntry(9, "minecraft:dead_brain_coral"),
                new RemapMetaEntry(10, "minecraft:dead_bubble_coral"),
                new RemapMetaEntry(11, "minecraft:dead_fire_coral"),
                new RemapMetaEntry(12, "minecraft:dead_horn_coral")
        );
    }
}
