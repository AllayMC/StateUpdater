package org.allaymc.updater.item;

import org.allaymc.updater.common.StateUpdater;
import org.allaymc.updater.item.context.ItemUpdaterContext;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public abstract class ItemStateUpdater extends StateUpdater<ItemUpdaterContext> {
    public ItemStateUpdater(int major, int minor, int patch) {
        super(major, minor, patch);
    }
}
