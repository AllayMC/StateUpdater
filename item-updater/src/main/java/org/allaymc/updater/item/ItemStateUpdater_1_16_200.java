package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_16_200 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_16_200();

    private ItemStateUpdater_1_16_200() {
        super(1, 16, 200);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(128, "minecraft:goat_spawn_egg")
        );
    }
}
