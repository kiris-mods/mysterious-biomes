package com.mcmoddev.spookybiomes.common.world.gen.features;

import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class WorldGenBloodTree extends WorldGenAbstractTree {

    private final boolean useExtraRandomHeight;

    public WorldGenBloodTree(boolean notify, boolean useExtraRandomHeight) {
        super(notify);
        this.useExtraRandomHeight = useExtraRandomHeight;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int i = rand.nextInt(3) + 5;

        if (useExtraRandomHeight) {
            i += rand.nextInt(7);
        }

        boolean flag = true;
        if (position.getY() >= 1 && position.getY() + i + 1 <= 256) {
            for (int j = position.getY(); j <= position.getY() + 1 + i; ++j) {
                int k = 1;
                if (j == position.getY()) {
                    k = 0;
                }

                if (j >= position.getY() + 1 + i - 2) {
                    k = 2;
                }

                BlockPos.MutableBlockPos mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l) {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1) {
                        if (j >= 0 && j < worldIn.getHeight()) {
                            if (!isReplaceable(worldIn, mutableblockpos.setPos(l, j, i1))) {
                                flag = false;
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
                boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, EnumFacing.UP, (BlockSapling) Blocks.SAPLING);
                if (isSoil && position.getY() < worldIn.getHeight() - i - 1) {
                    state.getBlock().onPlantGrow(state, worldIn, down, position);

                    for (int i2 = position.getY() - 3 + i; i2 <= position.getY() + i; ++i2) {
                        int k2 = i2 - (position.getY() + i);
                        int l2 = 1 - k2 / 2;
                        for (int i3 = position.getX() - l2; i3 <= position.getX() + l2; ++i3) {
                            int j1 = i3 - position.getX();
                            for (int k1 = position.getZ() - l2; k1 <= position.getZ() + l2; ++k1) {
                                int l1 = k1 - position.getZ();
                                if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0) {
                                    BlockPos blockpos = new BlockPos(i3, i2, k1);
                                    IBlockState state2 = worldIn.getBlockState(blockpos);
                                    if (state2.getBlock().isAir(state2, worldIn, blockpos) || state2.getBlock().isAir(state2, worldIn, blockpos)) {
                                        setBlockAndNotifyAdequately(worldIn, blockpos, SpookyBlockObjects.BLOODWOOD_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false));
                                    }
                                }
                            }
                        }
                    }

                    for (int j2 = 0; j2 < i; ++j2) {
                        BlockPos upN = position.up(j2);
                        IBlockState state2 = worldIn.getBlockState(upN);
                        if (state2.getBlock().isAir(state2, worldIn, upN) || state2.getBlock().isLeaves(state2, worldIn, upN)) {
                            setBlockAndNotifyAdequately(worldIn, position.up(j2), SpookyBlockObjects.BLOODWOOD_LOG.getDefaultState());
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

/*
//TODO This in future.. Crashes on startup with the leaves in the super.
private final boolean useBaseHeight;

    public WorldGenBloodTree(boolean notify, boolean p_i45457_2_) {
        super(notify, 13, 15, SpookyBlockObjects.BLOODWOOD_LOG.getDefaultState(),
                SpookyBlockObjects.BLOODWOOD_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false));
        this.useBaseHeight = p_i45457_2_;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        int i = this.getHeight(rand);

        if (!this.ensureGrowable(worldIn, rand, position, i)) {
            return false;
        } else {
            this.createCrown(worldIn, position.getX(), position.getZ(), position.getY() + i, 0, rand);

            for (int j = 0; j < i; ++j) {
                if (isAirLeaves(worldIn, position.up(j))) {
                    this.setBlockAndNotifyAdequately(worldIn, position.up(j), this.woodMetadata);
                }

                if (j < i - 1) {
                    if (isAirLeaves(worldIn, position.add(1, j, 0))) {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(1, j, 0), this.woodMetadata);
                    }

                    if (isAirLeaves(worldIn, position.add(1, j, 1))) {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(1, j, 1), this.woodMetadata);
                    }


                    if (isAirLeaves(worldIn, position.add(0, j, 1))) {
                        this.setBlockAndNotifyAdequately(worldIn, position.add(0, j, 1), this.woodMetadata);
                    }
                }
            }

            return true;
        }
    }

    private void createCrown(World worldIn, int x, int z, int y, int p_150541_5_, Random rand) {
        int i = rand.nextInt(5) + (this.useBaseHeight ? this.baseHeight : 3);
        int j = 0;

        for (int k = y - i; k <= y; ++k) {
            int l = y - k;
            int i1 = p_150541_5_ + MathHelper.floor((float) l / (float) i * 3.5F);
            this.growLeavesLayerStrict(worldIn, new BlockPos(x, k, z), i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0));
            j = i1;
        }
    }

    public void generateSaplings(World worldIn, Random random, BlockPos pos) {
        this.placeBloodiedGrassCircle(worldIn, pos.west().north());
        this.placeBloodiedGrassCircle(worldIn, pos.east(2).north());
        this.placeBloodiedGrassCircle(worldIn, pos.west().south(2));
        this.placeBloodiedGrassCircle(worldIn, pos.east(2).south(2));

        for (int i = 0; i < 5; ++i) {
            int j = random.nextInt(64);
            int k = j % 8;
            int l = j / 8;

            if (k == 0 || k == 7 || l == 0 || l == 7) {
                this.placeBloodiedGrassCircle(worldIn, pos.add(-3 + k, 0, -3 + l));
            }
        }
    }

    private void placeBloodiedGrassCircle(World worldIn, BlockPos center) {
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                if (Math.abs(i) != 2 || Math.abs(j) != 2) {
                    this.placeBloodiedGrassAt(worldIn, center.add(i, 0, j));
                }
            }
        }
    }

    private void placeBloodiedGrassAt(World worldIn, BlockPos pos) {
        for (int i = 2; i >= -3; --i) {
            BlockPos blockpos = pos.up(i);
            IBlockState iblockstate = worldIn.getBlockState(blockpos);
            Block block = iblockstate.getBlock();

            if (block.canSustainPlant(iblockstate, worldIn, blockpos, EnumFacing.UP, ((BlockSapling) Blocks.SAPLING))) {
                this.setBlockAndNotifyAdequately(worldIn, blockpos, SpookyBlockObjects.BLOODIED_GRASS.getDefaultState());
                break;
            }

            if (iblockstate.getMaterial() != Material.AIR && i < 0) {
                break;
            }
        }
    }

    //Helper macro
    private boolean isAirLeaves(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos);
    }
 */
