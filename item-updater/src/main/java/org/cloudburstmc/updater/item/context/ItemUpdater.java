package org.cloudburstmc.updater.item.context;

import org.cloudburstmc.updater.common.context.BaseUpdater;

import java.util.Arrays;

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

    @SuppressWarnings("UnusedReturnValue")
    public class Builder extends BaseUpdater<ItemUpdater, ItemUpdater.Builder>.Builder {
        public Builder renameId(String oldId, String newId) {
            return this.renameId("Name", oldId, newId);
        }

        public Builder remapMeta(String name, RemapMetaEntry... remaps) {
            return this.match("Name", name)
                    .edit("Damage", helper -> {
                        var meta = (int) helper.getTag();
                        var remap = Arrays.stream(remaps)
                                .filter(entry -> entry.meta() == meta)
                                .findFirst()
                                .orElseThrow(() -> new IllegalStateException("Unexpected remap meta '%d' for '%s'".formatted(meta, name)));

                        helper.replaceWith("Name", remap.name());
                    });
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
