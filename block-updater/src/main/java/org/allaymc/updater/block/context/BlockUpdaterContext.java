package org.allaymc.updater.block.context;

import org.allaymc.updater.common.context.UpdaterContext;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Consumer;

/**
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
        this.addUpdater().renameId("name", oldId, newId);
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

    public void remapState(String name, String newName, StateEditor... editors) {
        remapState(name, $ -> {}, newName, editors);
    }

    public void remapState(String name, Consumer<BlockUpdater.Builder> filter, String newName, StateEditor... editors) {
        remapState(name, filter, newName, "", "", editors);
    }

    public void remapState(String name, String prefix, String property, String suffix) {
        this.remapState(name, prefix, property, suffix, new RemapValue[0]);
    }

    public void remapState(String name, String prefix, String property, String suffix, StateEditor... editors) {
        remapState(name, $ -> {}, prefix, property, suffix, editors);
    }

    public void remapState(String name, Consumer<BlockUpdater.Builder> filter, String prefix, String property, String suffix, StateEditor... editors) {
        var updater = this.addUpdater()
                .match("name", name)
                .visit("states");
        filter.accept(updater);

        updater.edit(property, helper -> {
            var oldValue = String.valueOf(helper.getTag());
            var remapValue = Arrays.stream(editors)
                    .filter(RemapValue.class::isInstance)
                    .map(RemapValue.class::cast)
                    .filter(entry -> entry.oldValue().equals(oldValue))
                    .findFirst()
                    .map(RemapValue::newValue)
                    .orElse(oldValue);
            helper.getRootTag().put("name", prefix + remapValue + suffix);
        }).removeProperty(property);

        updater.popVisit().edit("states", helper -> {
            var copiedStates = Arrays.stream(editors)
                    .filter(CopyStates.class::isInstance)
                    .map(CopyStates.class::cast)
                    .map(CopyStates::states).findFirst();
            copiedStates.ifPresent(states -> {
                var preservedStates = Set.of(states);
                var nbt = helper.getCompoundTag();
                nbt.keySet().removeIf(key -> !preservedStates.contains(key));
            });
        });

        var newStates = Arrays.stream(editors)
                .filter(NewState.class::isInstance)
                .map(NewState.class::cast).toList();
        if (!newStates.isEmpty()) {
            updater.visit("states");
            newStates.forEach(newState -> {
                updater.addProperty(newState.name(), newState.value());
            });
        }
    }
}
