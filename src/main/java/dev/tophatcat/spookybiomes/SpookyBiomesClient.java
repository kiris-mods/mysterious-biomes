package dev.tophatcat.spookybiomes;

import dev.tophatcat.spookybiomes.init.SpookyEntities;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

// TODO: remove EBS annotation in favor of manual registration.
@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SpookyBiomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SpookyBiomesClient {
    @SubscribeEvent
    public static void onEntityRenderersRegister(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(SpookyEntities.SIGN.get(), SignRenderer::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(SpookyBiomes.SORBUS_WOOD_TYPE);
            Sheets.addWoodType(SpookyBiomes.GHOSTLY_WOOD_TYPE);
            Sheets.addWoodType(SpookyBiomes.SEEPING_WOOD_TYPE);
            Sheets.addWoodType(SpookyBiomes.BLOODWOOD_WOOD_TYPE);
        });
    }
}
