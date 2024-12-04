package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_21_50 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_50();

    private ItemStateUpdater_1_21_50() {
        super(1, 21, 50);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:boat",
                new RemapMetaEntry(9, "minecraft:pale_oak_boat")
        );
        context.remapMeta("minecraft:chest_boat",
                new RemapMetaEntry(9, "minecraft:pale_oak_chest_boat")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(146, "minecraft:creaking_spawn_egg")
        );
    }
}
