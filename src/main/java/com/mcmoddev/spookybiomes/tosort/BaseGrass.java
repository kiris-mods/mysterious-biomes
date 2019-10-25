package com.mcmoddev.spookybiomes.tosort;

import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import com.mcmoddev.spookybiomes.init.ConfigHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BaseGrass extends BlockGrass {

    public BaseGrass() {
        setSoundType(SoundType.PLANT);
        setHarvestLevel("shovel", 0);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.RED;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (!worldIn.isAreaLoaded(pos, 3)) {
                return;
            }

            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getBlock().getLightOpacity(worldIn.getBlockState(pos.up()), worldIn, pos.up()) > 2) {
                worldIn.setBlockState(pos, BlocksSB.BLOODIED_DIRT.getDefaultState());
            } else {
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    Block block = worldIn.getBlockState(blockpos.up()).getBlock();
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);

                    if ((iblockstate.getBlock() == Blocks.GRASS && ConfigHandler.biomeGeneration.bloodiedGrassSpreadToGrass ||
                            iblockstate.getBlock() == BlocksSB.BLOODIED_DIRT ||
                            iblockstate.getBlock() == Blocks.DIRT && iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT &&
                                    ConfigHandler.biomeGeneration.bloodiedGrassSpreadToGrass) && block.getLightOpacity(worldIn.getBlockState(blockpos.up()),
                            worldIn, blockpos.up()) <= 2) {
                        worldIn.setBlockState(blockpos, BlocksSB.BLOODIED_GRASS.getDefaultState());
                    } else {
                        if (ConfigHandler.biomeGeneration.bloodiedGrassSpreadToDirt && iblockstate.getBlock() == Blocks.DIRT &&
                                iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT &&
                                worldIn.isSideSolid(blockpos, EnumFacing.UP) &&
                                !worldIn.getBlockState(blockpos.up()).getMaterial().isLiquid()) {
                            worldIn.setBlockState(blockpos, BlocksSB.BLOODIED_DIRT.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        boolean hasWater = world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.south()).getMaterial() == Material.WATER;
        return plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Plains ||
                plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Beach && hasWater;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int meta) {
        return BlocksSB.BLOODIED_DIRT.getItemDropped(state, random, meta);
    }

    @Override
    public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
        BlockPos blockpos = pos.up();
        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;
            while (true) {
                if (j >= i / 16) {
                    if (world.isAirBlock(blockpos1)) {
                        if (rand.nextInt(8) == 0) {
                            world.getBiome(blockpos1).plantFlower(world, rand, blockpos1);
                        } else {
                            IBlockState iblockstate1 = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
                            if (Blocks.TALLGRASS.canBlockStay(world, blockpos1, iblockstate1)) {
                                world.setBlockState(blockpos1, iblockstate1, 3);
                            }
                        }
                        break;
                    }
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                {
                    if (world.getBlockState(blockpos1.down()).getBlock() != BlocksSB.BLOODIED_DIRT || world.getBlockState(blockpos1).isNormalCube()) {
                        break;
                    }
                    ++j;
                }
            }
        }
    }
}
