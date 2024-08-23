package org.allaymc.updater.block;

import org.allaymc.updater.block.context.BlockUpdaterContext;
import org.allaymc.updater.block.context.RemapValue;

/**
 * StateUpdater Project 23/08/2024
 *
 * @author IWareQ
 */
public class BlockStateUpdater_1_18_10 extends BlockStateUpdater {
    public static final BlockStateUpdater INSTANCE = new BlockStateUpdater_1_18_10();

    private BlockStateUpdater_1_18_10() {
        super(1, 18, 10);
    }

    @Override
    public void registerUpdaters(BlockUpdaterContext context) {
        var multi_face_direction_bits_00 = new RemapValue[]{
                new RemapValue(4, 16),
                new RemapValue(5, 17),
                new RemapValue(6, 18),
                new RemapValue(7, 19),
                new RemapValue(8, 4),
                new RemapValue(9, 5),
                new RemapValue(10, 6),
                new RemapValue(11, 7),
                new RemapValue(12, 20),
                new RemapValue(13, 21),
                new RemapValue(14, 22),
                new RemapValue(15, 23),
                new RemapValue(16, 8),
                new RemapValue(17, 9),
                new RemapValue(18, 10),
                new RemapValue(19, 11),
                new RemapValue(20, 24),
                new RemapValue(21, 25),
                new RemapValue(22, 26),
                new RemapValue(23, 27),
                new RemapValue(24, 12),
                new RemapValue(25, 13),
                new RemapValue(26, 14),
                new RemapValue(27, 15),
                new RemapValue(36, 48),
                new RemapValue(37, 49),
                new RemapValue(38, 50),
                new RemapValue(39, 51),
                new RemapValue(40, 36),
                new RemapValue(41, 37),
                new RemapValue(42, 38),
                new RemapValue(43, 39),
                new RemapValue(44, 52),
                new RemapValue(45, 53),
                new RemapValue(46, 54),
                new RemapValue(47, 55),
                new RemapValue(48, 40),
                new RemapValue(49, 41),
                new RemapValue(50, 42),
                new RemapValue(51, 43),
                new RemapValue(52, 56),
                new RemapValue(53, 57),
                new RemapValue(54, 58),
                new RemapValue(55, 59),
                new RemapValue(56, 44),
                new RemapValue(57, 45),
                new RemapValue(58, 46),
                new RemapValue(59, 47)
        };
        context.remapValues("minecraft:glow_lichen", "multi_face_direction_bits", multi_face_direction_bits_00);
        context.remapValues("minecraft:sculk_vein", "multi_face_direction_bits", multi_face_direction_bits_00);

        context.removeProperty("minecraft:skull", "no_drop_bit");
    }
}
