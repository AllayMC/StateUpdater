package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_18_10 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_18_10();

    private ItemStateUpdater_1_18_10() {
        super(1, 18, 10);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:banner_pattern",
                new RemapMetaEntry(7, "minecraft:globe_banner_pattern")
        );
        context.remapMeta("minecraft:bucket",
                new RemapMetaEntry(13, "minecraft:tadpole_bucket")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(132, "minecraft:frog_spawn_egg"),
                new RemapMetaEntry(133, "minecraft:tadpole_spawn_egg"),
                new RemapMetaEntry(134, "minecraft:allay_spawn_egg"),
                new RemapMetaEntry(135, "minecraft:firefly_spawn_egg")
        );
    }
}
