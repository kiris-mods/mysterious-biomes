package com.mcmoddev.spookybiomes.common.blocks;

import com.mcmoddev.spookybiomes.api.blocks.SpookyBlockObjects;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;

public class BaseDirt extends Block {

    public BaseDirt(Material material) {
        super(material, MapColor.RED);
        setSoundType(SoundType.GROUND);
        setHarvestLevel("shovel", 0);
        setResistance(3);
        setHardness(0.5F);
    }

    @Override
    public boolean canSustainPlant(@Nonnull IBlockState state, @Nonnull IBlockAccess access, BlockPos pos,
                                   @Nonnull EnumFacing facing, IPlantable plantable) {
        return SpookyBlockObjects.BLOODIED_GRASS.canSustainPlant(state, access, pos, facing, plantable);
    }
}
