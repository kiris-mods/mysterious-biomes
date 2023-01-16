package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.common.entity.TheForgottenWarlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class MysteriousEntitySetup {

    public static final EntityType<TheForgottenWarlock> THE_FORGOTTEN_WARLOCK = Registry.register(
        Registry.ENTITY_TYPE, new ResourceLocation(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"),
        QuiltEntityTypeBuilder.<TheForgottenWarlock>createMob()
            .spawnGroup(MobCategory.MONSTER)
            .entityFactory(TheForgottenWarlock::new)
            .defaultAttributes(TheForgottenWarlock.createMonsterAttributes())
            .setDimensions(EntityDimensions.fixed(0.65F, 1.45F))
            .maxChunkTrackingRange(1)
            .spawnRestriction(SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules)
            .build());

    public MysteriousEntitySetup() {

    }
}
