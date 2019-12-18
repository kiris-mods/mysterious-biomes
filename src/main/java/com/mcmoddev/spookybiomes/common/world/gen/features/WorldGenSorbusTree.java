package com.mcmoddev.spookybiomes.common.world.gen.features;

import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenSorbusTree extends WorldGenAbstractTree {

    public WorldGenSorbusTree(boolean notify) {
        super(notify);
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int i;

        for (i = rand.nextInt(4) + 5; worldIn.getBlockState(position.down()).getMaterial() == Material.WATER; position = position.down()) {
            ;
        }

        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + i + 1 <= 256) {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
                int k = 1;

                if (j == position.getY()) {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2) {
                    k = 3;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < 256) {
                            IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos.setPos(l, j, i1));
                            Block block = iblockstate.getBlock();

                            if (!iblockstate.getBlock().isAir(iblockstate, worldIn, blockpos$mutableblockpos.setPos(l, j, i1)) && !iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos$mutableblockpos.setPos(l, j, i1))) {
                                if (block != Blocks.WATER && block != Blocks.FLOWING_WATER) {
                                    flag = false;
                                } else if (j > position.getY()) {
                                    flag = false;
                                }
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                BlockPos down = position.down();
                IBlockState state = worldIn.getBlockState(down);
                boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, EnumFacing.UP, ((BlockSapling) Blocks.SAPLING));

                if (isSoil && position.getY() < worldIn.getHeight() - i - 1) {
                    state.getBlock().onPlantGrow(state, worldIn, position.down(), position);

                    for (int k1 = position.getY() - 3 + i; k1 <= position.getY() + i; ++k1) {
                        int j2 = k1 - (position.getY() + i);
                        int l2 = 2 - j2 / 2;

                        for (int j3 = position.getX() - l2; j3 <= position.getX() + l2; ++j3) {
                            int k3 = j3 - position.getX();

                            for (int i4 = position.getZ() - l2; i4 <= position.getZ() + l2; ++i4) {
                                int j1 = i4 - position.getZ();

                                if (Math.abs(k3) != l2 || Math.abs(j1) != l2 || rand.nextInt(2) != 0 && j2 != 0) {
                                    BlockPos blockpos = new BlockPos(j3, k1, i4);
                                    state = worldIn.getBlockState(blockpos);

                                    if (state.getBlock().canBeReplacedByLeaves(state, worldIn, blockpos)) {
                                        setBlockAndNotifyAdequately(worldIn, blockpos, SpookyBlockObjects.SORBUS_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false));
                                    }
                                }
                            }
                        }
                    }

                    for (int l1 = 0; l1 < i; ++l1) {
                        BlockPos upN = position.up(l1);
                        IBlockState iblockstate1 = worldIn.getBlockState(upN);
                        Block block2 = iblockstate1.getBlock();

                        if (block2.isAir(iblockstate1, worldIn, upN) || block2.isLeaves(iblockstate1, worldIn, upN) || block2 == Blocks.FLOWING_WATER || block2 == Blocks.WATER) {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(l1), SpookyBlockObjects.SORBUS_LOG.getDefaultState());
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
