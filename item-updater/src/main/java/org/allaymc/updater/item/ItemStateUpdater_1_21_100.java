package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_21_100 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_100();

    private ItemStateUpdater_1_21_100() {
        super(1, 21, 100);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:record_lava_chicken", "minecraft:music_disc_lava_chicken");
        context.renameId("minecraft:record_tears", "minecraft:music_disc_tears");

        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(147, "minecraft:happy_ghast_spawn_egg"),
                new RemapMetaEntry(148, "minecraft:copper_golem_spawn_egg")
        );
    }
}
