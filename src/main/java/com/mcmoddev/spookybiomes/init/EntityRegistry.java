package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class EntityRegistry {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onRegister(RegistryEvent.Register<EntityEntry> event) {
        net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(
                new ResourceLocation(SpookyBiomes.MODID, "the_forgotten_warlock"),
                EntityTheForgottenWarlock.class, SpookyBiomes.MODID + ".the_forgotten_warlock",
                0, SpookyBiomes.MODID, 80, 1, true
        );
        net.minecraftforge.fml.common.registry.EntityRegistry.registerEgg(
                new ResourceLocation(SpookyBiomes.MODID, "the_forgotten_warlock"),
                1447446, 5060690
        );
    }
}
