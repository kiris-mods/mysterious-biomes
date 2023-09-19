/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
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
package dev.tophatcat.mysteriousbiomes.datagen;

import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousBlockStateModelGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.client.MysteriousLanguageGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousBlockLootTableGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.MysteriousRecipeGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.tags.MysteriousBlockTagGenerator;
import dev.tophatcat.mysteriousbiomes.datagen.server.tags.MysteriousItemTagGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MysteriousDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(MysteriousLanguageGenerator::new);
        pack.addProvider(MysteriousBlockTagGenerator::new);
        pack.addProvider(MysteriousItemTagGenerator::new);
        pack.addProvider(MysteriousBlockLootTableGenerator::new);
        pack.addProvider(MysteriousRecipeGenerator::new);
        pack.addProvider(MysteriousBlockStateModelGenerator::new);
    }
}
