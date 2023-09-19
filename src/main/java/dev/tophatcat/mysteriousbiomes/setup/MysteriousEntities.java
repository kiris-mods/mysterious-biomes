/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.mysteriousbiomes.setup;

import dev.tophatcat.mysteriousbiomes.entity.EntityTheForgottenWarlock;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

public final class MysteriousEntities {

    private MysteriousEntities() {
        throw new UnsupportedOperationException("MysteriousEntities only contains static definitions...");
    }

    public static final EntityType<EntityTheForgottenWarlock> THE_FORGOTTEN_WARLOCK = MysteriousUtils.makeEntity(
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
        MysteriousUtils.ENTITIES.keySet().forEach(entityType -> Registry.register(BuiltInRegistries.ENTITY_TYPE,
            MysteriousUtils.ENTITIES.get(entityType), entityType));
        addSpawnEgg();
        addSpawns();
    }

    static void addSpawns() {
        //TODO Tweak the biome tags once our biomes are setup.
        BiomeModifications.addSpawn(biome -> biome.getBiomeHolder().is(BiomeTags.IS_FOREST),
            MobCategory.MONSTER, MysteriousEntities.THE_FORGOTTEN_WARLOCK,
            10, 1, 2);
    }

    static void addSpawnEgg() {
        MysteriousUtils.makeMobEgg("the_forgotten_warlock_spawn_egg",
            new SpawnEggItem(MysteriousEntities.THE_FORGOTTEN_WARLOCK, 0x0519f7,
                0x161a4a, new Item.Properties()));
    }
}
