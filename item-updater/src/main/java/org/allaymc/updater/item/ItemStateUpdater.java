package org.allaymc.updater.item;

import org.allaymc.updater.common.StateUpdater;
import org.allaymc.updater.item.context.ItemUpdaterContext;

/**
 * @author IWareQ
 */
public abstract class ItemStateUpdater extends StateUpdater<ItemUpdaterContext> {
    public ItemStateUpdater(int major, int minor, int patch) {
        super(major, minor, patch);
    }
}
