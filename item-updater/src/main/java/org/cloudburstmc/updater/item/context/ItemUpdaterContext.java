package org.cloudburstmc.updater.item.context;

import org.cloudburstmc.updater.common.context.UpdaterContext;

import java.util.Arrays;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class ItemUpdaterContext extends UpdaterContext<ItemUpdater, ItemUpdater.Builder> {
    public ItemUpdaterContext() {
        super(ItemUpdater::new);
    }

    public void remapMeta(String name, RemapMetaEntry... remaps) {
        this.addUpdater()
                .match("Name", name)
                .edit("Damage", helper -> {
                    var meta = (int) helper.getTag();
                    var remap = Arrays.stream(remaps)
                            .filter(entry -> entry.meta() == meta)
                            .findFirst()
                            .orElseThrow(() -> new IllegalStateException("Unexpected remap meta '%d' for '%s'".formatted(meta, name)));

                    helper.replaceWith("Name", remap.name());
                });
    }

    public void renameId(String oldId, String newId) {
        this.addUpdater().renameId("Name", oldId, newId);
    }
}
