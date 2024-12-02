package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_10 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_10();

    private ItemStateUpdater_1_20_10() {
        super(1, 20, 10);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:concrete",
                new RemapMetaEntry(0, "minecraft:white_concrete"),
                new RemapMetaEntry(1, "minecraft:orange_concrete"),
                new RemapMetaEntry(2, "minecraft:magenta_concrete"),
                new RemapMetaEntry(3, "minecraft:light_blue_concrete"),
                new RemapMetaEntry(4, "minecraft:yellow_concrete"),
                new RemapMetaEntry(5, "minecraft:lime_concrete"),
                new RemapMetaEntry(6, "minecraft:pink_concrete"),
                new RemapMetaEntry(7, "minecraft:gray_concrete"),
                new RemapMetaEntry(8, "minecraft:light_gray_concrete"),
                new RemapMetaEntry(9, "minecraft:cyan_concrete"),
                new RemapMetaEntry(10, "minecraft:purple_concrete"),
                new RemapMetaEntry(11, "minecraft:blue_concrete"),
                new RemapMetaEntry(12, "minecraft:brown_concrete"),
                new RemapMetaEntry(13, "minecraft:green_concrete"),
                new RemapMetaEntry(14, "minecraft:red_concrete"),
                new RemapMetaEntry(15, "minecraft:black_concrete")
        );
        context.remapMeta("minecraft:shulker_box",
                new RemapMetaEntry(0, "minecraft:white_shulker_box"),
                new RemapMetaEntry(1, "minecraft:orange_shulker_box"),
                new RemapMetaEntry(2, "minecraft:magenta_shulker_box"),
                new RemapMetaEntry(3, "minecraft:light_blue_shulker_box"),
                new RemapMetaEntry(4, "minecraft:yellow_shulker_box"),
                new RemapMetaEntry(5, "minecraft:lime_shulker_box"),
                new RemapMetaEntry(6, "minecraft:pink_shulker_box"),
                new RemapMetaEntry(7, "minecraft:gray_shulker_box"),
                new RemapMetaEntry(8, "minecraft:light_gray_shulker_box"),
                new RemapMetaEntry(9, "minecraft:cyan_shulker_box"),
                new RemapMetaEntry(10, "minecraft:purple_shulker_box"),
                new RemapMetaEntry(11, "minecraft:blue_shulker_box"),
                new RemapMetaEntry(12, "minecraft:brown_shulker_box"),
                new RemapMetaEntry(13, "minecraft:green_shulker_box"),
                new RemapMetaEntry(14, "minecraft:red_shulker_box"),
                new RemapMetaEntry(15, "minecraft:black_shulker_box")
        );
    }
}
