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
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
@Setter
@RequiredArgsConstructor
public abstract class UpdaterContext<UPDATER extends BaseUpdater<UPDATER, BUILDER>, BUILDER extends BaseUpdater<UPDATER, BUILDER>.Builder> {
    private final List<UPDATER> updaters = new ArrayList<>();

    private final IntFunction<UPDATER> updaterConstructor;

    protected int version;

    private static int mergeVersions(int baseVersion, int updaterVersion) {
        return updaterVersion | baseVersion;
    }

    private static int baseVersion(int version) {
        return version & 0xFFFFFF00;
    }

    public static int updaterVersion(int version) {
        return version & 0x000000FF;
    }

    public static int makeVersion(int major, int minor, int patch) {
        return (patch << 8) | (minor << 16) | (major << 24);
    }

    public BUILDER addUpdater(int major, int minor, int patch) {
        return this.addUpdater(major, minor, patch, false);
    }

    public BUILDER addUpdater(int major, int minor, int patch, boolean resetVersion) {
        return this.addUpdater(major, minor, patch, resetVersion, true);
    }

    public BUILDER addUpdater(int major, int minor, int patch, boolean resetVersion, boolean bumpVersion) {
        var version = makeVersion(major, minor, patch);
        return this.addUpdater(version, resetVersion, bumpVersion);
    }

    public BUILDER addUpdater() {
        return this.addUpdater(this.version, false, true);
    }

    public BUILDER addUpdater(int version, boolean resetVersion, boolean bumpVersion) {
        var prevUpdater = this.getLatestUpdater();

        var updaterVersion = 0;
        if (!resetVersion && prevUpdater != null && baseVersion(prevUpdater.getVersion()) == version) {
            updaterVersion = updaterVersion(prevUpdater.getVersion());
            if (bumpVersion) {
                updaterVersion++;
            }
        }

        version = mergeVersions(version, updaterVersion);

        var updater = updaterConstructor.apply(version);
        this.updaters.add(updater);
        this.updaters.sort(null);
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
            if (updater.getVersion() > updateToVersion) continue;

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
