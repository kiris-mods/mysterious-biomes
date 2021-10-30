package dev.tophatcat.spookybiomes.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * A simple class for registering data providers.
 *
 * <p>This is isolated separately for easier stripping when porting over
 * to Fabric.
 */
public class SpookyDataProviders {

    /**
     * Registers the data providers to the generator.
     *
     * @param event the event instance
     */
    public static void addProviders(final GatherDataEvent event) {
        // Get Common Arguments
        final DataGenerator generator = event.getGenerator();
        final ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // Asset Providers
        if (event.includeClient()) {
            generator.addProvider(new SpookyBlockStates(generator, fileHelper));
            generator.addProvider(new SpookyEnglishLanguage(generator));
        }

        // Server Providers
        if (event.includeServer()) {
            final SpookyBlockTags blockTags = new SpookyBlockTags(generator, fileHelper);
            generator.addProvider(blockTags);
            generator.addProvider(new SpookyItemTags(generator, blockTags, fileHelper));
            generator.addProvider(new SpookyRecipes(generator));
        }
    }
}
