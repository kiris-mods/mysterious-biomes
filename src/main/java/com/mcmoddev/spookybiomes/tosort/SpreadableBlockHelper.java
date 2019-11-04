package com.mcmoddev.spookybiomes.tosort;

import com.mcmoddev.spookybiomes.SpookyBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Map;
import java.util.Random;

public class SpreadableBlockHelper {
    private final int MIN_LIGHT_LVL;
    private final int MAX_LIGHT_OPACITY;
    private final int SPREAD_SPEED;

    private final Block SPREADS_FROM;
    private final Map<Block, Integer> SPREADS_INTO;
    private final Block DECAYS_INTO;

    public SpreadableBlockHelper(int defMinLightLvl, int defMaxLightOpac, int defSpreadSpeed, Block spreadsFrom, Map<Block, Integer> spreadsInto, Block decaysInto) {
        this.MIN_LIGHT_LVL = SpookyBiomes.getConfig().getInt("minLightLevel", "spreading" + getTitleCasedBlockName(spreadsFrom), defMinLightLvl, 0, 16, "Light level must be lower than this for the block to spread.");
        this.MAX_LIGHT_OPACITY = SpookyBiomes.getConfig().getInt("maxLightOpacity", "spreading" + getTitleCasedBlockName(spreadsFrom), defMaxLightOpac, 0, 16, "Light opacity must be higher than this for the block to spread.");
        this.SPREAD_SPEED = SpookyBiomes.getConfig().getInt("spreadSpeed", "spreading" + getTitleCasedBlockName(spreadsFrom), 1, defSpreadSpeed, 100, "How fast the block spreads. At 100, it will spread to one other block every tick.");
        this.SPREADS_FROM = spreadsFrom;
        this.SPREADS_INTO = spreadsInto;
        this.DECAYS_INTO = decaysInto;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (worldIn.isAreaLoaded(pos, 3)) {
                if (worldIn.getLightFromNeighbors(pos.up()) < this.MIN_LIGHT_LVL && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > this.MAX_LIGHT_OPACITY) {
                    worldIn.setBlockState(pos, this.DECAYS_INTO.getDefaultState());
                }
                Random r = new Random(worldIn.getSeed());
                if (r.nextInt(100) < (100 / this.SPREAD_SPEED)) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);

                    if (this.SPREADS_INTO.containsKey(iblockstate.getBlock())
                            && SpookyBiomes.getConfig().getBoolean("spreadTo" + getTitleCasedBlockName(iblockstate.getBlock()), "spreading" + getTitleCasedBlockName(this.SPREADS_FROM), true, "Should contamination spread to this block")
                            && SpookyBiomes.getConfig().getBoolean("spreadFrom" + getTitleCasedBlockName(this.SPREADS_FROM), "spreading" + getTitleCasedBlockName(this.SPREADS_FROM), true, "Should contamination spread from this block")
//                            && !worldIn.getBlockState(blockpos.up()).getMaterial().isLiquid()
                    ) {
                        if (rand.nextInt(100) > this.SPREADS_INTO.get(iblockstate.getBlock())) {
                            worldIn.setBlockState(blockpos, this.SPREADS_FROM.getDefaultState());
                        }
                    }
                }
            }
            SpookyBiomes.getConfig().save();
        }
    }

    private static String getTitleCasedBlockName(Block block) {
        return WordUtils.capitalizeFully(block.getRegistryName().getPath().replace("_", " ")).replace(" ", "");
    }
}
