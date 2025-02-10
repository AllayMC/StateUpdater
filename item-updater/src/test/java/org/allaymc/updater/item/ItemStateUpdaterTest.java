package org.allaymc.updater.item;

import org.cloudburstmc.nbt.NbtMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author IWareQ
 */
class ItemStateUpdaterTest {
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