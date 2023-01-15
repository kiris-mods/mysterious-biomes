package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.common.entity.TheForgottenWarlock;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class MysteriousEntitySetup {

    public static EntityType<TheForgottenWarlock> THE_FORGOTTEN_WARLOCK = Registry.register(
        Registry.ENTITY_TYPE, new Identifier(MysteriousBiomes.MOD_ID, "the_forgotten_warlock"),
        QuiltEntityTypeBuilder.<TheForgottenWarlock>createMob()
            .spawnGroup(SpawnGroup.MONSTER)
            .entityFactory(TheForgottenWarlock::new)
            .defaultAttributes(TheForgottenWarlock.createHostileAttributes())
            .setDimensions(EntityDimensions.fixed(0.65F, 1.45F))
            .maxChunkTrackingRange(1)
            .spawnRestriction(SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn)
            .build());

    public MysteriousEntitySetup() {

    }
}
