package com.mcmoddev.spookybiomes.tosort;

import com.mcmoddev.spookybiomes.api.blocks.BlocksSB;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BaseDirt extends Block {

    public BaseDirt(Material material) {
        super(material, MapColor.RED);
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing facing, IPlantable plantable) {
        return BlocksSB.BLOODIED_GRASS.canSustainPlant(state, access, pos, facing, plantable);
    }
}
