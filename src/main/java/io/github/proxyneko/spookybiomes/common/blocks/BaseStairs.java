package io.github.proxyneko.spookybiomes.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BaseStairs extends BlockStairs {

    public BaseStairs(Block state) {
        super(state.getDefaultState());
        setLightOpacity(0);
    }
}
