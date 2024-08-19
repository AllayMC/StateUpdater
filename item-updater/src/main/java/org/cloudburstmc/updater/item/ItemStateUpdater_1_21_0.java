package org.cloudburstmc.updater.item;

import org.cloudburstmc.updater.item.context.ItemUpdaterContext;
import org.cloudburstmc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_21_0 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_0();

    private ItemStateUpdater_1_21_0() {
        super(1, 21, 0);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta(
                "minecraft:coral_block",
                new RemapMetaEntry(0, "minecraft:tube_coral_block"),
                new RemapMetaEntry(1, "minecraft:brain_coral_block"),
                new RemapMetaEntry(2, "minecraft:bubble_coral_block"),
                new RemapMetaEntry(3, "minecraft:fire_coral_block"),
                new RemapMetaEntry(4, "minecraft:horn_coral_block"),
                new RemapMetaEntry(8, "minecraft:dead_tube_coral_block"),
                new RemapMetaEntry(9, "minecraft:dead_brain_coral_block"),
                new RemapMetaEntry(10, "minecraft:dead_bubble_coral_block"),
                new RemapMetaEntry(11, "minecraft:dead_fire_coral_block"),
                new RemapMetaEntry(12, "minecraft:dead_horn_coral_block")
        );
        context.remapMeta(
                "minecraft:double_plant",
                new RemapMetaEntry(0, "minecraft:sunflower"),
                new RemapMetaEntry(1, "minecraft:lilac"),
                new RemapMetaEntry(2, "minecraft:tall_grass"),
                new RemapMetaEntry(3, "minecraft:large_fern"),
                new RemapMetaEntry(4, "minecraft:rose_bush"),
                new RemapMetaEntry(5, "minecraft:peony")
        );
        context.remapMeta(
                "minecraft:stone_block_slab",
                new RemapMetaEntry(0, "minecraft:smooth_stone_slab"),
                new RemapMetaEntry(1, "minecraft:sandstone_slab"),
                new RemapMetaEntry(2, "minecraft:petrified_oak_slab"),
                new RemapMetaEntry(3, "minecraft:cobblestone_slab"),
                new RemapMetaEntry(4, "minecraft:brick_slab"),
                new RemapMetaEntry(5, "minecraft:stone_brick_slab"),
                new RemapMetaEntry(6, "minecraft:quartz_slab"),
                new RemapMetaEntry(7, "minecraft:nether_brick_slab")
        );
        context.remapMeta(
                "minecraft:tallgrass",
                new RemapMetaEntry(0, "minecraft:short_grass"),
                new RemapMetaEntry(2, "minecraft:fern"),
                new RemapMetaEntry(3, "minecraft:fern")
        );

        context.renameId("minecraft:record_creator", "minecraft:music_disc_creator");
        context.renameId("minecraft:record_creator_music_box", "minecraft:music_disc_creator_music_box");
        context.renameId("minecraft:record_precipice", "minecraft:music_disc_precipice");
    }
}
