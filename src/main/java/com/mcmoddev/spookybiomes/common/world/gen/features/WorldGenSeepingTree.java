package com.mcmoddev.spookybiomes.common.world.gen.features;

import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;

import java.util.Random;

public class WorldGenSeepingTree extends WorldGenHugeTrees {

    private final boolean useBaseHeight;

    public WorldGenSeepingTree(boolean notify, boolean extraHeight) {
        super(notify, 13, 15, BlocksSB.SEEPING_LOG.getDefaultState(), BlocksSB.SEEPING_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false));
        this.useBaseHeight = extraHeight;
    }

    public boolean generate(World world, Random rand, BlockPos pos) {
        int i = getHeight(rand);
        if (!ensureGrowable(world, rand, pos, i)) {
            return false;
        } else {
            createCrown(world, pos.getX(), pos.getZ(), pos.getY() + i, 0, rand);

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

    private void createCrown(World worldIn, int x, int z, int y, int p_150541_5_, Random rand) {
        int i = rand.nextInt(5) + (useBaseHeight ? baseHeight : 3);
        int j = 0;
        for (int k = y - i; k <= y; ++k) {
            int l = y - k;
            int i1 = p_150541_5_ + MathHelper.floor((float) l / (float) i * 3.5F);
            growLeavesLayerStrict(worldIn, new BlockPos(x, k, z), i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0));
            j = i1;
        }
    }

    public void generateSaplings(World world, Random random, BlockPos pos) {
        placeGrassCircle(world, pos.west().north());
        placeGrassCircle(world, pos.east(2).north());
        placeGrassCircle(world, pos.west().south(2));
        placeGrassCircle(world, pos.east(2).south(2));

        for (int i = 0; i < 5; ++i) {
            int j = random.nextInt(64);
            int k = j % 8;
            int l = j / 8;
            if (k == 0 || k == 7 || l == 0 || l == 7) {
                placeGrassCircle(world, pos.add(-3 + k, 0, -3 + l));
            }
        }
    }

    private void placeGrassCircle(World world, BlockPos center) {
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                if (Math.abs(i) != 2 || Math.abs(j) != 2) {
                    placeGrassAt(world, center.add(i, 0, j));
                }
            }
        }
    }

    private void placeGrassAt(World world, BlockPos pos) {
        for (int i = 2; i >= -3; --i) {
            BlockPos blockpos = pos.up(i);
            IBlockState iblockstate = world.getBlockState(blockpos);
            Block block = iblockstate.getBlock();

            if (block.canSustainPlant(iblockstate, world, blockpos, EnumFacing.UP, ((BlockSapling) Blocks.SAPLING))) {
                this.setBlockAndNotifyAdequately(world, blockpos, Blocks.GRASS.getDefaultState());
                break;
            }

            if (iblockstate.getMaterial() != Material.AIR && i < 0) {
                break;
            }
        }
    }

    private boolean isAirLeaves(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }
}
