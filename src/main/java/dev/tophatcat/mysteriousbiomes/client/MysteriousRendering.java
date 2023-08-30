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
import dev.tophatcat.mysteriousbiomes.utils.MysteriousBlockTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class MysteriousRendering implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(MysteriousBiomes.THE_FORGOTTEN_WARLOCK, RenderTheForgottenWarlock::new);
        EntityModelLayerRegistry.registerModelLayer(ModelTheForgottenWarlock.THE_FORGOTTEN_WARLOCK_LOCATION,
                ModelTheForgottenWarlock::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.BLOODWOOD.getSapling().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.BLOODWOOD.getDoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.GHOSTLY.getSapling().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.GHOSTLY.getDoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SEEPING.getSapling().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SEEPING.getTrapdoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SEEPING.getDoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SORBUS.getSapling().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SORBUS.getTrapdoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SORBUS.getDoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SAKURA.getSapling().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SAKURA.getTrapdoor().get(),
                RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousBlockTypes.SAKURA.getDoor().get(),
                RenderLayer.getCutout());
        FabricLoader.getInstance().getModContainer(MysteriousBiomes.MOD_ID).ifPresent(modContainer
            -> ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MysteriousBiomes.MOD_ID,
                "legacy_textures"), modContainer, ResourcePackActivationType.NORMAL));
    }
}
