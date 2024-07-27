package org.cloudburstmc.updater.block.context;

import org.cloudburstmc.updater.common.CompoundTagEditHelper;
import org.cloudburstmc.updater.common.context.BaseUpdater;
import org.cloudburstmc.updater.common.context.filter.HasKeyFilter;

import java.util.LinkedHashMap;
import java.util.Map;
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
        public Builder addCompound(String name) {
            filters.add(COMPOUND_FILTER);
            updaters.add(helper -> helper.getCompoundTag().put(name, new LinkedHashMap<>()));
            return this;
        }

        public Builder remove(String name) {
            filters.add(new HasKeyFilter(name));
            updaters.add(helper -> helper.getCompoundTag().remove(name));
            return this;
        }

        public Builder renameId(String oldId, String newId) {
            return this.renameId("name", oldId, newId);
        }

        public Builder visit(String name) {
            filters.add(new HasKeyFilter(name));
            updaters.add(helper -> helper.pushChild(name));
            return this;
        }

        public Builder addProperty(String key, Object value) {
            filters.add(COMPOUND_FILTER);
            filters.add(new HasKeyFilter(key, true));
            updaters.add(helper -> helper.getCompoundTag().put(key, value));
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
