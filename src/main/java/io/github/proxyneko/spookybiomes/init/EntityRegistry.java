package io.github.proxyneko.spookybiomes.init;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.server.entity.EntityTheForgottenWarlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class EntityRegistry {

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().registerAll
                (
                        EntityEntryBuilder.create()
                                .entity(EntityTheForgottenWarlock.class)
                                .id(new ResourceLocation(SpookyBiomes.MODID, "the_forgotten_warlock"), 0)
                                .name(SpookyBiomes.MODID + ".the_forgotten_warlock")
                                .egg(1447446, 5060690)
                                .factory(EntityTheForgottenWarlock::new)
                                .tracker(80, 10, true)
                                .build()
                );
    }
}
