package org.allaymc.updater.item.context;

import org.allaymc.updater.common.context.BaseUpdater;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemUpdater extends BaseUpdater<ItemUpdater, ItemUpdater.Builder> {
    public ItemUpdater(int version) {
        super(version);
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    public class Builder extends BaseUpdater<ItemUpdater, ItemUpdater.Builder>.Builder {
        @Override
        protected Builder self() {
            return this;
        }
    }
}
