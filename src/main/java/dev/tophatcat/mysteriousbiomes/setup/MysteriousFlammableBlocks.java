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
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import java.util.List;

public class MysteriousFlammableBlocks {

    public static void init() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        var mysteriousWoodTypes = List.of(
                MysteriousBlockTypes.BLOODWOOD,
                MysteriousBlockTypes.GHOSTLY,
                MysteriousBlockTypes.SORBUS,
                MysteriousBlockTypes.SEEPING,
                MysteriousBlockTypes.SAKURA);

        mysteriousWoodTypes.forEach(woodType -> {
            registry.add(woodType.getLog().get(), 5, 5);
            registry.add(woodType.getStrippedLog().get(), 5, 5);
            registry.add(woodType.getWood().get(), 5, 5);
            registry.add(woodType.getStrippedWood().get(), 5, 5);
            registry.add(woodType.getPlanks().get(), 5, 20);
            registry.add(woodType.getLeaves().get(), 30, 60);
            registry.add(woodType.getSlab().get(), 5, 20);
            registry.add(woodType.getGate().get(), 5, 20);
            registry.add(woodType.getFence().get(), 5, 20);
            registry.add(woodType.getStairs().get(), 5, 20);

            FuelRegistry.INSTANCE.add(woodType.getLog().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getStrippedLog().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getWood().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getStrippedWood().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getPlanks().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getStairs().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getSlab().get(), 150);
            FuelRegistry.INSTANCE.add(woodType.getTrapdoor().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getPressurePlate().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getFence().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getGate().get(), 300);
            FuelRegistry.INSTANCE.add(woodType.getSign().get(), 200);
            FuelRegistry.INSTANCE.add(woodType.getHangingSign().get(), 800);
            FuelRegistry.INSTANCE.add(woodType.getButton().get(), 100);
            FuelRegistry.INSTANCE.add(woodType.getSapling().get(), 100);
        });
    }
}
