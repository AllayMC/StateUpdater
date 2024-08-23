package org.allaymc.updater.block.context;

import org.allaymc.updater.common.CompoundTagEditHelper;
import org.allaymc.updater.common.context.BaseUpdater;
import org.allaymc.updater.common.context.filter.HasKeyFilter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class BlockUpdater extends BaseUpdater<BlockUpdater, BlockUpdater.Builder> {
    private static final Predicate<CompoundTagEditHelper> COMPOUND_FILTER = helper -> helper.getTag() instanceof Map;

    public BlockUpdater(int version) {
        super(version);
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("UnusedReturnValue")
    public class Builder extends BaseUpdater<BlockUpdater, BlockUpdater.Builder>.Builder {
        public Builder addProperty(String key, Object value) {
            filters.add(COMPOUND_FILTER);
            filters.add(new HasKeyFilter(key, true));
            updaters.add(helper -> helper.getCompoundTag().put(key, value));
            return self();
        }

        public Builder removeProperty(String key) {
            filters.add(COMPOUND_FILTER);
            filters.add(new HasKeyFilter(key));
            updaters.add(helper -> helper.getCompoundTag().remove(key));
            return self();
        }

        public Builder renameProperty(String oldKey, String newKey) {
            filters.add(COMPOUND_FILTER);
            filters.add(new HasKeyFilter(oldKey));
            updaters.add(helper -> {
                var tag = helper.getCompoundTag();
                tag.put(newKey, tag.remove(oldKey));
            });
            return self();
        }

        public Builder addCompound(String key) {
            filters.add(COMPOUND_FILTER);
            updaters.add(helper -> helper.getCompoundTag().put(key, new LinkedHashMap<>()));
            return self();
        }

        public Builder visit(String key) {
            filters.add(helper -> {
                var tag = helper.getTag();
                if (tag instanceof Map && ((Map<String, Object>) tag).containsKey(key)) {
                    helper.pushChild(key);
                    return true;
                }

                return false;
            });
            updaters.add(helper -> helper.pushChild(key));
            return self();
        }

        public Builder popVisit() {
            filters.add(helper -> {
                if (helper.canPopChild()) {
                    helper.popChild();
                    return true;
                }

                return false;
            });
            updaters.add(CompoundTagEditHelper::popChild);
            return this;
        }


        public Builder tryEdit(String name, Consumer<CompoundTagEditHelper> function) {
            updaters.add(helper -> {
                var tag = helper.getTag();
                if (!(tag instanceof Map)) return;

                var compoundTag = (Map<String, Object>) tag;
                if (compoundTag.containsKey(name)) {
                    helper.pushChild(name);
                    function.accept(helper);
                    helper.popChild();
                }
            });
            return self();
        }

        public Builder replaceValue(String property, Object newValue) {
            filters.add(COMPOUND_FILTER);
            filters.add(new HasKeyFilter(property));
            updaters.add(helper -> {
                var tag = helper.getCompoundTag();
                tag.put(property, newValue);
            });
            return self();
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
