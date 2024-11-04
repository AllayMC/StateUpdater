package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 2024/11/04
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_21_40 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_40();

    private ItemStateUpdater_1_21_40() {
        super(1, 21, 40);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:skull",
                new RemapMetaEntry(0, "minecraft:skeleton_skull"),
                new RemapMetaEntry(1, "minecraft:wither_skeleton_skull"),
                new RemapMetaEntry(2, "minecraft:zombie_head"),
                new RemapMetaEntry(3, "minecraft:player_head"),
                new RemapMetaEntry(4, "minecraft:creeper_head"),
                new RemapMetaEntry(5, "minecraft:dragon_head"),
                new RemapMetaEntry(6, "minecraft:piglin_head")
        );
    }
}
