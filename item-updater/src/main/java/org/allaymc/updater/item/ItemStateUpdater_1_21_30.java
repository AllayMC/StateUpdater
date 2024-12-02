package org.allaymc.updater.item;

import org.allaymc.updater.item.context.ItemUpdaterContext;
import org.allaymc.updater.item.context.RemapMetaEntry;

/**
 * StateUpdater Project 2024/09/12
 *
 * @author IWareQ
 */
public class ItemStateUpdater_1_21_30 extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdater_1_21_30();

    private ItemStateUpdater_1_21_30() {
        super(1, 21, 30);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.remapMeta("minecraft:chemistry_table",
                new RemapMetaEntry(0, "minecraft:compound_creator"),
                new RemapMetaEntry(4, "minecraft:material_reducer"),
                new RemapMetaEntry(5, "minecraft:material_reducer"),
                new RemapMetaEntry(6, "minecraft:material_reducer"),
                new RemapMetaEntry(7, "minecraft:material_reducer"),
                new RemapMetaEntry(8, "minecraft:element_constructor"),
                new RemapMetaEntry(9, "minecraft:element_constructor"),
                new RemapMetaEntry(10, "minecraft:element_constructor"),
                new RemapMetaEntry(11, "minecraft:element_constructor"),
                new RemapMetaEntry(12, "minecraft:lab_table"),
                new RemapMetaEntry(13, "minecraft:lab_table"),
                new RemapMetaEntry(14, "minecraft:lab_table"),
                new RemapMetaEntry(15, "minecraft:lab_table")
        );
        context.remapMeta("minecraft:cobblestone_wall",
                new RemapMetaEntry(1, "minecraft:mossy_cobblestone_wall"),
                new RemapMetaEntry(2, "minecraft:granite_wall"),
                new RemapMetaEntry(3, "minecraft:diorite_wall"),
                new RemapMetaEntry(4, "minecraft:andesite_wall"),
                new RemapMetaEntry(5, "minecraft:sandstone_wall"),
                new RemapMetaEntry(6, "minecraft:brick_wall"),
                new RemapMetaEntry(7, "minecraft:stone_brick_wall"),
                new RemapMetaEntry(8, "minecraft:mossy_stone_brick_wall"),
                new RemapMetaEntry(9, "minecraft:nether_brick_wall"),
                new RemapMetaEntry(10, "minecraft:end_stone_brick_wall"),
                new RemapMetaEntry(11, "minecraft:prismarine_wall"),
                new RemapMetaEntry(12, "minecraft:red_sandstone_wall"),
                new RemapMetaEntry(13, "minecraft:red_nether_brick_wall")
        );
        context.remapMeta("minecraft:colored_torch_bp",
                new RemapMetaEntry(0, "minecraft:colored_torch_blue"),
                new RemapMetaEntry(8, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(9, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(10, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(11, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(12, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(13, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(14, "minecraft:colored_torch_purple"),
                new RemapMetaEntry(15, "minecraft:colored_torch_purple")
        );
        context.remapMeta("minecraft:colored_torch_rg",
                new RemapMetaEntry(0, "minecraft:colored_torch_red"),
                new RemapMetaEntry(8, "minecraft:colored_torch_green"),
                new RemapMetaEntry(9, "minecraft:colored_torch_green"),
                new RemapMetaEntry(10, "minecraft:colored_torch_green"),
                new RemapMetaEntry(11, "minecraft:colored_torch_green"),
                new RemapMetaEntry(12, "minecraft:colored_torch_green"),
                new RemapMetaEntry(13, "minecraft:colored_torch_green"),
                new RemapMetaEntry(14, "minecraft:colored_torch_green"),
                new RemapMetaEntry(15, "minecraft:colored_torch_green")
        );
        context.remapMeta("minecraft:purpur_block",
                new RemapMetaEntry(1, "minecraft:deprecated_purpur_block_1"),
                new RemapMetaEntry(2, "minecraft:purpur_pillar"),
                new RemapMetaEntry(3, "minecraft:deprecated_purpur_block_2")
        );
        context.remapMeta("minecraft:sponge",
                new RemapMetaEntry(1, "minecraft:wet_sponge")
        );
        context.remapMeta("minecraft:tnt",
                new RemapMetaEntry(2, "minecraft:underwater_tnt"),
                new RemapMetaEntry(3, "minecraft:underwater_tnt")
        );
    }
}
