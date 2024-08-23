package org.allaymc.updater.item;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.allaymc.updater.item.context.ItemUpdaterContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * StateUpdater Project 27/07/2024
 *
 * @author IWareQ
 */
public class ItemStateUpdaterBase extends ItemStateUpdater {
    public static final ItemStateUpdater INSTANCE = new ItemStateUpdaterBase();

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private static final Map<Integer, String> LEGACY_ITEM_IDS = new HashMap<>();

    static {
        try (var stream = ItemStateUpdaterBase.class.getClassLoader().getResourceAsStream("legacy_item_ids_map.json")) {
            Map<String, Integer> map = JSON_MAPPER.readValue(stream, new TypeReference<>() {});
            map.forEach((key, value) -> LEGACY_ITEM_IDS.put(value, key));
        } catch (IOException e) {
            throw new AssertionError("Error loading legacy item ids map", e);
        }
    }

    private ItemStateUpdaterBase() {
        super(0, 0, 0);
    }

    @Override
    public void registerUpdaters(ItemUpdaterContext context) {
        context.addUpdater()
                .match("Id", "\\d+", true)
                .edit("Id", helper -> {
                    var id = Integer.parseInt(helper.getTag().toString());
                    helper.replaceWith("Name", LEGACY_ITEM_IDS.get(id));
                });
    }
}
