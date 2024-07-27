package org.cloudburstmc.updater.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.updater.common.context.UpdaterContext;
import org.cloudburstmc.updater.item.context.ItemUpdater;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemStateUpdater_1_12_0 implements ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_12_0();

    @Override
    public void registerUpdaters(UpdaterContext<ItemUpdater, ItemUpdater.Builder> context) {
        context.addUpdater(1, 12, 0)
                .renameId("minecraft:glazedterracotta.black", "minecraft:black_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.blue", "minecraft:blue_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.brown", "minecraft:brown_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.cyan", "minecraft:cyan_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.gray", "minecraft:gray_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.green", "minecraft:green_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.light_blue", "minecraft:light_blue_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.lime", "minecraft:lime_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.magenta", "minecraft:magenta_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.orange", "minecraft:orange_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.pink", "minecraft:pink_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.purple", "minecraft:purple_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.red", "minecraft:red_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.silver", "minecraft:silver_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.white", "minecraft:white_glazed_terracotta")
                .renameId("minecraft:glazedterracotta.yellow", "minecraft:yellow_glazed_terracotta");
    }
}
