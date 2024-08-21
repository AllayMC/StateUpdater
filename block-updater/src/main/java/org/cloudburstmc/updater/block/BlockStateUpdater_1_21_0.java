package org.cloudburstmc.updater.block;

import org.cloudburstmc.updater.block.context.BlockUpdaterContext;
import org.cloudburstmc.updater.block.context.RemapValue;

public class BlockStateUpdater_1_21_0 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_21_0();

    private BlockStateUpdater_1_21_0() {
        super(1, 21, 0);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        context.addUpdater()
                .match("name", "minecraft:tallgrass")
                .match("tall_grass_type", "default")
                .replaceValue("name", "minecraft:short_grass")
                .removeProperty("tall_grass_type");
        context.addUpdater()
                .match("name", "minecraft:tallgrass")
                .match("tall_grass_type", "fern")
                .replaceValue("name", "minecraft:fern")
                .removeProperty("tall_grass_type");
        context.addUpdater()
                .match("name", "minecraft:tallgrass")
                .match("tall_grass_type", "snow")
                .replaceValue("name", "minecraft:fern")
                .removeProperty("tall_grass_type");
        context.addUpdater()
                .match("name", "minecraft:tallgrass")
                .match("tall_grass_type", "tall")
                .replaceValue("name", "minecraft:short_grass")
                .removeProperty("tall_grass_type");

        context.remapState("minecraft:coral_block", oldState -> oldState.match("dead_bit", "0"), "minecraft:", "coral_color", "_coral_block",
                new RemapValue("blue", "tube"),
                new RemapValue("pink", "brain"),
                new RemapValue("purple", "bubble"),
                new RemapValue("red", "fire"),
                new RemapValue("yellow", "horn")
        );
        context.remapState("minecraft:coral_block", oldState -> oldState.match("dead_bit", "1"), "minecraft:dead_", "coral_color", "_coral_block",
                new RemapValue("blue", "tube"),
                new RemapValue("pink", "brain"),
                new RemapValue("purple", "bubble"),
                new RemapValue("red", "fire"),
                new RemapValue("yellow", "horn")
        );
        context.remapState("minecraft:double_plant", "minecraft:", "double_plant_type", "",
                new RemapValue("fern", "large_fern"),
                new RemapValue("grass", "tall_grass"),
                new RemapValue("paeonia", "peony"),
                new RemapValue("rose", "rose_bush"),
                new RemapValue("syringa", "lilac")
        );
        context.remapState("minecraft:stone_block_slab", "minecraft:", "stone_slab_type", "_slab",
                new RemapValue("wood", "petrified_oak")
        );

        context.addProperty("minecraft:trial_spawner", "ominous", (byte) 0);
        context.addProperty("minecraft:vault", "ominous", (byte) 0);
    }
}
