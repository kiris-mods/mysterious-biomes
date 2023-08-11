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

import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class MysteriousRendering implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(MysteriousContentSetup.THE_FORGOTTEN_WARLOCK, (RenderTheForgottenWarlock::new));
        EntityModelLayerRegistry.registerModelLayer(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION,
                TheForgottenWarlockModel::createBodyLayer);
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.BLOODWOOD.getSapling().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.BLOODWOOD.getTrapdoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.BLOODWOOD.getDoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.GHOSTLY.getSapling().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.GHOSTLY.getTrapdoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.GHOSTLY.getDoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.SEEPING.getSapling().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.SEEPING.getTrapdoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.SEEPING.getDoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.SORBUS.getSapling().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.SORBUS.getTrapdoor().get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MysteriousWoodTypes.SORBUS.getDoor().get(), RenderLayer.getCutout());
    }
}
