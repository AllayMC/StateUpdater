package org.cloudburstmc.updater.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.common.context.UpdaterContext;
import org.cloudburstmc.updater.item.context.ItemUpdater;
import org.cloudburstmc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemStateUpdater_1_18_30 implements ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_18_30();

    @Override
    public void registerUpdaters(UpdaterContext<ItemUpdater, ItemUpdater.Builder> context) {
        context.addUpdater(1, 18, 30).remapMeta(
                "minecraft:chest_boat",
                new RemapMetaEntry(0, "minecraft:oak_chest_boat"),
                new RemapMetaEntry(1, "minecraft:spruce_chest_boat"),
                new RemapMetaEntry(2, "minecraft:birch_chest_boat"),
                new RemapMetaEntry(3, "minecraft:jungle_chest_boat"),
                new RemapMetaEntry(4, "minecraft:acacia_chest_boat"),
                new RemapMetaEntry(5, "minecraft:dark_oak_chest_boat")
        ).remapMeta(
                "minecraft:spawn_egg",
                new RemapMetaEntry(131, "minecraft:warden_spawn_egg")
        );

        context.addUpdater(1, 18, 30)
                .renameId("minecraft:concretepowder", "minecraft:concrete_powder")
                .renameId("minecraft:invisiblebedrock", "minecraft:invisible_bedrock")
                .renameId("minecraft:movingblock", "minecraft:moving_block")
                .renameId("minecraft:pistonarmcollision", "minecraft:piston_arm_collision")
                .renameId("minecraft:sealantern", "minecraft:sea_lantern")
                .renameId("minecraft:stickypistonarmcollision", "minecraft:sticky_piston_arm_collision");
    }
}
