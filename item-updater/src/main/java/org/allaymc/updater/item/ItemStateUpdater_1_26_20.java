package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_26_20 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_26_20();

    private ItemStateUpdater_1_26_20() {
        super(1, 26, 20);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:bucket",
                new RemapMetaEntry(14, "minecraft:sulfur_cube_bucket")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(149, "minecraft:nautilus_spawn_egg"),
                new RemapMetaEntry(150, "minecraft:zombie_nautilus_spawn_egg"),
                new RemapMetaEntry(151, "minecraft:parched_spawn_egg"),
                new RemapMetaEntry(152, "minecraft:camel_husk_spawn_egg"),
                new RemapMetaEntry(153, "minecraft:sulfur_cube_spawn_egg")
        );
    }
}
