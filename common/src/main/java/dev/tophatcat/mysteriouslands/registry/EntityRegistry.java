/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
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
 */
package dev.tophatcat.mysteriouslands.registry;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;

public class EntityRegistry {

    public static void init() {
        MysteriousCommon.LOG.debug("Registering entities...");
    }

    //public static final Supplier<EntityType<TheForgottenWarlockEntity>> THE_FORGOTTEN_WARLOCK = RegistryTools.registerEntity(
    //    "the_forgotten_warlock", TheForgottenWarlockEntity::new, 0.75F, 2.30F, MobCategory.MONSTER);

    //public static void registerEntityAttributes(BiConsumer<EntityType<? extends LivingEntity>,
    //    AttributeSupplier> registrar) {
    //    registrar.accept(EntityRegistry.THE_FORGOTTEN_WARLOCK.get(), Mob.createMobAttributes()
    //        .add(Attributes.MAX_HEALTH, 40.0D)
    //        .add(Attributes.ATTACK_DAMAGE, 7.0D)
    //        .add(Attributes.MOVEMENT_SPEED, 0.25D).build());
    //}
}
