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

import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import org.quiltmc.qsl.item.content.registry.api.ItemContentRegistries;

import java.util.List;

public class MysteriousFlammableBlocks {

    public static void init() {
        var mysteriousWoodTypes = List.of(
            MysteriousBlockTypes.BLOODWOOD,
            MysteriousBlockTypes.GHOSTLY,
            MysteriousBlockTypes.SORBUS,
            MysteriousBlockTypes.SEEPING,
            MysteriousBlockTypes.WALNUT);

        mysteriousWoodTypes.forEach(woodType -> {
            ItemContentRegistries.FUEL_TIMES.put(woodType.getLog().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getStrippedLog().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getWood().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getStrippedWood().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getPlanks().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getStairs().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getSlab().get().asItem(), 150);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getTrapdoor().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getPressurePlate().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getFence().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getGate().get().asItem(), 300);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getSign().get(), 200);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getHangingSign().get().asItem(), 800);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getButton().get().asItem(), 100);
            ItemContentRegistries.FUEL_TIMES.put(woodType.getSapling().get().asItem(), 100);
        });
    }
}
