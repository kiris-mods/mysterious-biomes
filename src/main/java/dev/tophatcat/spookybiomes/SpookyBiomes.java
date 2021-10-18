package dev.tophatcat.spookybiomes;

import dev.tophatcat.spookybiomes.init.SpookyBiomesInjection;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import dev.tophatcat.spookybiomes.init.SpookyEntities;
import dev.tophatcat.spookybiomes.init.SpookyItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@Mod(SpookyBiomes.MOD_ID)
@EventBusSubscriber(bus = Bus.MOD)
public class SpookyBiomes {

    public static final String MOD_ID = "spookybiomes";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public SpookyBiomes() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus(), forge = MinecraftForge.EVENT_BUS;
        SpookyEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SpookyBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SpookyItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SpookyBiomesInjection.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        mod.addListener(SpookyEntities::registerSpookyContent);
        mod.addListener(SpookyEntities::addEntityAttributes);
    }

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(MOD_ID) {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SpookyBlocks.GHOSTLY_SAPLING.get());
        }
    };
}
