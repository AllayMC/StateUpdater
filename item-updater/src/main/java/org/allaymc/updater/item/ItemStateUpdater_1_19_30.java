package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * @author IWareQ
 */
public class ItemStateUpdater_1_19_30 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_19_30();

    private ItemStateUpdater_1_19_30() {
        super(1, 19, 30);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:double_stone_slab", "minecraft:stone_block_slab");
        context.renameId("minecraft:double_stone_slab2", "minecraft:stone_block_slab2");
        context.renameId("minecraft:double_stone_slab3", "minecraft:stone_block_slab3");
        context.renameId("minecraft:double_stone_slab4", "minecraft:stone_block_slab4");
        context.renameId("minecraft:real_double_stone_slab", "minecraft:double_stone_block_slab");
        context.renameId("minecraft:real_double_stone_slab2", "minecraft:double_stone_block_slab2");
        context.renameId("minecraft:real_double_stone_slab3", "minecraft:double_stone_block_slab3");
        context.renameId("minecraft:real_double_stone_slab4", "minecraft:double_stone_block_slab4");
        context.renameId("minecraft:record_5", "minecraft:music_disc_5");
        context.renameId("minecraft:stone_slab", "minecraft:stone_block_slab");
        context.renameId("minecraft:stone_slab2", "minecraft:stone_block_slab2");
        context.renameId("minecraft:stone_slab3", "minecraft:stone_block_slab3");
        context.renameId("minecraft:stone_slab4", "minecraft:stone_block_slab4");

        context.remapMeta("minecraft:boat",
                new RemapMetaEntry(6, "minecraft:mangrove_boat")
        );
        context.remapMeta("minecraft:chest_boat",
                new RemapMetaEntry(6, "minecraft:mangrove_chest_boat")
        );
    }
}
