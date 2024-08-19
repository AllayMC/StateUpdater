package org.cloudburstmc.updater.common;

import lombok.Getter;
import org.cloudburstmc.updater.common.context.UpdaterContext;

@Getter
public abstract class StateUpdater<CONTEXT extends UpdaterContext> {
    private final int version;

    public StateUpdater(int major, int minor, int patch) {
        this.version = UpdaterContext.makeVersion(major, minor, patch);
    }

    public abstract void registerUpdaters(CONTEXT context);
}
