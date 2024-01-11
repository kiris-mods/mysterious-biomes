package dev.tophatcat.mysteriousbiomes.common.world;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class MysteriousSurfaceRules {

    private static final SurfaceRules.RuleSource BLOODIED_GRASS
        = SurfaceRules.state(MysteriousRegistry.BLOODIED_GRASS.get().defaultBlockState());
    private static final SurfaceRules.RuleSource BLOODIED_DIRT
        = SurfaceRules.state(MysteriousRegistry.BLOODIED_DIRT.get().defaultBlockState());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel
            = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface
            = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel,
            BLOODIED_GRASS), BLOODIED_DIRT);
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(MysteriousCommon.BLOODIED_PLAINS),
            grassSurface);
    }
}
