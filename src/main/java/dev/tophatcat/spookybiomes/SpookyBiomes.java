/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2013-2022 <KiriCattus>
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
package dev.tophatcat.spookybiomes;

import dev.tophatcat.spookybiomes.common.entity.TheForgottenWarlock;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

public class SpookyBiomes implements ModInitializer {

    public static final String MOD_ID = "spookybiomes";
    public static final EntityType<TheForgottenWarlock> THE_FORGOTTEN_WARLOCK = Registry.register(
        Registry.ENTITY_TYPE, new Identifier(SpookyBiomes.MOD_ID, "the_forgotten_warlock"),
        QuiltEntityTypeBuilder.<TheForgottenWarlock>createMob()
            .spawnGroup(SpawnGroup.MONSTER)
            .entityFactory(TheForgottenWarlock::new)
            .defaultAttributes(TheForgottenWarlock.createHostileAttributes())
            .setDimensions(EntityDimensions.fixed(0.65F, 1.45F))
            .maxChunkTrackingRange(1)
            .spawnRestriction(SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canMobSpawn)
            .build());


    //public static final SignType SORBUS_WOOD_TYPE = SignType.register(new SignType(MOD_ID + ":sorbus"));
    //public static final SignType GHOSTLY_WOOD_TYPE = SignType.register(new SignType(MOD_ID + ":ghostly"));
    //public static final SignType SEEPING_WOOD_TYPE = SignType.register(new SignType(MOD_ID + ":seeping"));
    //public static final SignType BLOODWOOD_WOOD_TYPE = SignType.register(new SignType(MOD_ID + ":bloodwood"));

    public SpookyBiomes() {
        //SpookyBiomesInjection.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //TODO Add signs and make them work.
    //TODO Fix hardness/resistance of all blocks.
    //TODO Block tags.
    //TODO Convert to the new item group system in 1.19.3.
    public static final ItemGroup ITEM_TAB = QuiltItemGroup.createWithIcon(
        new Identifier(MOD_ID, "group"), () -> new ItemStack(Items.BEDROCK));

    @Override
    public void onInitialize(ModContainer mod) {
        new SpookyContentRegistry();
        SpookyContentRegistry.BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, block.get()));
        SpookyContentRegistry.ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, item.get()));
        BiomeModifications.addSpawn(biome -> biome.getBiomeHolder().isIn(BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER, THE_FORGOTTEN_WARLOCK, 10, 1, 2);
    }
}
