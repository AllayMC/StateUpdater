package org.allaymc.updater.common.util;

import org.cloudburstmc.nbt.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class TagUtils {
    //https://gist.github.com/Alemiz112/504d0f79feac7ef57eda174b668dd345
    private static final int FNV1_32_INIT = 0x811c9dc5;
    private static final int FNV1_PRIME_32 = 0x01000193;

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

    public static NbtMap generateVersionFor(NbtMap tag) {
        // From Allay
        // Make sure that tree map is used
        // If the map inside states nbt is not tree map
        // the block state hash will be wrong!
        // To calculate the hash of the block state
        // "name" field must be in the first place
        var newTag = NbtMap.builder()
                .putString("name", tag.getString("name"))
                .putCompound("states", NbtMap.fromMap(new TreeMap<>(tag.getCompound("states"))))
                .build();
        return newTag.toBuilder().putInt("version", fnv1a_32_nbt(newTag)).build();
    }

    /**
     * FNV-1a 32-bit hash algorithm.
     *
     * @param tag the tag to hash.
     *
     * @return the hash.
     */
    public static int fnv1a_32_nbt(NbtMap tag) {
        byte[] bytes;
        try (var stream = new ByteArrayOutputStream();
             var outputStream = NbtUtils.createWriterLE(stream)) {
            outputStream.writeTag(tag);
            bytes = stream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to covert NBT into bytes", e);
        }

        return fnv1a_32(bytes);
    }

    /**
     * FNV-1a 32-bit hash algorithm.
     *
     * @param data the data to hash.
     *
     * @return the hash.
     */
    public static int fnv1a_32(byte[] data) {
        int hash = FNV1_32_INIT;
        for (byte datum : data) {
            hash ^= (datum & 0xff);
            hash *= FNV1_PRIME_32;
        }
        return hash;
    }
}
