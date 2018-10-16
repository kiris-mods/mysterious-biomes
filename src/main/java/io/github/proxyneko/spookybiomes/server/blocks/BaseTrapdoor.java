package io.github.proxyneko.spookybiomes.server.blocks;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BaseTrapdoor extends BlockTrapDoor {

    public BaseTrapdoor(Material material) {
        super(material);
        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);
        setResistance(60F);
    }
}