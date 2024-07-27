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
public class ItemStateUpdater_1_19_30 implements ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_19_30();

    @Override
    public void registerUpdaters(UpdaterContext<ItemUpdater, ItemUpdater.Builder> context) {
        context.addUpdater(1, 19, 30).remapMeta(
                "minecraft:boat",
                new RemapMetaEntry(6, "minecraft:mangrove_boat")
        ).remapMeta(
                "minecraft:chest_boat",
                new RemapMetaEntry(6, "minecraft:mangrove_chest_boat")
        );

        context.addUpdater(1, 19, 30)
                .renameId("minecraft:double_stone_slab", "minecraft:stone_block_slab")
                .renameId("minecraft:double_stone_slab2", "minecraft:stone_block_slab2")
                .renameId("minecraft:double_stone_slab3", "minecraft:stone_block_slab3")
                .renameId("minecraft:double_stone_slab4", "minecraft:stone_block_slab4")
                .renameId("minecraft:real_double_stone_slab", "minecraft:double_stone_block_slab")
                .renameId("minecraft:real_double_stone_slab2", "minecraft:double_stone_block_slab2")
                .renameId("minecraft:real_double_stone_slab3", "minecraft:double_stone_block_slab3")
                .renameId("minecraft:real_double_stone_slab4", "minecraft:double_stone_block_slab4")
                .renameId("minecraft:record_5", "minecraft:music_disc_5")
                .renameId("minecraft:stone_slab", "minecraft:stone_block_slab")
                .renameId("minecraft:stone_slab2", "minecraft:stone_block_slab2")
                .renameId("minecraft:stone_slab3", "minecraft:stone_block_slab3")
                .renameId("minecraft:stone_slab4", "minecraft:stone_block_slab4");
    }
}
