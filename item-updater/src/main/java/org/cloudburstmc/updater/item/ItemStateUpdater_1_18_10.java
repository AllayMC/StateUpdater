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
public class ItemStateUpdater_1_18_10 implements ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_18_10();

    @Override
    public void registerUpdaters(UpdaterContext<ItemUpdater, ItemUpdater.Builder> context) {
        context.addUpdater(1, 18, 10).remapMeta(
                "minecraft:banner_pattern",
                new RemapMetaEntry(7, "minecraft:globe_banner_pattern")
        ).remapMeta(
                "minecraft:bucket",
                new RemapMetaEntry(13, "minecraft:tadpole_bucket")
        ).remapMeta(
                "minecraft:spawn_egg",
                new RemapMetaEntry(132, "minecraft:frog_spawn_egg"),
                new RemapMetaEntry(133, "minecraft:tadpole_spawn_egg"),
                new RemapMetaEntry(134, "minecraft:allay_spawn_egg"),
                new RemapMetaEntry(135, "minecraft:firefly_spawn_egg")
        );
    }
}
