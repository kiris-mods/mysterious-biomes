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

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousBlockTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.ItemTagProvider {

    private static final TagKey<Item> BLOODWOOD_LOGS
        = TagKey.of(RegistryKeys.ITEM, new Identifier(MysteriousBiomes.MOD_ID, "bloodwood_logs"));
    private static final TagKey<Item> GHOSTLY_LOGS
        = TagKey.of(RegistryKeys.ITEM, new Identifier(MysteriousBiomes.MOD_ID, "ghostly_logs"));
    private static final TagKey<Item> SORBUS_LOGS
        = TagKey.of(RegistryKeys.ITEM, new Identifier(MysteriousBiomes.MOD_ID, "sorbus_logs"));
    private static final TagKey<Item> SEEPING_LOGS
        = TagKey.of(RegistryKeys.ITEM, new Identifier(MysteriousBiomes.MOD_ID, "seeping_logs"));

    public BlockTagGenerator(FabricDataOutput output,
                             CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BLOODWOOD_LOGS)
            .add(MysteriousBlockTypes.BLOODWOOD.log.get().asItem())
            .add(MysteriousBlockTypes.BLOODWOOD.stripped_log.get().asItem())
            .add(MysteriousBlockTypes.BLOODWOOD.wood.get().asItem())
            .add(MysteriousBlockTypes.BLOODWOOD.stripped_wood.get().asItem());
    }
}
