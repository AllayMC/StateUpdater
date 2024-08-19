package org.cloudburstmc.updater.item;

import org.cloudburstmc.updater.common.StateUpdater;
import org.cloudburstmc.updater.item.context.ItemUpdaterContext;

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
