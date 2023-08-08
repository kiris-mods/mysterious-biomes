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
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;

public class MysteriousBiomes implements ModInitializer {

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
    public void onInitialize(ModContainer mod) {
        new MysteriousContentSetup();
        MysteriousContentSetup.BLOCKS.forEach((id, block) -> Registry.register(BuiltInRegistries.BLOCK, id, block.get()));
        MysteriousContentSetup.ITEMS.forEach((id, item) -> Registry.register(BuiltInRegistries.ITEM, id, item.get()));
        BiomeModifications.addSpawn(biome -> biome.getBiomeHolder().is(BiomeTags.IS_FOREST), MobCategory.MONSTER,
            MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, 10, 1, 2);
        new MysteriousWorldGen();
    }
}
