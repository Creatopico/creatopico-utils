package ru.creatopico.contraption;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

public abstract class BreakableBlocks {

    public static Set<Identifier> dimensionsWorksIn = new HashSet<>();
    public static final Set<Block> blocks = new HashSet<>();

    static {
        blocks.add(Blocks.AIR);
        blocks.add(Blocks.GRASS);
        blocks.add(Blocks.FERN);
        blocks.add(Blocks.LARGE_FERN);

        blocks.add(Blocks.WATER);
        blocks.add(Blocks.LAVA);

        blocks.add(Blocks.OAK_LEAVES);
        blocks.add(Blocks.ACACIA_LEAVES);
        blocks.add(Blocks.BIRCH_LEAVES);
        blocks.add(Blocks.CHERRY_LEAVES);
        blocks.add(Blocks.AZALEA_LEAVES);
        blocks.add(Blocks.DARK_OAK_LEAVES);
        blocks.add(Blocks.FLOWERING_AZALEA_LEAVES);
        blocks.add(Blocks.MANGROVE_LEAVES);
        blocks.add(Blocks.SPRUCE_LEAVES);

        blocks.add(Blocks.VINE);
        blocks.add(Blocks.CAVE_VINES);
        blocks.add(Blocks.TWISTING_VINES);
        blocks.add(Blocks.WEEPING_VINES);
        blocks.add(Blocks.CAVE_VINES_PLANT);
        blocks.add(Blocks.TWISTING_VINES_PLANT);
        blocks.add(Blocks.WEEPING_VINES_PLANT);

        blocks.add(Blocks.CORNFLOWER);
        blocks.add(Blocks.SUNFLOWER);
        blocks.add(Blocks.TORCHFLOWER);
    }
}
