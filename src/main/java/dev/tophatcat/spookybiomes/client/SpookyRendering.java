package dev.tophatcat.spookybiomes.client;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import dev.tophatcat.spookybiomes.init.SpookyEntities;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
    }

    @SubscribeEvent
    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SpookyEntities.THE_FORGOTTEN_WARLOCK.get(),
            RenderTheForgottenWarlock::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TheForgottenWarlockModel.THE_FORGOTTEN_WARLOCK_LOCATION,
            TheForgottenWarlockModel::createBodyLayer);

    }
}
