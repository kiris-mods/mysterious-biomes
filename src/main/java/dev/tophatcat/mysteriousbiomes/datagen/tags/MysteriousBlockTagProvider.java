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
package dev.tophatcat.mysteriousbiomes.datagen.tags;

import dev.tophatcat.mysteriousbiomes.setup.MysteriousBlockTypes;
import dev.tophatcat.mysteriousbiomes.setup.MysteriousContentSetup;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MysteriousBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public MysteriousBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(MysteriousBlockTags.PLANKS)
            .add(MysteriousBlockTypes.BLOODWOOD.getPlanks().get())
            .add(MysteriousBlockTypes.GHOSTLY.getPlanks().get())
            .add(MysteriousBlockTypes.SEEPING.getPlanks().get())
            .add(MysteriousBlockTypes.SORBUS.getPlanks().get())
            .add(MysteriousBlockTypes.SAKURA.getPlanks().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_BUTTONS)
            .add(MysteriousBlockTypes.BLOODWOOD.getButton().get())
            .add(MysteriousBlockTypes.GHOSTLY.getButton().get())
            .add(MysteriousBlockTypes.SEEPING.getButton().get())
            .add(MysteriousBlockTypes.SORBUS.getButton().get())
            .add(MysteriousBlockTypes.SAKURA.getButton().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_DOORS)
            .add(MysteriousBlockTypes.BLOODWOOD.getDoor().get())
            .add(MysteriousBlockTypes.GHOSTLY.getDoor().get())
            .add(MysteriousBlockTypes.SEEPING.getDoor().get())
            .add(MysteriousBlockTypes.SORBUS.getDoor().get())
            .add(MysteriousBlockTypes.SAKURA.getDoor().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_STAIRS)
            .add(MysteriousBlockTypes.BLOODWOOD.getStairs().get())
            .add(MysteriousBlockTypes.GHOSTLY.getStairs().get())
            .add(MysteriousBlockTypes.SEEPING.getStairs().get())
            .add(MysteriousBlockTypes.SORBUS.getStairs().get())
            .add(MysteriousBlockTypes.SAKURA.getStairs().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_SLABS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSlab().get())
            .add(MysteriousBlockTypes.GHOSTLY.getSlab().get())
            .add(MysteriousBlockTypes.SEEPING.getSlab().get())
            .add(MysteriousBlockTypes.SORBUS.getSlab().get())
            .add(MysteriousBlockTypes.SAKURA.getSlab().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_FENCES)
            .add(MysteriousBlockTypes.BLOODWOOD.getFence().get())
            .add(MysteriousBlockTypes.GHOSTLY.getFence().get())
            .add(MysteriousBlockTypes.SEEPING.getFence().get())
            .add(MysteriousBlockTypes.SORBUS.getFence().get())
            .add(MysteriousBlockTypes.SAKURA.getFence().get());

        getOrCreateTagBuilder(MysteriousBlockTags.SAPLINGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getSapling().get())
            .add(MysteriousBlockTypes.GHOSTLY.getSapling().get())
            .add(MysteriousBlockTypes.SEEPING.getSapling().get())
            .add(MysteriousBlockTypes.SORBUS.getSapling().get())
            .add(MysteriousBlockTypes.SAKURA.getSapling().get());

        getOrCreateTagBuilder(MysteriousBlockTags.LOGS)
            .addTag(MysteriousBlockTags.LOGS_THAT_BURN);

        getOrCreateTagBuilder(MysteriousBlockTags.OVERWORLD_NATURAL_LOGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getLog().get())
            .add(MysteriousBlockTypes.GHOSTLY.getLog().get())
            .add(MysteriousBlockTypes.SEEPING.getLog().get())
            .add(MysteriousBlockTypes.SORBUS.getLog().get())
            .add(MysteriousBlockTypes.SAKURA.getLog().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_PRESSURE_PLATES)
            .add(MysteriousBlockTypes.BLOODWOOD.getPressurePlate().get())
            .add(MysteriousBlockTypes.GHOSTLY.getPressurePlate().get())
            .add(MysteriousBlockTypes.SEEPING.getPressurePlate().get())
            .add(MysteriousBlockTypes.SORBUS.getPressurePlate().get())
            .add(MysteriousBlockTypes.SAKURA.getPressurePlate().get());

        getOrCreateTagBuilder(MysteriousBlockTags.LEAVES)
            .add(MysteriousBlockTypes.BLOODWOOD.getLeaves().get())
            .add(MysteriousBlockTypes.GHOSTLY.getLeaves().get())
            .add(MysteriousBlockTypes.SEEPING.getLeaves().get())
            .add(MysteriousBlockTypes.SORBUS.getLeaves().get())
            .add(MysteriousBlockTypes.SAKURA.getLeaves().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WOODEN_TRAPDOORS)
            .add(MysteriousBlockTypes.BLOODWOOD.getTrapdoor().get())
            .add(MysteriousBlockTypes.GHOSTLY.getTrapdoor().get())
            .add(MysteriousBlockTypes.SEEPING.getTrapdoor().get())
            .add(MysteriousBlockTypes.SORBUS.getTrapdoor().get())
            .add(MysteriousBlockTypes.SAKURA.getTrapdoor().get());

        getOrCreateTagBuilder(MysteriousBlockTags.STANDING_SIGNS)
            .add(Block.getBlockFromItem(MysteriousBlockTypes.BLOODWOOD.getSign().get()))
            .add(Block.getBlockFromItem(MysteriousBlockTypes.GHOSTLY.getSign().get()))
            .add(Block.getBlockFromItem(MysteriousBlockTypes.SEEPING.getSign().get()))
            .add(Block.getBlockFromItem(MysteriousBlockTypes.SORBUS.getSign().get()))
            .add(Block.getBlockFromItem(MysteriousBlockTypes.SAKURA.getSign().get()));

        getOrCreateTagBuilder(MysteriousBlockTags.WALL_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getWallSign().get())
            .add(MysteriousBlockTypes.GHOSTLY.getWallSign().get())
            .add(MysteriousBlockTypes.SEEPING.getWallSign().get())
            .add(MysteriousBlockTypes.SORBUS.getWallSign().get())
            .add(MysteriousBlockTypes.SAKURA.getWallSign().get());

        getOrCreateTagBuilder(MysteriousBlockTags.CEILING_HANGING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getHangingSign().get())
            .add(MysteriousBlockTypes.GHOSTLY.getHangingSign().get())
            .add(MysteriousBlockTypes.SEEPING.getHangingSign().get())
            .add(MysteriousBlockTypes.SORBUS.getHangingSign().get())
            .add(MysteriousBlockTypes.SAKURA.getHangingSign().get());

        getOrCreateTagBuilder(MysteriousBlockTags.WALL_HANGING_SIGNS)
            .add(MysteriousBlockTypes.BLOODWOOD.getWallHangingSign().get())
            .add(MysteriousBlockTypes.GHOSTLY.getWallHangingSign().get())
            .add(MysteriousBlockTypes.SEEPING.getWallHangingSign().get())
            .add(MysteriousBlockTypes.SORBUS.getWallHangingSign().get())
            .add(MysteriousBlockTypes.SAKURA.getWallHangingSign().get());

        getOrCreateTagBuilder(MysteriousBlockTags.FENCE_GATES)
            .add(MysteriousBlockTypes.BLOODWOOD.getGate().get())
            .add(MysteriousBlockTypes.GHOSTLY.getGate().get())
            .add(MysteriousBlockTypes.SEEPING.getGate().get())
            .add(MysteriousBlockTypes.SORBUS.getGate().get())
            .add(MysteriousBlockTypes.SAKURA.getGate().get());

        getOrCreateTagBuilder(MysteriousBlockTags.DIRT)
            .add(MysteriousContentSetup.BLOODIED_DIRT.get())
            .add(MysteriousContentSetup.BLOODIED_GRASS.get());

        getOrCreateTagBuilder(MysteriousBlockTags.BUTTONS).addTag(MysteriousBlockTags.WOODEN_BUTTONS);
        getOrCreateTagBuilder(MysteriousBlockTags.DOORS).addTag(MysteriousBlockTags.WOODEN_DOORS);

        getOrCreateTagBuilder(MysteriousBlockTags.BLOODWOOD_LOGS)
            .add(MysteriousBlockTypes.BLOODWOOD.getLog().get())
            .add(MysteriousBlockTypes.BLOODWOOD.getStrippedLog().get())
            .add(MysteriousBlockTypes.BLOODWOOD.getWood().get())
            .add(MysteriousBlockTypes.BLOODWOOD.getStrippedWood().get());

        getOrCreateTagBuilder(MysteriousBlockTags.GHOSTLY_LOGS)
            .add(MysteriousBlockTypes.GHOSTLY.getLog().get())
            .add(MysteriousBlockTypes.GHOSTLY.getStrippedLog().get())
            .add(MysteriousBlockTypes.GHOSTLY.getWood().get())
            .add(MysteriousBlockTypes.GHOSTLY.getStrippedWood().get());

        getOrCreateTagBuilder(MysteriousBlockTags.SORBUS_LOGS)
            .add(MysteriousBlockTypes.SORBUS.getLog().get())
            .add(MysteriousBlockTypes.SORBUS.getStrippedLog().get())
            .add(MysteriousBlockTypes.SORBUS.getWood().get())
            .add(MysteriousBlockTypes.SORBUS.getStrippedWood().get());

        getOrCreateTagBuilder(MysteriousBlockTags.SEEPING_LOGS)
            .add(MysteriousBlockTypes.SEEPING.getLog().get())
            .add(MysteriousBlockTypes.SEEPING.getStrippedLog().get())
            .add(MysteriousBlockTypes.SEEPING.getWood().get())
            .add(MysteriousBlockTypes.SEEPING.getStrippedWood().get());

        getOrCreateTagBuilder(MysteriousBlockTags.SAKURA_LOGS)
            .add(MysteriousBlockTypes.SAKURA.getLog().get())
            .add(MysteriousBlockTypes.SAKURA.getStrippedLog().get())
            .add(MysteriousBlockTypes.SAKURA.getWood().get())
            .add(MysteriousBlockTypes.SAKURA.getStrippedWood().get());

        getOrCreateTagBuilder(MysteriousBlockTags.LOGS_THAT_BURN)
            .addTag(MysteriousBlockTags.BLOODWOOD_LOGS)
            .addTag(MysteriousBlockTags.GHOSTLY_LOGS)
            .addTag(MysteriousBlockTags.SORBUS_LOGS)
            .addTag(MysteriousBlockTags.SEEPING_LOGS)
            .addTag(MysteriousBlockTags.SAKURA_LOGS);

        getOrCreateTagBuilder(MysteriousBlockTags.PRESSURE_PLATES)
            .addTag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES);

        getOrCreateTagBuilder(MysteriousBlockTags.STAIRS)
            .addTag(MysteriousBlockTags.WOODEN_STAIRS);

        getOrCreateTagBuilder(MysteriousBlockTags.SLABS)
            .addTag(MysteriousBlockTags.WOODEN_SLABS);

        getOrCreateTagBuilder(MysteriousBlockTags.TRAPDOORS)
            .addTag(MysteriousBlockTags.WOODEN_TRAPDOORS);

        getOrCreateTagBuilder(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.STANDING_SIGNS)
            .addTag(MysteriousBlockTags.WALL_SIGNS);

        getOrCreateTagBuilder(MysteriousBlockTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.CEILING_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.WALL_HANGING_SIGNS);

        getOrCreateTagBuilder(MysteriousBlockTags.ALL_SIGNS)
            .addTag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.ALL_HANGING_SIGNS);

        getOrCreateTagBuilder(MysteriousBlockTags.FENCES)
            .addTag(MysteriousBlockTags.WOODEN_FENCES);

        getOrCreateTagBuilder(MysteriousBlockTags.AXE_MINEABLE)
            .addTag(MysteriousBlockTags.ALL_HANGING_SIGNS)
            .addTag(MysteriousBlockTags.WOODEN_TRAPDOORS)
            .addTag(MysteriousBlockTags.WOODEN_STAIRS)
            .addTag(MysteriousBlockTags.WOODEN_SLABS)
            .addTag(MysteriousBlockTags.WOODEN_PRESSURE_PLATES)
            .addTag(MysteriousBlockTags.WOODEN_FENCES)
            .addTag(MysteriousBlockTags.WOODEN_DOORS)
            .addTag(MysteriousBlockTags.WOODEN_BUTTONS)
            .addTag(MysteriousBlockTags.SIGNS)
            .addTag(MysteriousBlockTags.SAPLINGS)
            .addTag(MysteriousBlockTags.PLANKS)
            .addTag(MysteriousBlockTags.LOGS)
            .addTag(MysteriousBlockTags.FENCE_GATES);
    }
}
