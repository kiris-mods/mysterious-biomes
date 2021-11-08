/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2021 <ProxyNeko>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
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
package dev.tophatcat.spookybiomes.init;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.common.blocks.tiles.SpookySignBlockEntity;
import dev.tophatcat.spookybiomes.common.entity.TheForgottenWarlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnPlacements.Type;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpookyEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
        .create(ForgeRegistries.BLOCK_ENTITIES, SpookyBiomes.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITIES
        = DeferredRegister.create(ForgeRegistries.ENTITIES, SpookyBiomes.MOD_ID);

    public static final RegistryObject<BlockEntityType<SpookySignBlockEntity>> SIGN = BLOCK_ENTITIES.register(
        "sign", () -> BlockEntityType.Builder.of(SpookySignBlockEntity::new,
            SpookyBlocks.SORBUS_SIGN.get(), SpookyBlocks.SORBUS_WALL_SIGN.get(),
            SpookyBlocks.GHOSTLY_SIGN.get(), SpookyBlocks.GHOSTLY_WALL_SIGN.get(),
            SpookyBlocks.SEEPING_SIGN.get(), SpookyBlocks.SEEPING_WALL_SIGN.get(),
            SpookyBlocks.BLOODWOOD_SIGN.get(), SpookyBlocks.BLOODWOOD_WALL_SIGN.get()).build(null));

    public static void registerSpookyContent(final FMLCommonSetupEvent event) {
        event.enqueueWork(SpookyEntities::registerSpawnPlacements);
    }

    private static void registerSpawnPlacements() {
        SpawnPlacements.register(THE_FORGOTTEN_WARLOCK.get(), Type.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }

    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(THE_FORGOTTEN_WARLOCK.get(), TheForgottenWarlock.prepareAttributes().build());
    }

    public static final RegistryObject<EntityType<TheForgottenWarlock>> THE_FORGOTTEN_WARLOCK
        = ENTITIES.register("the_forgotten_warlock",
        () -> EntityType.Builder.of(TheForgottenWarlock::new, MobCategory.MONSTER)
            .sized(0.65F, 1.45F)
            .setTrackingRange(80)
            .setUpdateInterval(1)
            .setShouldReceiveVelocityUpdates(true)
            .build(new ResourceLocation(SpookyBiomes.MOD_ID, "the_forgotten_warlock").toString()));
}
