package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_19_70 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_19_70();

    private ItemStateUpdater_1_19_70() {
        super(1, 19, 70);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:boat",
                new RemapMetaEntry(7, "minecraft:bamboo_raft")
        );
        context.remapMeta("minecraft:chest_boat",
                new RemapMetaEntry(7, "minecraft:bamboo_chest_raft")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(20, "minecraft:iron_golem_spawn_egg"),
                new RemapMetaEntry(21, "minecraft:snow_golem_spawn_egg"),
                new RemapMetaEntry(52, "minecraft:wither_spawn_egg"),
                new RemapMetaEntry(53, "minecraft:ender_dragon_spawn_egg"),
                new RemapMetaEntry(138, "minecraft:camel_spawn_egg"),
                new RemapMetaEntry(139, "minecraft:sniffer_spawn_egg"),
                new RemapMetaEntry(157, "minecraft:trader_llama_spawn_egg")
        );
        context.remapMeta("minecraft:wool",
                new RemapMetaEntry(0, "minecraft:white_wool"),
                new RemapMetaEntry(1, "minecraft:orange_wool"),
                new RemapMetaEntry(2, "minecraft:magenta_wool"),
                new RemapMetaEntry(3, "minecraft:light_blue_wool"),
                new RemapMetaEntry(4, "minecraft:yellow_wool"),
                new RemapMetaEntry(5, "minecraft:lime_wool"),
                new RemapMetaEntry(6, "minecraft:pink_wool"),
                new RemapMetaEntry(7, "minecraft:gray_wool"),
                new RemapMetaEntry(8, "minecraft:light_gray_wool"),
                new RemapMetaEntry(9, "minecraft:cyan_wool"),
                new RemapMetaEntry(10, "minecraft:purple_wool"),
                new RemapMetaEntry(11, "minecraft:blue_wool"),
                new RemapMetaEntry(12, "minecraft:brown_wool"),
                new RemapMetaEntry(13, "minecraft:green_wool"),
                new RemapMetaEntry(14, "minecraft:red_wool"),
                new RemapMetaEntry(15, "minecraft:black_wool")
        );
    }
}
