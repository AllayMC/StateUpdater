package org.allaymc.updater.block;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.allaymc.updater.block.context.BlockUpdaterContext;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class BlockStateUpdaterBase extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdaterBase();

    private static final Map<String, Map<String, Object>[]> LEGACY_BLOCK_DATA_MAP = new HashMap<>();
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    static {
        try (var stream = Objects.requireNonNull(
                BlockStateUpdaterBase.class.getClassLoader().getResourceAsStream("legacy_block_data_map.json"),
                "Resource 'legacy_block_data_map.json' not found")) {
            var node = JSON_MAPPER.readTree(stream);

            node.fields().forEachRemaining(entry -> {
                var name = entry.getKey();
                var stateNodes = entry.getValue();

                @SuppressWarnings("unchecked")
                Map<String, Object>[] states = IntStream.range(0, stateNodes.size())
                        .mapToObj(i -> convertStateToCompound(stateNodes.get(i)))
                        .toArray(Map[]::new);
                LEGACY_BLOCK_DATA_MAP.put(name, states);
            });
        } catch (IOException e) {
            throw new AssertionError("Error loading legacy block data map", e);
        }
    }

    private BlockStateUpdaterBase() {
        super(0, 0, 0);
    }

    private static Map<String, Object> convertStateToCompound(JsonNode node) {
        Map<String, Object> tag = new HashMap<>();
        node.fields().forEachRemaining(entry -> {
            var name = entry.getKey();
            var value = entry.getValue();
            tag.put(name, switch (value.getNodeType()) {
                case BOOLEAN -> value.booleanValue();
                case NUMBER -> value.numberValue();
                case STRING -> value.textValue();
                default -> throw new UnsupportedOperationException(
                        "Unsupported node type: " + value.getNodeType() + " for key: " + name
                );
            });
        });
        return tag.isEmpty() ? Collections.emptyMap() : tag;
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addUpdater()
                .match("name", "minecraft:.+", true)
                .match("val", "\\d+", true)
                .addCompound("states")
                .tryEdit("states", helper -> {
                    var tag = helper.getCompoundTag();
                    var parent = helper.getParent();

                    var id = String.valueOf(parent.get("name"));
                    var val = Integer.parseInt(String.valueOf(parent.get("val")));
                    var statesArray = LEGACY_BLOCK_DATA_MAP.get(id);
                    if (statesArray != null) {
                        if (val >= statesArray.length) val = 0;
                        tag.putAll(statesArray[val]);
                    }
                }).removeProperty("val");
    }
}
