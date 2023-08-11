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
package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import terrablender.api.TerraBlenderApi;

public class MysteriousBiomes implements ModInitializer, TerraBlenderApi {

    public static final String MOD_ID = "mysteriousbiomes";

    public static final WoodType BLOODWOOD_WOOD_TYPE = new WoodType("bloodwood",
            new BlockSetType("bloodwood"));
    public static final WoodType GHOSTLY_WOOD_TYPE = new WoodType("ghostly",
            new BlockSetType("ghostly"));
    public static final WoodType SORBUS_WOOD_TYPE = new WoodType("sorbus",
            new BlockSetType("sorbus"));
    public static final WoodType SEEPING_WOOD_TYPE = new WoodType("seeping",
            new BlockSetType("seeping"));

    @Override
    public void onInitialize() {
        new MysteriousContentSetup();
        MysteriousContentSetup.BLOCKS.forEach((id, block) -> Registry.register(Registries.BLOCK, id, block.get()));
        MysteriousContentSetup.ITEMS.forEach((id, item) -> Registry.register(Registries.ITEM, id, item.get()));
        BiomeModifications.addSpawn(biome -> biome.getBiomeRegistryEntry().isIn(BiomeTags.IS_FOREST), SpawnGroup.MONSTER,
                MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 10, 1, 2);
        new MysteriousWorldGen();
    }
}
