package org.allaymc.updater.block.context;

import org.allaymc.updater.common.CompoundTagEditHelper;
import org.allaymc.updater.common.context.BaseUpdater;
import org.allaymc.updater.common.context.filter.HasKeyFilter;

import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author IWareQ
 */
public class BlockUpdater extends BaseUpdater<BlockUpdater, BlockUpdater.Builder> {
    private static final Predicate<CompoundTagEditHelper> COMPOUND_FILTER = helper -> helper.getCompoundTag() != null;

    public BlockUpdater(int version) {
        super(version);
    }

    @Override
    public Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("UnusedReturnValue")
    public class Builder extends BaseUpdater<BlockUpdater, BlockUpdater.Builder>.Builder {
        public Builder matchValue(String key, Object value) {
            BlockUpdater.this.filters.add(helper -> {
                var states = helper.getCompoundTag();
                return states != null && value.equals(states.get(key));
            });
            return this.self();
        }

        public Builder addProperty(String key, Object value) {
            BlockUpdater.this.filters.add(COMPOUND_FILTER);
            BlockUpdater.this.filters.add(new HasKeyFilter(key, true));
            BlockUpdater.this.updaters.add(helper -> helper.getCompoundTag().put(key, value));
            return this.self();
        }

        public Builder removeProperty(String key) {
            BlockUpdater.this.filters.add(COMPOUND_FILTER);
            BlockUpdater.this.filters.add(new HasKeyFilter(key));
            BlockUpdater.this.updaters.add(helper -> helper.getCompoundTag().remove(key));
            return this.self();
        }

        public Builder renameProperty(String oldKey, String newKey) {
            BlockUpdater.this.filters.add(COMPOUND_FILTER);
            BlockUpdater.this.filters.add(new HasKeyFilter(oldKey));
            BlockUpdater.this.updaters.add(helper -> {
                var tag = helper.getCompoundTag();
                tag.put(newKey, tag.remove(oldKey));
            });
            return this.self();
        }

        public Builder addCompound(String key) {
            BlockUpdater.this.filters.add(COMPOUND_FILTER);
            BlockUpdater.this.updaters.add(helper -> helper.getCompoundTag().put(key, new LinkedHashMap<>()));
            return this.self();
        }

        public Builder visit(String key) {
            BlockUpdater.this.filters.add(helper -> {
                var compoundTag = helper.getCompoundTag();
                if (compoundTag == null || !compoundTag.containsKey(key)) {
                    return false;
                }

                helper.pushChild(key);
                return true;
            });
            BlockUpdater.this.updaters.add(helper -> helper.pushChild(key));
            return this.self();
        }

        public Builder popVisit() {
            BlockUpdater.this.filters.add(helper -> {
                if (helper.canPopChild()) {
                    helper.popChild();
                    return true;
                }

                return false;
            });
            BlockUpdater.this.updaters.add(CompoundTagEditHelper::popChild);
            return this;
        }


        public Builder tryEdit(String name, Consumer<CompoundTagEditHelper> function) {
            BlockUpdater.this.updaters.add(helper -> {
                var compoundTag = helper.getCompoundTag();
                if (compoundTag == null || !compoundTag.containsKey(name)) {
                    return;
                }

                helper.pushChild(name);
                function.accept(helper);
                helper.popChild();
            });
            return this.self();
        }

        public Builder replaceValue(String property, Object newValue) {
            BlockUpdater.this.filters.add(COMPOUND_FILTER);
            BlockUpdater.this.filters.add(new HasKeyFilter(property));
            BlockUpdater.this.updaters.add(helper -> {
                var tag = helper.getCompoundTag();
                tag.put(property, newValue);
            });
            return this.self();
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
