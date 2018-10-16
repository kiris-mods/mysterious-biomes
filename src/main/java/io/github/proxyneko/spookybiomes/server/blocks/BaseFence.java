package io.github.proxyneko.spookybiomes.server.blocks;

import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BaseFence extends BlockFence {

    public BaseFence(Material material) {
        super(material, BlockPlanks.EnumType.OAK.getMapColor());
        Blocks.FIRE.setFireInfo(this, 5, 20);
    }
}
