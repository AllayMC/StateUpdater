package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_60 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_60();

    private ItemStateUpdater_1_20_60() {
        super(1, 20, 60);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:scute", "minecraft:turtle_scute");

        context.remapMeta("minecraft:hard_stained_glass",
                new RemapMetaEntry(0, "minecraft:hard_white_stained_glass"),
                new RemapMetaEntry(1, "minecraft:hard_orange_stained_glass"),
                new RemapMetaEntry(2, "minecraft:hard_magenta_stained_glass"),
                new RemapMetaEntry(3, "minecraft:hard_light_blue_stained_glass"),
                new RemapMetaEntry(4, "minecraft:hard_yellow_stained_glass"),
                new RemapMetaEntry(5, "minecraft:hard_lime_stained_glass"),
                new RemapMetaEntry(6, "minecraft:hard_pink_stained_glass"),
                new RemapMetaEntry(7, "minecraft:hard_gray_stained_glass"),
                new RemapMetaEntry(8, "minecraft:hard_light_gray_stained_glass"),
                new RemapMetaEntry(9, "minecraft:hard_cyan_stained_glass"),
                new RemapMetaEntry(10, "minecraft:hard_purple_stained_glass"),
                new RemapMetaEntry(11, "minecraft:hard_blue_stained_glass"),
                new RemapMetaEntry(12, "minecraft:hard_brown_stained_glass"),
                new RemapMetaEntry(13, "minecraft:hard_green_stained_glass"),
                new RemapMetaEntry(14, "minecraft:hard_red_stained_glass"),
                new RemapMetaEntry(15, "minecraft:hard_black_stained_glass")
        );
        context.remapMeta("minecraft:hard_stained_glass_pane",
                new RemapMetaEntry(0, "minecraft:hard_white_stained_glass_pane"),
                new RemapMetaEntry(1, "minecraft:hard_orange_stained_glass_pane"),
                new RemapMetaEntry(2, "minecraft:hard_magenta_stained_glass_pane"),
                new RemapMetaEntry(3, "minecraft:hard_light_blue_stained_glass_pane"),
                new RemapMetaEntry(4, "minecraft:hard_yellow_stained_glass_pane"),
                new RemapMetaEntry(5, "minecraft:hard_lime_stained_glass_pane"),
                new RemapMetaEntry(6, "minecraft:hard_pink_stained_glass_pane"),
                new RemapMetaEntry(7, "minecraft:hard_gray_stained_glass_pane"),
                new RemapMetaEntry(8, "minecraft:hard_light_gray_stained_glass_pane"),
                new RemapMetaEntry(9, "minecraft:hard_cyan_stained_glass_pane"),
                new RemapMetaEntry(10, "minecraft:hard_purple_stained_glass_pane"),
                new RemapMetaEntry(11, "minecraft:hard_blue_stained_glass_pane"),
                new RemapMetaEntry(12, "minecraft:hard_brown_stained_glass_pane"),
                new RemapMetaEntry(13, "minecraft:hard_green_stained_glass_pane"),
                new RemapMetaEntry(14, "minecraft:hard_red_stained_glass_pane"),
                new RemapMetaEntry(15, "minecraft:hard_black_stained_glass_pane")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(140, "minecraft:breeze_spawn_egg"),
                new RemapMetaEntry(142, "minecraft:armadillo_spawn_egg")
        );
    }
}
