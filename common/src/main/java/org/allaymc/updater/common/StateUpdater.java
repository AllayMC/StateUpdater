package org.allaymc.updater.common;

import lombok.Getter;
import org.allaymc.updater.common.context.UpdaterContext;

@Getter
public abstract class StateUpdater<CONTEXT extends UpdaterContext<?, ?>> {
    private final int version;

    public StateUpdater(int major, int minor, int patch) {
        this.version = makeVersion(major, minor, patch);
    }

    public abstract void registerUpdaters(CONTEXT context);

    private int makeVersion(int major, int minor, int patch) {
        return (patch << 8) | (minor << 16) | (major << 24);
    }
}
