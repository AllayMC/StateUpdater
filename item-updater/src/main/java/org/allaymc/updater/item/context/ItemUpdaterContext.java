package org.allaymc.updater.item.context;

import org.allaymc.updater.common.context.UpdaterContext;

import java.util.Arrays;

/**
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
                    var meta = Integer.parseInt(helper.getTag().toString());
                    var remap = Arrays.stream(remaps)
                            .filter(entry -> entry.meta() == meta)
                            .findFirst();

                    remap.ifPresent(entry -> helper.replaceWith("Name", entry.name()));
                });
    }

    public void renameId(String oldId, String newId) {
        this.addUpdater().renameId("Name", oldId, newId);
    }
}
