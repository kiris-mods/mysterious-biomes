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
package dev.tophatcat.mysteriousbiomes.datagen;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.BiConsumer;

public class BlockLootGenerator extends SimpleFabricLootTableProvider {

    public BlockLootGenerator(FabricDataOutput dataGen) {
        super(dataGen, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
        var spookyWoodTypes = List.of(
                MysteriousBlockTypes.BLOODWOOD.getName(),
                MysteriousBlockTypes.GHOSTLY.getName(),
                MysteriousBlockTypes.SORBUS.getName(),
                MysteriousBlockTypes.SEEPING.getName());
        var spookyBlockTypes = List.of(
                "trapdoor", "slab", "stairs", "planks",
                "log", "stripped_log", "wood", "stripped_wood",
                "gate", "fence", "button", "pressure_plate", "sapling", "sign");

        /*
        spookyWoodTypes.forEach(woodType -> {
            spookyBlockTypes.forEach(blockType -> {
                var spookyIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_" + blockType);
                biConsumer.accept(new Identifier(spookyIdentifier.getNamespace(), "blocks/"
                        + spookyIdentifier.getPath()), BlockLootTableGenerator.createSingleItemTable(
                        MysteriousContentSetup.BLOCKS.get(spookyIdentifier).get().asItem()));
            });

            var doorIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_door");
            biConsumer.accept(new Identifier(doorIdentifier.getNamespace(), "blocks/"
                    + doorIdentifier.getPath()), BlockLootTableGenerator.createDoorTable(
                    MysteriousContentSetup.BLOCKS.get(doorIdentifier).get()));

            var leafIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_leaves");
            var saplingIdentifier = new Identifier(MysteriousBiomes.MOD_ID, woodType + "_sapling");
            biConsumer.accept(new Identifier(leafIdentifier.getNamespace(), "blocks/"
                    + leafIdentifier.getPath()), BlockLootTableGenerator.createLeavesDrops(
                    MysteriousContentSetup.BLOCKS.get(leafIdentifier).get(),
                    MysteriousContentSetup.BLOCKS.get(saplingIdentifier).get(),
                    0.05F, 0.0625F, 0.083333336F, 0.1F));
        });

        var dirtIdentifier = new Identifier(MysteriousBiomes.MOD_ID, "bloodied_dirt");
        biConsumer.accept(new Identifier(dirtIdentifier.getNamespace(), "blocks/"
                        + dirtIdentifier.getPath()),
                BlockLootTableGenerator.createSingleItemTable(MysteriousContentSetup.BLOCKS.get(dirtIdentifier).get().asItem()));

        var grassIdentifier = new Identifier(MysteriousBiomes.MOD_ID, "bloodied_grass");
        biConsumer.accept(new Identifier(grassIdentifier.getNamespace(), "blocks/"
                        + grassIdentifier.getPath()),
                BlockLootTableGenerator.dropsWithSilkTouch(MysteriousContentSetup.BLOCKS.get(grassIdentifier).get().asItem()));

         */
    }
}
