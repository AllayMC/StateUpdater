package org.allaymc.updater.common.util;

import org.cloudburstmc.nbt.NbtList;
import org.cloudburstmc.nbt.NbtMap;
import org.cloudburstmc.nbt.NbtMapBuilder;
import org.cloudburstmc.nbt.NbtType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TagUtils {
    public static Object toMutable(Object immutable) {
        if (immutable instanceof NbtMap map) {
            Map<String, Object> mutable = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                mutable.put(entry.getKey(), toMutable(entry.getValue()));
            }
            return mutable;
        } else if (immutable instanceof NbtList) {
            List<Object> list = new ArrayList<>();
            for (Object value : (List<?>) immutable) {
                list.add(toMutable(value));
            }
            return list;
        }
        return immutable;
    }

    public static Object toImmutable(Object mutable) {
        if (mutable instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) mutable;
            NbtMapBuilder immutable = NbtMap.builder();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                immutable.put(entry.getKey(), toImmutable(entry.getValue()));
            }
            return immutable.build();
        } else if (mutable instanceof List) {
            List<Object> list = new ArrayList<>();
            NbtType<?> type = NbtType.END;
            for (Object value : (List<?>) mutable) {
                if (type == NbtType.END) {
                    type = NbtType.byClass(value.getClass());
                }
                list.add(toImmutable(value));
            }
            return new NbtList(type, list);
        }
        return mutable;
    }

    public static String getTagValue(Object tag) {
        return switch (tag) {
            case null -> "END";
            case Number number -> String.valueOf(number);
            case String str -> str;
            case Boolean bool -> bool ? "1" : "0";
            default -> throw new IllegalArgumentException("Invalid tag: " + tag.getClass().getSimpleName());
        };
    }
}
