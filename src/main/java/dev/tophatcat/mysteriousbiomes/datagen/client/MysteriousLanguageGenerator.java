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
package dev.tophatcat.mysteriousbiomes.datagen.client;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class MysteriousLanguageGenerator extends FabricLanguageProvider {

    public MysteriousLanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(MysteriousBiomes.ITEM_GROUP, "Mysterious Biomes");
        translationBuilder.add(MysteriousBiomes.THE_FORGOTTEN_WARLOCK, "The Forgotten Warlock");
        translationBuilder.add("item.mysteriousbiomes.the_forgotten_warlock_spawn_egg",
                "The Forgotten Warlock Spawn Egg");
        translationBuilder.add(MysteriousContentSetup.BLOODIED_DIRT.get(), "Bloodied Dirt");
        translationBuilder.add(MysteriousContentSetup.BLOODIED_GRASS.get(), "Bloodied Grass");

        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getLog().get(), "Bloodwood Log");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getWood().get(), "Bloodwood Wood");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getStrippedLog().get(), "Bloodwood Stripped Log");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getStrippedWood().get(), "Bloodwood Stripped Wood");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getButton().get(), "Bloodwood Button");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getDoor().get(), "Bloodwood Door");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getFence().get(), "Bloodwood Fence");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getGate().get(), "Bloodwood Gate");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getLeaves().get(), "Bloodwood Leaves");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getPlanks().get(), "Bloodwood Planks");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get(), "Bloodwood Pressure Plate");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getSapling().get(), "Bloodwood Sapling");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getSign().get(), "Bloodwood Sign");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get(), "Bloodwood Hanging Sign");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getSlab().get(), "Bloodwood Slab");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getStairs().get(), "Bloodwood Stairs");
        translationBuilder.add(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get(), "Bloodwood Trapdoor");

        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getLog().get(), "Ghostly Log");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getWood().get(), "Ghostly Wood");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getStrippedLog().get(), "Ghostly Stripped Log");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getStrippedWood().get(), "Ghostly Stripped Wood");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getButton().get(), "Ghostly Button");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getDoor().get(), "Ghostly Door");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getFence().get(), "Ghostly Fence");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getGate().get(), "Ghostly Gate");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getLeaves().get(), "Ghostly Leaves");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getPlanks().get(), "Ghostly Planks");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getPressurePlate().get(), "Ghostly Pressure Plate");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getSapling().get(), "Ghostly Sapling");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getSign().get(), "Ghostly Sign");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getHangingSign().get(), "Ghostly Hanging Sign");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getSlab().get(), "Ghostly Slab");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getStairs().get(), "Ghostly Stairs");
        translationBuilder.add(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get(), "Ghostly Trapdoor");

        translationBuilder.add(MysteriousBlockTypes.SEEPING.getLog().get(), "Seeping Log");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getWood().get(), "Seeping Wood");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getStrippedLog().get(), "Seeping Stripped Log");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getStrippedWood().get(), "Seeping Stripped Wood");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getButton().get(), "Seeping Button");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getDoor().get(), "Seeping Door");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getFence().get(), "Seeping Fence");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getGate().get(), "Seeping Gate");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getLeaves().get(), "Seeping Leaves");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getPlanks().get(), "Seeping Planks");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getPressurePlate().get(), "Seeping Pressure Plate");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getSapling().get(), "Seeping Sapling");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getSign().get(), "Seeping Sign");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getHangingSign().get(), "Seeping Hanging Sign");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getSlab().get(), "Seeping Slab");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getStairs().get(), "Seeping Stairs");
        translationBuilder.add(MysteriousBlockTypes.SEEPING.getTrapdoor().get(), "Seeping Trapdoor");

        translationBuilder.add(MysteriousBlockTypes.SORBUS.getLog().get(), "Sorbus Log");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getWood().get(), "Sorbus Wood");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getStrippedLog().get(), "Sorbus Stripped Log");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getStrippedWood().get(), "Sorbus Stripped Wood");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getButton().get(), "Sorbus Button");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getDoor().get(), "Sorbus Door");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getFence().get(), "Sorbus Fence");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getGate().get(), "Sorbus Gate");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getLeaves().get(), "Sorbus Leaves");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getPlanks().get(), "Sorbus Planks");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getPressurePlate().get(), "Sorbus Pressure Plate");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getSapling().get(), "Sorbus Sapling");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getSign().get(), "Sorbus Sign");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getHangingSign().get(), "Sorbus Hanging Sign");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getSlab().get(), "Sorbus Slab");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getStairs().get(), "Sorbus Stairs");
        translationBuilder.add(MysteriousBlockTypes.SORBUS.getTrapdoor().get(), "Sorbus Trapdoor");

        translationBuilder.add(MysteriousBlockTypes.WALNUT.getLog().get(), "Walnut Log");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getWood().get(), "Walnut Wood");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getStrippedLog().get(), "Walnut Stripped Log");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getStrippedWood().get(), "Walnut Stripped Wood");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getButton().get(), "Walnut Button");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getDoor().get(), "Walnut Door");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getFence().get(), "Walnut Fence");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getGate().get(), "Walnut Gate");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getLeaves().get(), "Walnut Leaves");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getPlanks().get(), "Walnut Planks");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getPressurePlate().get(), "Walnut Pressure Plate");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getSapling().get(), "Walnut Sapling");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getSign().get(), "Walnut Sign");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getHangingSign().get(), "Walnut Hanging Sign");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getSlab().get(), "Walnut Slab");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getStairs().get(), "Walnut Stairs");
        translationBuilder.add(MysteriousBlockTypes.WALNUT.getTrapdoor().get(), "Walnut Trapdoor");
    }
}
