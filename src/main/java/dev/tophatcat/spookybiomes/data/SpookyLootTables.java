package dev.tophatcat.spookybiomes.data;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SpookyLootTables extends LootTableProvider {
    public SpookyLootTables(final DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Nonnull
    @Override
    public List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return List.of(Pair.of(SpookyBlockLoot::new, LootContextParamSets.BLOCK));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationContext) {
        map.forEach((loc, table) -> LootTables.validate(validationContext, loc, table));
    }
}
