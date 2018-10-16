package io.github.proxyneko.spookybiomes.server.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BasePlanks extends Block {

    public BasePlanks(Material material) {
        super(material);
        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);
        setResistance(3);
        Blocks.FIRE.setFireInfo(this, 5, 20);
    }
}