package com.mcmoddev.spookybiomes.init;

import com.mcmoddev.spookybiomes.SpookyBiomes;
import com.mcmoddev.spookybiomes.common.entity.EntityTheForgottenWarlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class EntityRegistry {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void onRegister(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().registerAll(
                EntityEntryBuilder.create()
                        .entity(EntityTheForgottenWarlock.class)
                        .id(new ResourceLocation(SpookyBiomes.MODID, "the_forgotten_warlock"), 0)
                        .name(SpookyBiomes.MODID + ".the_forgotten_warlock")
                        .egg(1447446, 5060690)
                        .factory(EntityTheForgottenWarlock::new)
                        .tracker(80, 1, true)
                        .build()
        );
    }
}
