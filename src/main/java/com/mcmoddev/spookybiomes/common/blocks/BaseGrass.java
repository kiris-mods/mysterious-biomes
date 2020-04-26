package com.mcmoddev.spookybiomes.common.blocks;

import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.SoundType;
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

import javax.annotation.Nonnull;
import java.util.Random;

public class BaseGrass extends BlockGrass {

    public BaseGrass() {
        setSoundType(SoundType.PLANT);
        setHarvestLevel("shovel", 0);
        setResistance(3);
        setHardness(0.6F);
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public MapColor getMapColor(IBlockState state) {
        return MapColor.RED;
    }

    /**
     * Change bloodied dirt to bloodied grass when the light level is above 4.
     * This is a temporary block until the feature in the commented out block below is finished.
     */
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
        if (!world.isRemote) {
            if (!world.isAreaLoaded(pos, 3))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (world.getLightFromNeighbors(pos.up()) < 4 &&
                    world.getBlockState(pos.up()).getLightOpacity(world, pos.up()) > 2) {
                world.setBlockState(pos, SpookyBlockObjects.BLOODIED_DIRT.getDefaultState());
            } else {
                if (world.getLightFromNeighbors(pos.up()) >= 9) {
                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3,
                                random.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isBlockLoaded(blockpos)) {
                            return;
                        }

                        IBlockState iblockstate = world.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = world.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == SpookyBlockObjects.BLOODIED_DIRT &&
                                world.getLightFromNeighbors(blockpos.up()) >= 4 &&
                                iblockstate.getLightOpacity(world, pos.up()) <= 2) {
                            world.setBlockState(blockpos, SpookyBlockObjects.BLOODIED_GRASS.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    /*
     * Disabled this for now until we get it working.
     * //TODO Get grass to spread properly.
    /*
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (!worldIn.isAreaLoaded(pos, 3)) {
                return;
            }

            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up())
                    .getBlock().getLightOpacity(worldIn.getBlockState(pos.up()), worldIn, pos.up()) > 2) {
                worldIn.setBlockState(pos, SpookyBlockObjects.BLOODIED_DIRT.getDefaultState());
            } else {
                for (int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1,
                            rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    Block block = worldIn.getBlockState(blockpos.up()).getBlock();
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);

                    if ((iblockstate.getBlock() ==
                            Blocks.GRASS && ConfigHandler.biomeGeneration.bloodiedGrassSpreadToGrass ||
                            iblockstate.getBlock() == SpookyBlockObjects.BLOODIED_DIRT ||
                            iblockstate.getBlock() == Blocks.DIRT && iblockstate.getValue(BlockDirt.VARIANT)
                                    == BlockDirt.DirtType.DIRT &&
                                    ConfigHandler.biomeGeneration.bloodiedGrassSpreadToGrass)
                            && block.getLightOpacity(worldIn.getBlockState(blockpos.up()),
                            worldIn, blockpos.up()) <= 2) {
                        worldIn.setBlockState(blockpos, SpookyBlockObjects.BLOODIED_GRASS.getDefaultState());
                    } else {
                        if (ConfigHandler.biomeGeneration.bloodiedGrassSpreadToDirt
                                && iblockstate.getBlock() == Blocks.DIRT &&
                                iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT &&
                                worldIn.isSideSolid(blockpos, EnumFacing.UP) &&
                                !worldIn.getBlockState(blockpos.up()).getMaterial().isLiquid()) {
                            worldIn.setBlockState(blockpos, SpookyBlockObjects.BLOODIED_DIRT.getDefaultState());
                        }
                    }
                }
            }
        }
    }
     */

    @Override
    public boolean canSustainPlant(@Nonnull IBlockState state, IBlockAccess world, BlockPos pos,
                                   @Nonnull EnumFacing direction, IPlantable plantable) {
        boolean hasWater = world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.south()).getMaterial() == Material.WATER;
        return plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Plains ||
                plantable.getPlantType(world, pos.offset(direction)) == EnumPlantType.Beach && hasWater;
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, @Nonnull Random random, int meta) {
        return SpookyBlockObjects.BLOODIED_DIRT.getItemDropped(state, random, meta);
    }

    @Override
    public void grow(@Nonnull World world, @Nonnull Random rand, BlockPos pos, IBlockState state) {
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
                            IBlockState iblockstate1 = Blocks.TALLGRASS.getDefaultState()
                                    .withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
                            if (Blocks.TALLGRASS.canBlockStay(world, blockpos1, iblockstate1)) {
                                world.setBlockState(blockpos1, iblockstate1, 3);
                            }
                        }
                        break;
                    }
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1)
                        * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                {
                    if (world.getBlockState(blockpos1.down()).getBlock() != SpookyBlockObjects.BLOODIED_DIRT
                            || world.getBlockState(blockpos1).isNormalCube()) {
                        break;
                    }
                    ++j;
                }
            }
        }
    }
}
