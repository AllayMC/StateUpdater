package org.cloudburstmc.updater.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.common.context.UpdaterContext;
import org.cloudburstmc.updater.item.context.ItemUpdater;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemStateUpdater_1_18_0 implements ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_18_0();

    @Override
    public void registerUpdaters(UpdaterContext<ItemUpdater, ItemUpdater.Builder> context) {
        context.addUpdater(1, 18, 0)
                .renameId("minecraft:record_otherside", "minecraft:music_disc_otherside");
    }
}
