package io.github.proxyneko.spookybiomes.common.world.gen.features;

import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;

import javax.annotation.Nonnull;
import java.util.Random;

public class WorldGenWitchwoodTree extends WorldGenHugeTrees {

    @Nonnull
    private static final IBlockState LOG = BlocksSB.WITCHWOOD_LOG.getDefaultState();
    private static final IBlockState LEAVES = BlocksSB.WITCHWOOD_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false);
    private final boolean useBaseHeight;

    public WorldGenWitchwoodTree(boolean notify, boolean p_i45457_2_) {
        super(notify, 13, 15, LOG, LEAVES);
        useBaseHeight = p_i45457_2_;
    }

    public boolean generate(World world, Random random, BlockPos pos) {
        int i = getHeight(random);
        if (!ensureGrowable(world, random, pos, i)) {
            return false;
        } else {
            createCrown(world, pos.getX(), pos.getZ(), pos.getY() + i, 0, random);

            for (int j = 0; j < i; ++j) {
                if (isAirLeaves(world, pos.up(j))) {
                    setBlockAndNotifyAdequately(world, pos.up(j), woodMetadata);
                }

                if (j < i - 1) {
                    if (isAirLeaves(world, pos.add(1, j, 0))) {
                        setBlockAndNotifyAdequately(world, pos.add(1, j, 0), woodMetadata);
                    }

                    if (isAirLeaves(world, pos.add(1, j, 1))) {
                        setBlockAndNotifyAdequately(world, pos.add(1, j, 1), woodMetadata);
                    }

                    if (isAirLeaves(world, pos.add(0, j, 1))) {
                        setBlockAndNotifyAdequately(world, pos.add(0, j, 1), woodMetadata);
                    }
                }
            }

            return true;
        }
    }

    private void createCrown(World world, int x, int z, int y, int p_150541_5_, Random random) {
        int i = random.nextInt(5) + (useBaseHeight ? baseHeight : 3);
        int j = 0;
        for (int k = y - i; k <= y; ++k) {
            int l = y - k;
            int i1 = p_150541_5_ + MathHelper.floor((float) l / (float) i * 3.5F);
            growLeavesLayerStrict(world, new BlockPos(x, k, z), i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0));
            j = i1;
        }
    }

    public void generateSaplings(World world, Random random, BlockPos pos) {
        for (int i = 0; i < 5; ++i) {
            int j = random.nextInt(64);
            int k = j % 8;
            int l = j / 8;
        }
    }

    private boolean isAirLeaves(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }
}
