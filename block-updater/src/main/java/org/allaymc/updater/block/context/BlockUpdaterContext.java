package org.allaymc.updater.block.context;

import org.allaymc.updater.common.context.UpdaterContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author IWareQ
 */
public class BlockUpdaterContext extends UpdaterContext<BlockUpdater, BlockUpdater.Builder> {
    public BlockUpdaterContext() {
        super(BlockUpdater::new);
    }

    public void registerSchema(Consumer<BlockUpdaterContext> remaps, Consumer<BlockUpdaterContext> changes) {
        List<BlockUpdater> remapUpdaters = new ArrayList<>();
        List<BlockUpdater> changeUpdaters = new ArrayList<>();
        remaps.accept(collectingContext(remapUpdaters));
        changes.accept(collectingContext(changeUpdaters));
        this.addUpdater().edit("states", helper -> {
            var tag = helper.getRootTag();
            for (var updater : remapUpdaters) {
                if (updater.update(tag)) {
                    return;
                }
            }
            changeUpdaters.forEach(updater -> updater.update(tag));
        });
    }

    private static BlockUpdaterContext collectingContext(List<BlockUpdater> updaters) {
        return new BlockUpdaterContext() {
            @Override
            public BlockUpdater.Builder addUpdater(int version) {
                var updater = new BlockUpdater(version);
                updaters.add(updater);
                return updater.builder();
            }
        };
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
        this.remapState(name, $ -> {}, newName, editors);
    }

    public void remapState(String name, Consumer<BlockUpdater.Builder> filter, String newName, StateEditor... editors) {
        this.remapState(name, filter, newName, null, "", null, editors);
    }

    public void remapState(String name, String prefix, String property, String suffix) {
        this.remapState(name, prefix, property, suffix, new RemapValue[0]);
    }

    public void remapState(String name, String prefix, String property, String suffix, StateEditor... editors) {
        this.remapState(name, $ -> {}, prefix, property, suffix, editors);
    }

    public void remapState(String name, String prefix, String property, String suffix, Class<?> propertyType, StateEditor... editors) {
        this.remapState(name, $ -> {}, prefix, property, suffix, propertyType, editors);
    }

    public void remapState(String name, Consumer<BlockUpdater.Builder> filter, String prefix, String property, String suffix, StateEditor... editors) {
        this.remapState(name, filter, prefix, property, suffix, null, editors);
    }

    public void remapState(String name, Consumer<BlockUpdater.Builder> filter, String prefix, String property, String suffix, Class<?> propertyType, StateEditor... editors) {
        var copiedStates = Arrays.stream(editors)
                .filter(CopyStates.class::isInstance)
                .map(CopyStates.class::cast)
                .map(copy -> new HashSet<>(Arrays.asList(copy.states())))
                .findFirst().orElse(null);
        var newStates = Arrays.stream(editors)
                .filter(NewState.class::isInstance)
                .map(NewState.class::cast).toList();
        var valueRemaps = Arrays.stream(editors)
                .filter(RemapValue.class::isInstance)
                .map(RemapValue.class::cast).toList();

        var updater = this.addUpdater()
                .match("name", name)
                .visit("states");
        filter.accept(updater);
        updater.popVisit().edit("states", helper -> {
            var states = helper.getCompoundTag();
            if (states == null) {
                return;
            }

            if (property == null) {
                helper.getRootTag().put("name", prefix);
            } else if (states.containsKey(property) && (propertyType == null || propertyType.isInstance(states.get(property)))) {
                var oldValue = String.valueOf(states.get(property));
                var remappedValue = valueRemaps.stream()
                        .filter(entry -> entry.oldValue().equals(oldValue))
                        .findFirst()
                        .map(RemapValue::newValue)
                        .orElse(oldValue);
                helper.getRootTag().put("name", prefix + remappedValue + suffix);
                if (copiedStates == null) {
                    states.remove(property);
                }
            }

            if (copiedStates != null) {
                states.keySet().retainAll(copiedStates);
            }
            for (var state : newStates) {
                if (copiedStates == null || !copiedStates.contains(state.name()) || !states.containsKey(state.name())) {
                    states.put(state.name(), state.value());
                }
            }
        });
    }
}
