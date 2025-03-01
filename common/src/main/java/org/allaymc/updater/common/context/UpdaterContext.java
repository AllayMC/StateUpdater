package org.allaymc.updater.common.context;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.allaymc.updater.common.util.TagUtils;
import org.cloudburstmc.nbt.NbtMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;

/**
 * @author IWareQ
 */
@Setter
@RequiredArgsConstructor
public abstract class UpdaterContext<UPDATER extends BaseUpdater<UPDATER, BUILDER>, BUILDER extends BaseUpdater<UPDATER, BUILDER>.Builder> {
    private final List<UPDATER> updaters = new ArrayList<>();

    private final IntFunction<UPDATER> updaterConstructor;

    protected int version;

    public BUILDER addUpdater() {
        return this.addUpdater(this.version);
    }

    public BUILDER addUpdater(int version) {
        var updater = updaterConstructor.apply(version);
        this.updaters.add(updater);
        return updater.builder();
    }

    public NbtMap updateStates(NbtMap tag, int updateToVersion) {
        var updated = this.updateStates0(tag, updateToVersion);
        return updated == null ? tag : (NbtMap) TagUtils.toImmutable(updated);
    }

    private Map<String, Object> updateStates0(NbtMap tag, int updateToVersion) {
        Map<String, Object> mutableTag = null;
        boolean updated = false;
        for (var updater : this.updaters) {
            if (updater.getVersion() > updateToVersion) {
                continue;
            }

            if (mutableTag == null) {
                mutableTag = (Map<String, Object>) TagUtils.toMutable(tag);
            }

            updated |= updater.update(mutableTag);
        }

        return mutableTag == null || !updated ? null : mutableTag;
    }

    private UPDATER getLatestUpdater() {
        return this.updaters.isEmpty() ? null : this.updaters.getLast();
    }

    public int getLatestVersion() {
        var updater = this.getLatestUpdater();
        return updater == null ? 0 : updater.getVersion();
    }
}
