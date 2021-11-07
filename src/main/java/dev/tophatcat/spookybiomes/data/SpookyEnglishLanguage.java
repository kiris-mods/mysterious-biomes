package dev.tophatcat.spookybiomes.data;

import dev.tophatcat.spookybiomes.SpookyBiomes;
import dev.tophatcat.spookybiomes.init.SpookyBlocks;
import dev.tophatcat.spookybiomes.init.SpookyEntities;
import net.minecraft.Util;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class SpookyEnglishLanguage extends LanguageProvider {
    public SpookyEnglishLanguage(final DataGenerator gen) {
        super(gen, SpookyBiomes.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.spookybiomes", "Spooky Biomes");

        addBlock(SpookyBlocks.SORBUS_LOG_STRIPPED, "Stripped Sorbus Log");
        addBlock(SpookyBlocks.SORBUS_LOG, "Sorbus Log");
        addBlock(SpookyBlocks.SORBUS_LEAVES, "Sorbus Leaves");
        addBlock(SpookyBlocks.SORBUS_PLANKS, "Sorbus Planks");
        addBlock(SpookyBlocks.SORBUS_SAPLING, "Sorbus Sapling");
        addBlock(SpookyBlocks.SORBUS_GATE, "Sorbus Gate");
        addBlock(SpookyBlocks.SORBUS_DOOR, "Sorbus Door");
        addBlock(SpookyBlocks.SORBUS_TRAPDOOR, "Sorbus Trapdoor");
        addBlock(SpookyBlocks.SORBUS_STAIRS, "Sorbus Stairs");
        addBlock(SpookyBlocks.SORBUS_FENCE, "Sorbus Fence");
        addBlock(SpookyBlocks.SORBUS_SLAB, "Sorbus Slab");
        addBlock(SpookyBlocks.SORBUS_PRESSURE_PLATE, "Sorbus Pressure Plate");
        addBlock(SpookyBlocks.SORBUS_BUTTON, "Sorbus Button");
        addBlock(SpookyBlocks.SORBUS_SIGN, "Sorbus Sign");
        // Just in case, we manually create the translation key for the wall sign block, even though nothing uses it,
        // only because vanilla Minecraft provides the same translation keys
        add(Util.makeDescriptionId("block", SpookyBlocks.SORBUS_WALL_SIGN.getId()), "Sorbus Wall Sign");

        addBlock(SpookyBlocks.GHOSTLY_LOG_STRIPPED, "Stripped Ghostly Log");
        addBlock(SpookyBlocks.GHOSTLY_LOG, "Ghostly Log");
        addBlock(SpookyBlocks.GHOSTLY_LEAVES, "Ghostly Leaves");
        addBlock(SpookyBlocks.GHOSTLY_PLANKS, "Ghostly Planks");
        addBlock(SpookyBlocks.GHOSTLY_SAPLING, "Ghostly Sapling");
        addBlock(SpookyBlocks.GHOSTLY_GATE, "Ghostly Gate");
        addBlock(SpookyBlocks.GHOSTLY_DOOR, "Ghostly Door");
        addBlock(SpookyBlocks.GHOSTLY_TRAPDOOR, "Ghostly Trapdoor");
        addBlock(SpookyBlocks.GHOSTLY_STAIRS, "Ghostly Stairs");
        addBlock(SpookyBlocks.GHOSTLY_FENCE, "Ghostly Fence");
        addBlock(SpookyBlocks.GHOSTLY_SLAB, "Ghostly Slab");
        addBlock(SpookyBlocks.GHOSTLY_PRESSURE_PLATE, "Ghostly Pressure Plate");
        addBlock(SpookyBlocks.GHOSTLY_BUTTON, "Ghostly Button");
        addBlock(SpookyBlocks.GHOSTLY_SIGN, "Ghostly Sign");
        add(Util.makeDescriptionId("block", SpookyBlocks.GHOSTLY_WALL_SIGN.getId()), "Ghostly Wall Sign");

        addBlock(SpookyBlocks.SEEPING_LOG_STRIPPED, "Stripped Seeping Log");
        addBlock(SpookyBlocks.SEEPING_LOG, "Seeping Log");
        addBlock(SpookyBlocks.SEEPING_LEAVES, "Seeping Leaves");
        addBlock(SpookyBlocks.SEEPING_PLANKS, "Seeping Planks");
        addBlock(SpookyBlocks.SEEPING_SAPLING, "Seeping Sapling");
        addBlock(SpookyBlocks.SEEPING_GATE, "Seeping Gate");
        addBlock(SpookyBlocks.SEEPING_DOOR, "Seeping Door");
        addBlock(SpookyBlocks.SEEPING_TRAPDOOR, "Seeping Trapdoor");
        addBlock(SpookyBlocks.SEEPING_STAIRS, "Seeping Stairs");
        addBlock(SpookyBlocks.SEEPING_FENCE, "Seeping Fence");
        addBlock(SpookyBlocks.SEEPING_SLAB, "Seeping Slab");
        addBlock(SpookyBlocks.SEEPING_PRESSURE_PLATE, "Seeping Pressure Plate");
        addBlock(SpookyBlocks.SEEPING_BUTTON, "Seeping Button");
        addBlock(SpookyBlocks.SEEPING_SIGN, "Seeping Sign");
        add(Util.makeDescriptionId("block", SpookyBlocks.SEEPING_WALL_SIGN.getId()), "Seeping Wall Sign");

        addBlock(SpookyBlocks.BLOODWOOD_LOG_STRIPPED, "Stripped Blood Log");
        addBlock(SpookyBlocks.BLOODWOOD_LOG, "Blood Log");
        addBlock(SpookyBlocks.BLOODWOOD_LEAVES, "Blood Leaves");
        addBlock(SpookyBlocks.BLOODWOOD_PLANKS, "Blood Planks");
        addBlock(SpookyBlocks.BLOODWOOD_SAPLING, "Blood Sapling");
        addBlock(SpookyBlocks.BLOODWOOD_GATE, "Blood Gate");
        addBlock(SpookyBlocks.BLOODWOOD_DOOR, "Blood Door");
        addBlock(SpookyBlocks.BLOODWOOD_TRAPDOOR, "Blood Trapdoor");
        addBlock(SpookyBlocks.BLOODWOOD_STAIRS, "Blood Stairs");
        addBlock(SpookyBlocks.BLOODWOOD_FENCE, "Blood Fence");
        addBlock(SpookyBlocks.BLOODWOOD_SLAB, "Blood Slab");
        addBlock(SpookyBlocks.BLOODWOOD_PRESSURE_PLATE, "Blood Pressure Plate");
        addBlock(SpookyBlocks.BLOODWOOD_BUTTON, "Blood Button");
        addBlock(SpookyBlocks.BLOODWOOD_SIGN, "Blood Sign");
        add(Util.makeDescriptionId("block", SpookyBlocks.BLOODWOOD_WALL_SIGN.getId()), "Blood Wall Sign");

        addBlock(SpookyBlocks.BLOODIED_DIRT, "Bloodied Dirt");
        addBlock(SpookyBlocks.BLOODIED_GRASS, "Bloodied Grass");

        addEntityType(SpookyEntities.THE_FORGOTTEN_WARLOCK, "The Forgotten Warlock");

        add("spookybiomes.config.biomeGeneration", "Biome Generation");
        add("spookybiomes.config.biomeGeneration.tooltip", "Biome settings for Spooky Biomes");
        add("spookybiomes.config.ghostlyBiomeWeight", "Ghostly Biome Weight");
        add("spookybiomes.config.sorbusBiomeWeight", "Sorbus Biome Weight");

        add("spookybiomes.config.treeGeneration", "Tree Generation");
        add("spookybiomes.config.treeGeneration.tooltip", "Tree generation settings for Spooky Biomes trees");
        add("spookybiomes.config.ghostlyOnHills", "Ghostly Trees on hills");
        add("spookybiomes.config.sorbusOnHills", "Sorbus Trees on hills");
    }
}
