package org.allaymc.updater.item;

import org.cloudburstmc.nbt.NbtMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

        assertEquals("minecraft:jungle_planks", result2.getString("Name"));
        assertEquals(0, result2.getInt("Damage"));

        assertEquals(result.getString("Name"), "minecraft:jungle_planks");
        assertEquals(0, result.getInt("Damage"));
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

        assertEquals("minecraft:charcoal", result.getString("Name"));
        assertEquals(0, result.getInt("Damage"));
    }

    @Test
    void unknown_remap_meta_for_coal() {
        var oldCoal = NbtMap.builder()
                .putString("Name", "minecraft:coal")
                .putInt("Damage", 2)
                .build();
        var newCoal = ItemStateUpdaters.updateItemState(oldCoal, ItemStateUpdaters.LATEST_VERSION);
        assertEquals(oldCoal, newCoal);
    }

    @Test
    void rename_id_for_record_creator() {
        var result = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:record_creator_music_box")
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals("minecraft:music_disc_creator_music_box", result.getString("Name"));
    }

    @Test
    void rename_id_for_grass() {
        var result = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:grass")
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals("minecraft:grass_block", result.getString("Name"));
    }

    @Test
    void remap_meta_for_stone() {
        assertDoesNotThrow(() -> {
            ItemStateUpdaters.updateItemState(
                    NbtMap.builder()
                            .putString("Name", "minecraft:stone")
                            .putInt("Damage", 0)
                            .build(),
                    ItemStateUpdaters.LATEST_VERSION
            );
        });
    }

    @Test
    void int_and_short_meta() {
        var resultInt = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:coal")
                        .putInt("Damage", 1)
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals("minecraft:charcoal", resultInt.getString("Name"));
        assertEquals(0, resultInt.getInt("Damage"));

        var resultShort = ItemStateUpdaters.updateItemState(
                NbtMap.builder()
                        .putString("Name", "minecraft:coal")
                        .putShort("Damage", (short) 1)
                        .build(),
                ItemStateUpdaters.LATEST_VERSION
        );

        assertEquals("minecraft:charcoal", resultShort.getString("Name"));
        assertEquals(0, resultShort.getShort("Damage"));
    }
}