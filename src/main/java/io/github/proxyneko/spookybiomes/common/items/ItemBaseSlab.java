package io.github.proxyneko.spookybiomes.common.items;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;

public class ItemBaseSlab extends ItemSlab {

    public ItemBaseSlab(Material material, BlockSlab slab, BlockSlab doubleSlab) {
        super(slab, slab, doubleSlab);
        setRegistryName(slab.getRegistryName());
    }
}
