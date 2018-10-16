package io.github.proxyneko.spookybiomes.common.blocks;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BaseDoor extends BlockDoor {

    private Item doorItem;

    public BaseDoor(Material material) {
        super(material);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(getDoorItem());
    }

    private Item getDoorItem() {
        if (doorItem == null) {
            doorItem = Item.REGISTRY.getObject(new ResourceLocation(getRegistryName().getNamespace()));
        }

        return doorItem;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getItem(World world, BlockPos blockPos, IBlockState state) {
        return new ItemStack(getDoorItem());
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return (state.getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) ? null : getDoorItem();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
        IBlockState iblockstate = pos.equals(blockpos) ? state : world.getBlockState(blockpos);
        if (iblockstate.getBlock() != this) {
            return false;
        }

        IBlockState checkstate = iblockstate.cycleProperty(OPEN);
        world.setBlockState(blockpos, checkstate, 10);
        world.markBlockRangeForRenderUpdate(blockpos, pos);
        world.playEvent(playerIn, checkstate.getValue(OPEN) ? 1012 : 1006, pos, 0);
        return true;
    }
}