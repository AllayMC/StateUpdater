package org.allaymc.updater.common.context;

import lombok.Getter;
import org.allaymc.updater.common.CompoundTagEditHelper;
import org.allaymc.updater.common.context.filter.HasKeyFilter;
import org.allaymc.updater.common.util.TagUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * @author IWareQ
 */
public abstract class BaseUpdater<UPDATER extends BaseUpdater<UPDATER, BUILDER>, BUILDER extends BaseUpdater<UPDATER, BUILDER>.Builder> implements Comparable<BaseUpdater<UPDATER, BUILDER>> {
    protected final List<Predicate<CompoundTagEditHelper>> filters = new ArrayList<>();
    protected final List<Consumer<CompoundTagEditHelper>> updaters = new ArrayList<>();

    @Getter
    private final int version;

    public BaseUpdater(int version) {
        this.version = version;
    }

    public boolean update(Map<String, Object> tag) {
        var filterHelper = new CompoundTagEditHelper(tag);
        for (var filter : this.filters) {
            if (!filter.test(filterHelper)) {
                return false;
            }
        }

        var updaterHelper = new CompoundTagEditHelper(tag);
        this.updaters.forEach(updater -> updater.accept(updaterHelper));
        return true;
    }

    public abstract BUILDER builder();

    @Override
    public int compareTo(BaseUpdater<UPDATER, BUILDER> other) {
        return Integer.compare(this.version, other.version);
    }

    @SuppressWarnings("UnusedReturnValue")
    public abstract class Builder {
        public BUILDER match(String name, String match) {
            return this.match(name, match, false);
        }

        public BUILDER match(String name, String match, boolean regex) {
            var pattern = regex ? Pattern.compile(match) : null;
            filters.add(helper -> {
                var tag = helper.getTag();
                if (!(tag instanceof Map)) return false;

                var compound = (Map<String, Object>) tag;
                if (!compound.containsKey(name)) return false;

                if (match.isEmpty()) return true;

                var matchTag = compound.get(name);
                var value = TagUtils.getTagValue(matchTag);
                return regex ? pattern.matcher(value).matches() : match.equals(value);
            });
            return self();
        }

        public BUILDER edit(String name, Consumer<CompoundTagEditHelper> function) {
            filters.add(new HasKeyFilter(name));
            updaters.add(helper -> {
                helper.pushChild(name);
                function.accept(helper);
                helper.popChild();
            });
            return self();
        }

        public BUILDER renameId(String key, String oldId, String newId) {
            return this.match(key, oldId).edit(key, helper -> helper.replaceWith(key, newId));
        }

        protected abstract BUILDER self();
    }
}
