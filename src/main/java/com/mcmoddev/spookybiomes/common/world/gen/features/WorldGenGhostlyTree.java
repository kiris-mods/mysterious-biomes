package com.mcmoddev.spookybiomes.common.world.gen.features;

import com.google.common.collect.Lists;
import com.mcmoddev.proxyslib.blocks.BaseLog;
import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.List;
import java.util.Random;

public class WorldGenGhostlyTree extends WorldGenAbstractTree {

    private Random rand;
    private World world;
    private BlockPos basePos = BlockPos.ORIGIN;
    private int heightLimit;
    private int height;

    /**
     * Sets the distance limit for how far away the generator will populate leaves from the base leaf node.
     */
    private int leafDistanceLimit = 4;
    private List<FoliageCoordinates> foliageCoords;

    public WorldGenGhostlyTree(boolean notify) {
        super(notify);
    }

    /**
     * Generates a list of leaf nodes for the tree, to be populated by generateLeaves.
     */
    private void generateLeafNodeList() {
        double heightAttenuation = 0.618D;
        height = (int) ((double) heightLimit * heightAttenuation);

        if (height >= heightLimit) {
            height = heightLimit - 1;
        }

        double leafDensity = 1.0D;
        int i = (int) (1.382D + Math.pow(leafDensity * (double) heightLimit / 13.0D, 2.0D));

        if (i < 1) {
            i = 1;
        }

        int j = basePos.getY() + height;
        int k = heightLimit - leafDistanceLimit;
        foliageCoords = Lists.newArrayList();
        foliageCoords.add(new FoliageCoordinates(basePos.up(k), j));

        for (; k >= 0; --k) {
            float f = layerSize(k);

            if (f >= 0.0F) {
                for (int l = 0; l < i; ++l) {
                    double scaleWidth = 1.0D;
                    double d0 = scaleWidth * (double) f * ((double) rand.nextFloat() + 0.328D);
                    double d1 = (double) (rand.nextFloat() * 2.0F) * Math.PI;
                    double d2 = d0 * Math.sin(d1) + 0.5D;
                    double d3 = d0 * Math.cos(d1) + 0.5D;
                    BlockPos blockpos = basePos.add(d2, (k - 1), d3);
                    BlockPos blockpos1 = blockpos.up(leafDistanceLimit);

                    if (checkBlockLine(blockpos, blockpos1) == -1) {
                        int i1 = basePos.getX() - blockpos.getX();
                        int j1 = basePos.getZ() - blockpos.getZ();
                        double branchSlope = 0.381D;
                        double d4 = (double) blockpos.getY() - Math.sqrt((i1 * i1 + j1 * j1)) * branchSlope;
                        int k1 = d4 > (double) j ? j : (int) d4;
                        BlockPos blockpos2 = new BlockPos(basePos.getX(), k1, basePos.getZ());

                        if (checkBlockLine(blockpos2, blockpos) == -1) {
                            foliageCoords.add(new FoliageCoordinates(blockpos, blockpos2.getY()));
                        }
                    }
                }
            }
        }
    }

    private void crosSection(BlockPos pos, float p_181631_2_, IBlockState p_181631_3_) {
        int i = (int) ((double) p_181631_2_ + 0.618D);

        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                if (Math.pow((double) Math.abs(j) + 0.5D, 2.0D) + Math.pow((double) Math.abs(k) + 0.5D, 2.0D) <= (double) (p_181631_2_ * p_181631_2_)) {
                    BlockPos blockpos = pos.add(j, 0, k);
                    IBlockState state = world.getBlockState(blockpos);

                    if (state.getBlock().isAir(state, world, blockpos) || state.getBlock().isLeaves(state, world, blockpos)) {
                        setBlockAndNotifyAdequately(world, blockpos, p_181631_3_);
                    }
                }
            }
        }
    }

    /**
     * Gets the rough size of a layer of the tree.
     */
    private float layerSize(int y) {
        if ((float) y < (float) heightLimit * 0.3F) {
            return -1.0F;
        } else {
            float f = (float) heightLimit / 2.0F;
            float f1 = f - (float) y;
            float f2 = MathHelper.sqrt(f * f - f1 * f1);

            if (f1 == 0.0F) {
                f2 = f;
            } else if (Math.abs(f1) >= f) {
                return 0.0F;
            }

            return f2 * 0.5F;
        }
    }

    private float leafSize(int y) {
        if (y >= 0 && y < leafDistanceLimit) {
            return y != 0 && y != leafDistanceLimit - 1 ? 3.0F : 2.0F;
        } else {
            return -1.0F;
        }
    }

    /**
     * Generates the leaves surrounding an individual entry in the leafNodes list.
     */
    private void generateLeafNode(BlockPos pos) {
        for (int i = 0; i < leafDistanceLimit; ++i) {
            crosSection(pos.up(i), leafSize(i), BlocksSB.GHOSTLY_LEAVES.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false));
        }
    }

    private void limb(BlockPos pos1, BlockPos pos2, Block block) {
        BlockPos blockpos = pos2.add(-pos1.getX(), -pos1.getY(), -pos1.getZ());
        int i = getGreatestDistance(blockpos);
        float f = (float) blockpos.getX() / (float) i;
        float f1 = (float) blockpos.getY() / (float) i;
        float f2 = (float) blockpos.getZ() / (float) i;

        for (int j = 0; j <= i; ++j) {
            BlockPos blockpos1 = pos1.add((0.5F + (float) j * f), (0.5F + (float) j * f1), (0.5F + (float) j * f2));
            BlockLog.EnumAxis enumaxis = getLogAxis(pos1, blockpos1);
            setBlockAndNotifyAdequately(world, blockpos1, block.getDefaultState().withProperty(BaseLog.LOG_AXIS, enumaxis));
        }
    }

    /**
     * Returns the absolute greatest distance in the BlockPos object.
     */
    private int getGreatestDistance(BlockPos posIn) {
        int i = MathHelper.abs(posIn.getX());
        int j = MathHelper.abs(posIn.getY());
        int k = MathHelper.abs(posIn.getZ());

        if (k > i && k > j) {
            return k;
        } else {
            return j > i ? j : i;
        }
    }

    private BaseLog.EnumAxis getLogAxis(BlockPos p_175938_1_, BlockPos p_175938_2_) {
        BaseLog.EnumAxis enumaxis = BaseLog.EnumAxis.Y;
        int i = Math.abs(p_175938_2_.getX() - p_175938_1_.getX());
        int j = Math.abs(p_175938_2_.getZ() - p_175938_1_.getZ());
        int k = Math.max(i, j);

        if (k > 0) {
            if (i == k) {
                enumaxis = BlockLog.EnumAxis.X;
            } else if (j == k) {
                enumaxis = BlockLog.EnumAxis.Z;
            }
        }
        return enumaxis;
    }

    /**
     * Generates the leaf portion of the tree as specified by the leafNodes list.
     */
    private void generateLeaves() {
        for (FoliageCoordinates foliagecoordinates : foliageCoords) {
            generateLeafNode(foliagecoordinates);
        }
    }

    /**
     * Indicates whether or not a leaf node requires additional wood to be added to preserve integrity.
     */
    private boolean leafNodeNeedsBase(int p_76493_1_) {
        return (double) p_76493_1_ >= (double) heightLimit * 0.2D;
    }

    private void generateTrunk() {
        BlockPos blockpos = basePos;
        BlockPos blockpos1 = basePos.up(height);
        Block block = BlocksSB.GHOSTLY_LOG.getDefaultState().getBlock();
        limb(blockpos, blockpos1, block);
    }

    /**
     * Generates additional wood blocks to fill out the bases of different leaf nodes that would otherwise degrade.
     */
    private void generateLeafNodeBases() {
        for (FoliageCoordinates foliagecoordinates : foliageCoords) {
            int i = foliagecoordinates.getBranchBase();
            BlockPos blockpos = new BlockPos(basePos.getX(), i, basePos.getZ());

            if (!blockpos.equals(foliagecoordinates) && leafNodeNeedsBase(i - basePos.getY())) {
                limb(blockpos, foliagecoordinates, BlocksSB.GHOSTLY_LOG.getDefaultState().getBlock());
            }
        }
    }

    /**
     * Checks a line of blocks in the world from the first coordinate to triplet to the second, returning the distance
     * (in blocks) before a non-air, non-leaf block is encountered and/or the end is encountered.
     */
    private int checkBlockLine(BlockPos posOne, BlockPos posTwo) {
        BlockPos blockpos = posTwo.add(-posOne.getX(), -posOne.getY(), -posOne.getZ());
        int i = getGreatestDistance(blockpos);
        float f = (float) blockpos.getX() / (float) i;
        float f1 = (float) blockpos.getY() / (float) i;
        float f2 = (float) blockpos.getZ() / (float) i;

        if (i == 0) {
            return -1;
        } else {
            for (int j = 0; j <= i; ++j) {
                BlockPos blockpos1 = posOne.add((0.5F + (float) j * f), (0.5F + (float) j * f1), (0.5F + (float) j * f2));

                if (!isReplaceable(world, blockpos1)) {
                    return j;
                }
            }

            return -1;
        }
    }

    public void setDecorationDefaults() {
        leafDistanceLimit = 6;
    }

    public boolean generate(World world, Random rand, BlockPos pos) {
        this.world = world;
        basePos = pos;
        this.rand = new Random(rand.nextLong());

        if (heightLimit == 0) {
            int heightLimitLimit = 15;
            heightLimit = 5 + rand.nextInt(heightLimitLimit);
        }

        if (!validTreeLocation()) {
            this.world = null; //Fix vanilla Mem leak, holds latest world
            return false;
        } else {
            generateLeafNodeList();
            generateLeaves();
            generateTrunk();
            generateLeafNodeBases();
            this.world = null; //Fix vanilla Mem leak, holds latest world
            return true;
        }
    }

    /**
     * Returns a boolean indicating whether or not the current location for the tree, spanning basePos to to the height
     * limit, is valid.
     */
    private boolean validTreeLocation() {
        BlockPos down = basePos.down();
        IBlockState state = world.getBlockState(down);
        boolean isSoil = state.getBlock().canSustainPlant(state, world, down, EnumFacing.UP, ((BlockSapling) Blocks.SAPLING));

        if (!isSoil) {
            return false;
        } else {
            int i = checkBlockLine(basePos, basePos.up(heightLimit - 1));

            if (i == -1) {
                return true;
            } else if (i < 6) {
                return false;
            } else {
                heightLimit = i;
                return true;
            }
        }
    }

    private static class FoliageCoordinates extends BlockPos {
        private final int branchBase;

        private FoliageCoordinates(BlockPos pos, int p_i45635_2_) {
            super(pos.getX(), pos.getY(), pos.getZ());
            branchBase = p_i45635_2_;
        }

        private int getBranchBase() {
            return branchBase;
        }
    }
}
