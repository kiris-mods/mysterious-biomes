/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
package dev.tophatcat.spookybiomes.client;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import dev.tophatcat.spookybiomes.init.SpookyEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = SpookyBiomes.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class SpookyRendering {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.BLOODWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.BLOODWOOD_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.BLOODWOOD_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.GHOSTLY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.GHOSTLY_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.GHOSTLY_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.SEEPING_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.SEEPING_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.SEEPING_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.SORBUS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.SORBUS_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SpookyBlocks.SORBUS_DOOR.get(), RenderType.cutout());
        event.enqueueWork(() -> {
            Sheets.addWoodType(SpookyBiomes.SORBUS_WOOD_TYPE);
            Sheets.addWoodType(SpookyBiomes.GHOSTLY_WOOD_TYPE);
            Sheets.addWoodType(SpookyBiomes.SEEPING_WOOD_TYPE);
            Sheets.addWoodType(SpookyBiomes.BLOODWOOD_WOOD_TYPE);
        });
    }

    @SubscribeEvent
    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SpookyEntities.THE_FORGOTTEN_WARLOCK.get(),
            RenderTheForgottenWarlock::new);
        event.registerBlockEntityRenderer(SpookyEntities.SIGN.get(), SignRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION,
            TheForgottenWarlockModel::createBodyLayer);
    }
}
