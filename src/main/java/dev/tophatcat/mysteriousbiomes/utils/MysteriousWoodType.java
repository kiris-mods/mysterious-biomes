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
package dev.tophatcat.mysteriousbiomes.utils;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public final class MysteriousWoodType {

    private MysteriousWoodType() {
        throw new UnsupportedOperationException("MysteriousWoodTypes only contains static definitions...");
    }

    public static void init() {
        WoodType.register(BLOODWOOD_WOOD_TYPE);
        WoodType.register(GHOSTLY_WOOD_TYPE);
        WoodType.register(SORBUS_WOOD_TYPE);
        WoodType.register(SEEPING_WOOD_TYPE);
        WoodType.register(WALNUT_WOOD_TYPE);
    }

    public static final WoodType BLOODWOOD_WOOD_TYPE = new WoodType("mysteriousbiomes:bloodwood",
        new BlockSetType("mysteriousbiomes:bloodwood"));
    public static final WoodType GHOSTLY_WOOD_TYPE = new WoodType("mysteriousbiomes:ghostly",
        new BlockSetType("mysteriousbiomes:ghostly"));
    public static final WoodType SORBUS_WOOD_TYPE = new WoodType("mysteriousbiomes:sorbus",
        new BlockSetType("mysteriousbiomes:sorbus"));
    public static final WoodType SEEPING_WOOD_TYPE = new WoodType("mysteriousbiomes:seeping",
        new BlockSetType("mysteriousbiomes:seeping"));
    public static final WoodType WALNUT_WOOD_TYPE = new WoodType("mysteriousbiomes:walnut",
        new BlockSetType("mysteriousbiomes:walnut"));
}
