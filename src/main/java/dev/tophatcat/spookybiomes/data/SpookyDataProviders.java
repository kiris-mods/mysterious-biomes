/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation;
 * Specifically version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * A simple class for registering data providers.
 *
 * This is isolated separately for easier stripping when porting over
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
            generator.addProvider(new SpookyLootTables(generator));
        }
    }
}
