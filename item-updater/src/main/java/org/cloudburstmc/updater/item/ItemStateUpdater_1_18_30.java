package org.cloudburstmc.updater.item;

import org.cloudburstmc.updater.item.context.ItemUpdaterContext;
import org.cloudburstmc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_18_30 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_18_30();

    private ItemStateUpdater_1_18_30() {
        super(1, 18, 30);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta(
                "minecraft:chest_boat",
                new RemapMetaEntry(0, "minecraft:oak_chest_boat"),
                new RemapMetaEntry(1, "minecraft:spruce_chest_boat"),
                new RemapMetaEntry(2, "minecraft:birch_chest_boat"),
                new RemapMetaEntry(3, "minecraft:jungle_chest_boat"),
                new RemapMetaEntry(4, "minecraft:acacia_chest_boat"),
                new RemapMetaEntry(5, "minecraft:dark_oak_chest_boat")
        );
        context.remapMeta(
                "minecraft:spawn_egg",
                new RemapMetaEntry(131, "minecraft:warden_spawn_egg")
        );

        context.renameId("minecraft:concretepowder", "minecraft:concrete_powder");
        context.renameId("minecraft:invisiblebedrock", "minecraft:invisible_bedrock");
        context.renameId("minecraft:movingblock", "minecraft:moving_block");
        context.renameId("minecraft:pistonarmcollision", "minecraft:piston_arm_collision");
        context.renameId("minecraft:sealantern", "minecraft:sea_lantern");
        context.renameId("minecraft:stickypistonarmcollision", "minecraft:sticky_piston_arm_collision");
    }
}
