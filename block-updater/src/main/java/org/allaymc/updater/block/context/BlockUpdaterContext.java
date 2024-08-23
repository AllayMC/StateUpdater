package org.allaymc.updater.block.context;

import org.allaymc.updater.common.context.UpdaterContext;

import java.util.Arrays;
import java.util.function.Consumer;

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

    public void remapValues(String name, String property, RemapValue... remaps) {
        this.addUpdater()
                .match("name", name)
                .visit("states")
                .tryEdit(property, helper -> {
                    var oldValue = helper.getTag();
                    var remapValue = Arrays.stream(remaps)
                            .filter(entry -> entry.oldValue().equals(oldValue))
                            .findFirst();
                    remapValue.ifPresent(value -> helper.replaceWith(property, value.newValue()));
                });
    }

    public void remapState(String name, String prefix, String property, String suffix) {
        this.remapState(name, prefix, property, suffix, new RemapValue[0]);
    }

    public void remapState(String name, String prefix, String property, String suffix, RemapValue... remaps) {
        remapState(name, $ -> {}, prefix, property, suffix, remaps);
    }

    public void remapState(String name, Consumer<BlockUpdater.Builder> filter, String prefix, String property, String suffix, RemapValue... remaps) {
        var updater = this.addUpdater().match("name", name);
        filter.accept(updater);

        updater.visit("states").edit(property, helper -> {
            var oldValue = helper.getTag();
            var remapValue = Arrays.stream(remaps)
                    .filter(entry -> entry.oldValue().equals(oldValue))
                    .findFirst();
            var newValue = remapValue.isPresent() ? remapValue.get().newValue() : oldValue;
            helper.getRootTag().put("name", prefix + newValue + suffix);
        }).removeProperty(property);
    }
}
