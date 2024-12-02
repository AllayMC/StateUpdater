package org.allaymc.updater.common.context.filter;

import org.allaymc.updater.common.CompoundTagEditHelper;

import java.util.Map;
import java.util.function.Predicate;

/**
 * @author IWareQ
 */
public record HasKeyFilter(String name, boolean invert) implements Predicate<CompoundTagEditHelper> {
    public HasKeyFilter(String name) {
        this(name, false);
    }

    @Override
    public boolean test(CompoundTagEditHelper helper) {
        var tag = helper.getTag();
        if (!(tag instanceof Map)) return false;
        return invert != ((Map<String, Object>) tag).containsKey(name);
    }
}
