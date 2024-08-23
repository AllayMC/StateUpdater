package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_80 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_80();

    private ItemStateUpdater_1_20_80() {
        super(1, 20, 80);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:coral_fan",
                new RemapMetaEntry(0, "minecraft:tube_coral_fan"),
                new RemapMetaEntry(1, "minecraft:brain_coral_fan"),
                new RemapMetaEntry(2, "minecraft:bubble_coral_fan"),
                new RemapMetaEntry(3, "minecraft:fire_coral_fan"),
                new RemapMetaEntry(4, "minecraft:horn_coral_fan")
        );
        context.remapMeta("minecraft:coral_fan_dead",
                new RemapMetaEntry(0, "minecraft:dead_tube_coral_fan"),
                new RemapMetaEntry(1, "minecraft:dead_brain_coral_fan"),
                new RemapMetaEntry(2, "minecraft:dead_bubble_coral_fan"),
                new RemapMetaEntry(3, "minecraft:dead_fire_coral_fan"),
                new RemapMetaEntry(4, "minecraft:dead_horn_coral_fan")
        );
        context.remapMeta("minecraft:red_flower",
                new RemapMetaEntry(0, "minecraft:poppy"),
                new RemapMetaEntry(1, "minecraft:blue_orchid"),
                new RemapMetaEntry(2, "minecraft:allium"),
                new RemapMetaEntry(3, "minecraft:azure_bluet"),
                new RemapMetaEntry(4, "minecraft:red_tulip"),
                new RemapMetaEntry(5, "minecraft:orange_tulip"),
                new RemapMetaEntry(6, "minecraft:white_tulip"),
                new RemapMetaEntry(7, "minecraft:pink_tulip"),
                new RemapMetaEntry(8, "minecraft:oxeye_daisy"),
                new RemapMetaEntry(9, "minecraft:cornflower"),
                new RemapMetaEntry(10, "minecraft:lily_of_the_valley")
        );
        context.remapMeta("minecraft:sapling",
                new RemapMetaEntry(0, "minecraft:oak_sapling"),
                new RemapMetaEntry(1, "minecraft:spruce_sapling"),
                new RemapMetaEntry(2, "minecraft:birch_sapling"),
                new RemapMetaEntry(3, "minecraft:jungle_sapling"),
                new RemapMetaEntry(4, "minecraft:acacia_sapling"),
                new RemapMetaEntry(5, "minecraft:dark_oak_sapling")
        );
    }
}
