package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;

/**
 * @author daoge_cmd
 */
public class ItemStateUpdater_1_21_110 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_110();

    private ItemStateUpdater_1_21_110() {
        super(1, 21, 110);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:chain", "minecraft:iron_chain");
    }
}
