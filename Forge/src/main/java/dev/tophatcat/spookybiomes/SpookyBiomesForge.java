package dev.tophatcat.spookybiomes;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod(SpookyBiomesCommon.MOD_ID)
public class SpookyBiomesForge {

    public SpookyBiomesForge() {
        SpookyBiomesCommon.ITEM_TAB = new CreativeModeTab(SpookyBiomesCommon.MOD_ID) {
            @NotNull
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(Items.BLAZE_ROD);
            }
        };

        IEventBus forge = MinecraftForge.EVENT_BUS, mod = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
