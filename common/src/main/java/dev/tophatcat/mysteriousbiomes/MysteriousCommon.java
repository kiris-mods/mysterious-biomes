package dev.tophatcat.mysteriousbiomes;

import dev.tophatcat.mysteriousbiomes.core.MysteriousRegistry;
import dev.tophatcat.mysteriousbiomes.platform.Services;
import dev.tophatcat.mysteriousbiomes.utils.MysteriousWoodType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.biome.Biome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysteriousCommon {

    //TODO Make sure all of the following work properly/are implemented.
    //Structures
    //World generation.
    //Saplings.
    //Mist rendering code/shaders need to be made.
    //Poison effect on player entering the biome with a chat warning.
    //Poison the player if they enter the biome without a charm for protection.
    //Compat with Eight's mod.
    //Full set of textures for all blocks and for The Forgotten Warlock.
    public static final String MOD_ID = "mysteriousbiomes";
    public static final String MOD_NAME = "Mysterious Biomes";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
        new ResourceLocation(MOD_ID, "group"));

    public static final ResourceKey<Biome> BLOODIED_PLAINS
        = ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "bloodied_plains"));
    public static final ResourceKey<Biome> GHOSTLY_WOODLANDS
        = ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "ghostly_woodlands"));
    public static final ResourceKey<Biome> SEEPING_FOREST
        = ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "seeping_forest"));
    public static final ResourceKey<Biome> SORBUS_HIGHLANDS
        = ResourceKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "sorbus_highlands"));

    public static void init() {
        LOG.debug("We are currently loaded via the {} mod loader in a {} environment!",
            Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());
        MysteriousRegistry.init();
        MysteriousWoodType.init();
    }
}
