/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2013-2022 <KiriCattus>
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
import dev.tophatcat.mysteriousbiomes.setup.MysteriousEntitySetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO Block tags.
//TODO Sign stuff!
//TODO Check for and replace previous mod name/id in code/resources.
//TODO Convert to the new item group system in 1.19.3.
public class MysteriousBiomes implements ModInitializer {

    public static final String MOD_ID = "mysteriousbiomes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //Sign type stuff for custom signs.
    public static final WoodType BLOODWOOD_WOOD_TYPE = WoodType.register(new WoodType("bloodwood"));
    public static final WoodType GHOSTLY_WOOD_TYPE = WoodType.register(new WoodType("ghostly"));
    public static final WoodType SORBUS_WOOD_TYPE = WoodType.register(new WoodType("sorbus"));
    public static final WoodType SEEPING_WOOD_TYPE = WoodType.register(new WoodType("seeping"));
    public static final WoodType SAKURA_WOOD_TYPE = WoodType.register(new WoodType("sakura"));

    //SpookyBiomesInjection.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());

    public static final CreativeModeTab ITEM_TAB = QuiltItemGroup.createWithIcon(new ResourceLocation(MOD_ID,
            "group"), () -> new ItemStack(MysteriousWoodTypes.GHOSTLY.getSapling().get()));

    @Override
    public void onInitialize(ModContainer mod) {
        new MysteriousContentSetup();
        MysteriousContentSetup.BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, block.get()));
        MysteriousContentSetup.ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, item.get()));
        BiomeModifications.addSpawn(biome -> biome.getBiomeHolder().is(BiomeTags.IS_FOREST), MobCategory.MONSTER,
            MysteriousEntitySetup.THE_FORGOTTEN_WARLOCK, 10, 1, 2);
    }
}
