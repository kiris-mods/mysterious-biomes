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
package dev.tophatcat.mysteriousbiomes.client;

import dev.tophatcat.mysteriousbiomes.MysteriousBiomes;
import dev.tophatcat.mysteriousbiomes.init.MysteriousEntities;
import dev.tophatcat.mysteriousbiomes.init.MysteriousRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import org.quiltmc.qsl.resource.loader.api.ResourceLoader;
import org.quiltmc.qsl.resource.loader.api.ResourcePackActivationType;

public class MysteriousRendering implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer container) {
        EntityRendererRegistry.register(MysteriousEntities.THE_FORGOTTEN_WARLOCK, RenderTheForgottenWarlock::new);
        EntityModelLayerRegistry.registerModelLayer(ModelTheForgottenWarlock.THE_FORGOTTEN_WARLOCK_LOCATION,
            ModelTheForgottenWarlock::getTexturedModelData);
        QuiltLoader.getModContainer(MysteriousBiomes.MOD_ID).ifPresent(modContainer
            -> ResourceLoader.registerBuiltinResourcePack(new ResourceLocation(MysteriousBiomes.MOD_ID,
            "legacy_textures"), modContainer, ResourcePackActivationType.NORMAL));

        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.BLOODWOOD_SAPLING.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.BLOODWOOD_TRAPDOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.BLOODWOOD_DOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.GHOSTLY_SAPLING.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.GHOSTLY_TRAPDOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.GHOSTLY_DOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.SEEPING_SAPLING.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.SEEPING_TRAPDOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.SEEPING_DOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.SORBUS_SAPLING.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.SORBUS_TRAPDOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.SORBUS_DOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.WALNUT_SAPLING.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.WALNUT_TRAPDOOR.get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousRegistry.WALNUT_DOOR.get());
    }
}
