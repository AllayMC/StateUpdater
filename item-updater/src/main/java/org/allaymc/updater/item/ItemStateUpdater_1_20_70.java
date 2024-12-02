package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_20_70 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_20_70();

    private ItemStateUpdater_1_20_70() {
        super(1, 20, 70);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:grass", "minecraft:grass_block");

        context.remapMeta("minecraft:leaves",
                new RemapMetaEntry(0, "minecraft:oak_leaves"),
                new RemapMetaEntry(1, "minecraft:spruce_leaves"),
                new RemapMetaEntry(2, "minecraft:birch_leaves"),
                new RemapMetaEntry(3, "minecraft:jungle_leaves")
        );
        context.remapMeta("minecraft:leaves2",
                new RemapMetaEntry(0, "minecraft:acacia_leaves"),
                new RemapMetaEntry(1, "minecraft:dark_oak_leaves")
        );
        context.remapMeta("minecraft:spawn_egg",
                new RemapMetaEntry(144, "minecraft:bogged_spawn_egg")
        );
        context.remapMeta("minecraft:wood",
                new RemapMetaEntry(0, "minecraft:oak_wood"),
                new RemapMetaEntry(1, "minecraft:spruce_wood"),
                new RemapMetaEntry(2, "minecraft:birch_wood"),
                new RemapMetaEntry(3, "minecraft:jungle_wood"),
                new RemapMetaEntry(4, "minecraft:acacia_wood"),
                new RemapMetaEntry(5, "minecraft:dark_oak_wood"),
                new RemapMetaEntry(8, "minecraft:stripped_oak_wood"),
                new RemapMetaEntry(9, "minecraft:stripped_spruce_wood"),
                new RemapMetaEntry(10, "minecraft:stripped_birch_wood"),
                new RemapMetaEntry(11, "minecraft:stripped_jungle_wood"),
                new RemapMetaEntry(12, "minecraft:stripped_acacia_wood"),
                new RemapMetaEntry(13, "minecraft:stripped_dark_oak_wood")
        );
        context.remapMeta("minecraft:wooden_slab",
                new RemapMetaEntry(0, "minecraft:oak_slab"),
                new RemapMetaEntry(1, "minecraft:spruce_slab"),
                new RemapMetaEntry(2, "minecraft:birch_slab"),
                new RemapMetaEntry(3, "minecraft:jungle_slab"),
                new RemapMetaEntry(4, "minecraft:acacia_slab"),
                new RemapMetaEntry(5, "minecraft:dark_oak_slab")
        );
    }
}
