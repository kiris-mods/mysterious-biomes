package com.mcmoddev.spookybiomes.tosort;

import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseDirt extends Block {
    private SpreadableBlockHelper spreadableBlockHelper;

    public BaseDirt(Material material) {
        super(material, MapColor.RED);
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);
    }

    public SpreadableBlockHelper getSpreadableBlockHelper() {
        if (this.spreadableBlockHelper == null) {
            Map<Block, Integer> spreadInto = new HashMap<>();
            spreadInto.put(Blocks.DIRT, 100);

            spreadableBlockHelper = new SpreadableBlockHelper(4, 2, 1, BlocksSB.BLOODIED_DIRT, spreadInto, BlocksSB.BLOODIED_DIRT);
        }
        return spreadableBlockHelper;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.getSpreadableBlockHelper().updateTick(worldIn, pos, state, rand);
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing facing, IPlantable plantable) {
        return BlocksSB.BLOODIED_GRASS.canSustainPlant(state, access, pos, facing, plantable);
    }
}
