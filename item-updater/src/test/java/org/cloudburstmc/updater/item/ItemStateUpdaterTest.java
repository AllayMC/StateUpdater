package org.cloudburstmc.updater.item;

import org.cloudburstmc.nbt.NbtMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
class ItemStateUpdaterTest {
    @Test
    void update_planks_from_legacy() {
        var result = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Id", "5")
                        .putInt("Damage", 3)
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        var result2 = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putInt("Id", 5)
                        .putInt("Damage", 3)
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals(result2.getString("Name"), "minecraft:jungle_planks");
        assertEquals(result2.getInt("Damage"), 0);

        assertEquals(result.getString("Name"), "minecraft:jungle_planks");
        assertEquals(result.getInt("Damage"), 0);
    }

    @Test
    void remap_meta_for_coal() {
        var result = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:coal")
                        .putInt("Damage", 1)
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals(result.getString("Name"), "minecraft:charcoal");
        assertEquals(result.getInt("Damage"), 0);
    }

    @Test
    void unknown_remap_meta_for_coal() {
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> {
            ItemStateUpdaters.updateItemState(
                    NbtMap.builder()
                            .putString("Name", "minecraft:coal")
                            .putInt("Damage", 2)
                            .build(),
                    ItemStateUpdaters.LATEST_VERSION
            );
        });
    }

    @Test
    void rename_id_for_record_creator() {
        var result = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:record_creator")
                        // Meta ignored because record_creator only renamed
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals(result.getString("Name"), "minecraft:music_disc_creator");
    }

    @Test
    void rename_id_for_grass() {
        var result = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:grass")
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals(result.getString("Name"), "minecraft:grass_block");
    }
}