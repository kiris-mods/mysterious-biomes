package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.entity.EntityTheForgottenWarlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

import java.util.LinkedHashMap;

public final class MysteriousEntities {

    public static final LinkedHashMap<EntityType<?>, ResourceLocation> ENTITIES = new LinkedHashMap<>();

    private MysteriousEntities() {
        throw new UnsupportedOperationException("MysteriousEntities only contains static definitions...");
    }

    public static final EntityType<EntityTheForgottenWarlock> THE_FORGOTTEN_WARLOCK = makeEntity(
        "the_forgotten_warlock",
        QuiltEntityTypeBuilder.<EntityTheForgottenWarlock>createMob()
            .entityFactory(EntityTheForgottenWarlock::new)
            .defaultAttributes(EntityTheForgottenWarlock.theForgottenWarlockAttributes())
            .setDimensions(EntityDimensions.fixed(0.75F, 2.30F))
            .spawnGroup(MobCategory.MONSTER)
            .maxChunkTrackingRange(1)
            .spawnRestriction(SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules)
            .build());

    public static void init() {
        ENTITIES.keySet().forEach(entityType
            -> Registry.register(BuiltInRegistries.ENTITY_TYPE, ENTITIES.get(entityType), entityType));
        addSpawns();
    }

    static void addSpawns() {
        //TODO Tweak the biome tags once our biomes are setup.
        BiomeModifications.addSpawn(biome -> biome.getBiomeHolder().is(BiomeTags.IS_FOREST),
            MobCategory.MONSTER, MysteriousEntities.THE_FORGOTTEN_WARLOCK,
            10, 1, 2);
    }

    private static <T extends Entity> EntityType<T> makeEntity(String name, EntityType<T> type) {
        ENTITIES.put(type, new ResourceLocation(MysteriousBiomes.MOD_ID, name));
        return type;
    }
}
