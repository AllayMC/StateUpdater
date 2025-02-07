package org.allaymc.updater.common.context.filter;

import org.allaymc.updater.common.CompoundTagEditHelper;

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
        var compoundTag = helper.getCompoundTag();
        if (compoundTag == null) {
            return false;
        }

        return invert != compoundTag.containsKey(name);
    }
}
