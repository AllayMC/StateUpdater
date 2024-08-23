package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;

/**
 * StateUpdater Project 19/08/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_6_0 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_6_0();

    private ItemStateUpdater_1_6_0() {
        super(1, 6, 0);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.renameId("minecraft:nametag", "minecraft:name_tag");
        context.renameId("minecraft:prismarineshard", "minecraft:prismarine_shard");
        context.renameId("minecraft:stone_slab", "minecraft:double_stone_slab");
        context.renameId("minecraft:stone_slab2", "minecraft:double_stone_slab2");
        context.renameId("minecraft:stone_slab3", "minecraft:double_stone_slab3");
        context.renameId("minecraft:stone_slab4", "minecraft:double_stone_slab4");
    }
}
