package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_30 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_30();

    private ItemStateUpdater_1_20_30() {
        super(1, 20, 30);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:concrete_powder",
                new RemapMetaEntry(0, "minecraft:white_concrete_powder"),
                new RemapMetaEntry(1, "minecraft:orange_concrete_powder"),
                new RemapMetaEntry(2, "minecraft:magenta_concrete_powder"),
                new RemapMetaEntry(3, "minecraft:light_blue_concrete_powder"),
                new RemapMetaEntry(4, "minecraft:yellow_concrete_powder"),
                new RemapMetaEntry(5, "minecraft:lime_concrete_powder"),
                new RemapMetaEntry(6, "minecraft:pink_concrete_powder"),
                new RemapMetaEntry(7, "minecraft:gray_concrete_powder"),
                new RemapMetaEntry(8, "minecraft:light_gray_concrete_powder"),
                new RemapMetaEntry(9, "minecraft:cyan_concrete_powder"),
                new RemapMetaEntry(10, "minecraft:purple_concrete_powder"),
                new RemapMetaEntry(11, "minecraft:blue_concrete_powder"),
                new RemapMetaEntry(12, "minecraft:brown_concrete_powder"),
                new RemapMetaEntry(13, "minecraft:green_concrete_powder"),
                new RemapMetaEntry(14, "minecraft:red_concrete_powder"),
                new RemapMetaEntry(15, "minecraft:black_concrete_powder")
        );
        context.remapMeta("minecraft:stained_hardened_clay",
                new RemapMetaEntry(0, "minecraft:white_terracotta"),
                new RemapMetaEntry(1, "minecraft:orange_terracotta"),
                new RemapMetaEntry(2, "minecraft:magenta_terracotta"),
                new RemapMetaEntry(3, "minecraft:light_blue_terracotta"),
                new RemapMetaEntry(4, "minecraft:yellow_terracotta"),
                new RemapMetaEntry(5, "minecraft:lime_terracotta"),
                new RemapMetaEntry(6, "minecraft:pink_terracotta"),
                new RemapMetaEntry(7, "minecraft:gray_terracotta"),
                new RemapMetaEntry(8, "minecraft:light_gray_terracotta"),
                new RemapMetaEntry(9, "minecraft:cyan_terracotta"),
                new RemapMetaEntry(10, "minecraft:purple_terracotta"),
                new RemapMetaEntry(11, "minecraft:blue_terracotta"),
                new RemapMetaEntry(12, "minecraft:brown_terracotta"),
                new RemapMetaEntry(13, "minecraft:green_terracotta"),
                new RemapMetaEntry(14, "minecraft:red_terracotta"),
                new RemapMetaEntry(15, "minecraft:black_terracotta")
        );
    }
}
