package org.cloudburstmc.updater.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.common.context.UpdaterContext;
import org.cloudburstmc.updater.item.context.ItemUpdater;
import org.cloudburstmc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemStateUpdater_1_17_30 implements ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_17_30();

    @Override
    public void registerUpdaters(UpdaterContext<ItemUpdater, ItemUpdater.Builder> context) {
        context.addUpdater(1, 17, 30).remapMeta(
                "minecraft:bucket",
                new RemapMetaEntry(11, "minecraft:powder_snow_bucket"),
                new RemapMetaEntry(12, "minecraft:axolotl_bucket")
        ).remapMeta(
                "minecraft:spawn_egg",
                new RemapMetaEntry(129, "minecraft:glow_squid_spawn_egg"),
                new RemapMetaEntry(130, "minecraft:axolotl_spawn_egg")
        );
    }
}
