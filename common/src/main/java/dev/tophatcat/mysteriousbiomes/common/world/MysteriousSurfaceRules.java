/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
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
package dev.tophatcat.mysteriousbiomes.common.world;

import dev.tophatcat.mysteriousbiomes.MysteriousCommon;
import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class MysteriousSurfaceRules {

    private static final SurfaceRules.RuleSource BLOODIED_GRASS =
        SurfaceRules.state(MysteriousRegistry.BLOODIED_GRASS.get().defaultBlockState());
    private static final SurfaceRules.RuleSource BLOODIED_DIRT =
        SurfaceRules.state(MysteriousRegistry.BLOODIED_DIRT.get().defaultBlockState());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface =
            SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, BLOODIED_GRASS), BLOODIED_DIRT);
        return SurfaceRules.ifTrue(
            SurfaceRules.isBiome(MysteriousCommon.BLOODIED_PLAINS), grassSurface);
    }
}
