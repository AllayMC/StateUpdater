package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_17_30 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_17_30();

    private ItemStateUpdater_1_17_30() {
        super(1, 17, 30);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:bucket",
                new RemapMetaEntry(11, "minecraft:powder_snow_bucket"),
                new RemapMetaEntry(12, "minecraft:axolotl_bucket")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(129, "minecraft:glow_squid_spawn_egg"),
                new RemapMetaEntry(130, "minecraft:axolotl_spawn_egg")
        );
    }
}
