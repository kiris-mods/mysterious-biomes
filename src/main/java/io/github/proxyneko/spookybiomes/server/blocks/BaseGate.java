package io.github.proxyneko.spookybiomes.server.blocks;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;

public class BaseGate extends BlockFenceGate {

    public BaseGate() {
        super(BlockPlanks.EnumType.OAK);
        Blocks.FIRE.setFireInfo(this, 5, 20);
    }
}
