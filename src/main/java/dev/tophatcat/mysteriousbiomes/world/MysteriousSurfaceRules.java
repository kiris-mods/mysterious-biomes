package dev.tophatcat.mysteriousbiomes.world;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.init.MysteriousRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class MysteriousSurfaceRules {

    private static final SurfaceRules.RuleSource BLOODIED_GRASS
        = makeStateRule(MysteriousRegistry.BLOODIED_GRASS.get());

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(MysteriousBiomes.BLOODIED_PLAINS),
            BLOODIED_GRASS));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
