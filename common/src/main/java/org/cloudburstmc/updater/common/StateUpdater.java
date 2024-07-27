package org.cloudburstmc.updater.common;

import org.cloudburstmc.updater.common.context.BaseUpdater;
import org.cloudburstmc.updater.common.context.UpdaterContext;

public interface StateUpdater<UPDATER extends BaseUpdater<UPDATER, BUILDER>, BUILDER extends BaseUpdater<UPDATER, BUILDER>.Builder> {
    void registerUpdaters(UpdaterContext<UPDATER, BUILDER> context);
}
