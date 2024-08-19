package org.cloudburstmc.updater.block.context;

import org.cloudburstmc.updater.common.context.UpdaterContext;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class BlockUpdaterContext extends UpdaterContext<BlockUpdater, BlockUpdater.Builder> {
    public BlockUpdaterContext() {
        super(BlockUpdater::new);
    }

    public void addProperty(String name, String key, Object value) {
        this.addProperty(name, key, value, false);
    }

    public void addProperty(String name, String key, Object value, boolean regex) {
        this.addUpdater()
                .match("name", name, regex)
                .visit("states")
                .addProperty(key, value);
    }

    public void removeProperty(String name, String key) {
        this.removeProperty(name, key, false);
    }

    public void removeProperty(String name, String key, boolean regex) {
        this.addUpdater()
                .match("name", name, regex)
                .visit("states")
                .removeProperty(key);
    }

    public void renameProperty(String name, String oldKey, String newKey) {
        this.renameProperty(name, oldKey, newKey, false);
    }

    public void renameProperty(String name, String oldKey, String newKey, boolean regex) {
        this.addUpdater()
                .match("name", name, regex)
                .visit("states")
                .renameProperty(oldKey, newKey);
    }

    public void renameId(String oldId, String newId) {
        this.addUpdater().renameId("Name", oldId, newId);
    }
}
