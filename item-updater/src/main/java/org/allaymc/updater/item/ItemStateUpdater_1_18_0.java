package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_18_0 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_18_0();

    private ItemStateUpdater_1_18_0() {
        super(1, 18, 0);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:record_otherside", "minecraft:music_disc_otherside");
    }
}
