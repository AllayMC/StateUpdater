package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_50 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_50();

    private ItemStateUpdater_1_20_50() {
        super(1, 20, 50);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:planks",
                new RemapMetaEntry(0, "minecraft:oak_planks"),
                new RemapMetaEntry(1, "minecraft:spruce_planks"),
                new RemapMetaEntry(2, "minecraft:birch_planks"),
                new RemapMetaEntry(3, "minecraft:jungle_planks"),
                new RemapMetaEntry(4, "minecraft:acacia_planks"),
                new RemapMetaEntry(5, "minecraft:dark_oak_planks")
        );
        context.remapMeta("minecraft:stone",
                new RemapMetaEntry(1, "minecraft:granite"),
                new RemapMetaEntry(2, "minecraft:polished_granite"),
                new RemapMetaEntry(3, "minecraft:diorite"),
                new RemapMetaEntry(4, "minecraft:polished_diorite"),
                new RemapMetaEntry(5, "minecraft:andesite"),
                new RemapMetaEntry(6, "minecraft:polished_andesite")
        );
    }
}
