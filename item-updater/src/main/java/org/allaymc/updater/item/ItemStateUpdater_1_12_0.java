package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_12_0 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_12_0();

    private ItemStateUpdater_1_12_0() {
        super(1, 12, 0);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:glazedterracotta.black", "minecraft:black_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.blue", "minecraft:blue_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.brown", "minecraft:brown_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.cyan", "minecraft:cyan_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.gray", "minecraft:gray_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.green", "minecraft:green_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.light_blue", "minecraft:light_blue_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.lime", "minecraft:lime_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.magenta", "minecraft:magenta_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.orange", "minecraft:orange_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.pink", "minecraft:pink_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.purple", "minecraft:purple_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.red", "minecraft:red_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.silver", "minecraft:silver_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.white", "minecraft:white_glazed_terracotta");
        context.renameId("minecraft:glazedterracotta.yellow", "minecraft:yellow_glazed_terracotta");
    }
}
