package io.github.proxyneko.spookybiomes.common.blocks;

import io.github.proxyneko.spookybiomes.common.world.gen.features.WorldGenGhostlyTree;
import io.github.proxyneko.spookybiomes.common.world.gen.features.WorldGenWitchwoodTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BaseSapling extends BlockBush implements IGrowable {

    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    private static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    private WorldGenerator tree;
    private String saplingName;

    public BaseSapling(WorldGenerator tree, String saplingName) {
        setDefaultState(blockState.getBaseState().withProperty(STAGE, 0));
        setSoundType(SoundType.PLANT);
        setTickRandomly(true);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

    public void generateTree(World world, BlockPos pos, IBlockState state, Random random) {
        if (!TerrainGen.saplingGrowTree(world, random, pos)) {
            return;
        }

        WorldGenerator worldgenerator;
        int i = 0;
        int j = 0;
        boolean flag = false;

        switch (saplingName) {
            case "witchwood_sapling":
                worldgenerator = new WorldGenWitchwoodTree(true, true);
                break;
            case "ghostly_sapling":
                worldgenerator = new WorldGenGhostlyTree(true);
                break;
            default:
                worldgenerator = new WorldGenGhostlyTree(true);
        }

        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();
        if (flag) {
            world.setBlockState(pos.add(i, 0, j), iblockstate2, 4);
            world.setBlockState(pos.add(i + 1, 0, j), iblockstate2, 4);
            world.setBlockState(pos.add(i, 0, j + 1), iblockstate2, 4);
            world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate2, 4);
        } else {
            world.setBlockToAir(pos);
        }

        if (!worldgenerator.generate(world, random, pos.add(i, 0, j))) {
            if (flag) {
                world.setBlockState(pos.add(i, 0, j), state, 4);
                world.setBlockState(pos.add(i + 1, 0, j), state, 4);
                world.setBlockState(pos.add(i, 0, j + 1), state, 4);
                world.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
            } else {
                world.setBlockState(pos, state, 4);
            }
        }
    }

    public void grow(World world, Random random, BlockPos pos, IBlockState state) {
        if (state.getValue(STAGE) == 0) {
            world.setBlockState(pos, getStateFromMeta(1), 4);
        } else {
            generateTree(world, pos, state, random);
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(this);
    }

    public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    public boolean canUseBonemeal(World world, Random random, BlockPos pos, IBlockState state) {
        return true;
    }

    public int getMetaFromState(IBlockState state) {
        return (state.getValue(STAGE));
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{STAGE});
    }

    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {
            super.updateTick(world, pos, state, random);
            if (world.getLightFromNeighbors(pos.up()) >= 9 && random.nextInt(7) == 0) {
                this.grow(world, random, pos, state);
            }
        }
    }
}