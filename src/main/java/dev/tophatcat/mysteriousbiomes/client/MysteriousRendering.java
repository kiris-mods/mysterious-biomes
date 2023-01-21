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
package dev.tophatcat.mysteriousbiomes.client;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousEntitySetup;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousWoodTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class MysteriousRendering implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {
        EntityRendererRegistry.register(MysteriousEntitySetup.THE_FORGOTTEN_WARLOCK, (RenderTheForgottenWarlock::new));
        EntityModelLayerRegistry.registerModelLayer(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION,
            TheForgottenWarlockModel::createBodyLayer);
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.BLOODWOOD.getSapling().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.BLOODWOOD.getTrapdoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.BLOODWOOD.getDoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.GHOSTLY.getSapling().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.GHOSTLY.getTrapdoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.GHOSTLY.getDoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.SEEPING.getSapling().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.SEEPING.getTrapdoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.SEEPING.getDoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.SORBUS.getSapling().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.SORBUS.getTrapdoor().get());
        BlockRenderLayerMap.put(RenderType.cutout(), MysteriousWoodTypes.SORBUS.getDoor().get());
    }
}
