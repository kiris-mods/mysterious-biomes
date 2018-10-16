package io.github.proxyneko.spookybiomes.client.rendering;

import io.github.proxyneko.spookybiomes.SpookyBiomes;
import io.github.proxyneko.spookybiomes.api.blocks.BlocksSB;
import io.github.proxyneko.spookybiomes.api.items.ItemsSB;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = SpookyBiomes.MODID)
public class Rendering {

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        //Entity's
        RenderFactory.registerRenders();

        //Blocks
        //Witchwood stuff
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_LOG), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_LEAVES), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_PLANKS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_SAPLING), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_GATE), 0);
        itemModels(ItemsSB.WITCHWOOD_DOOR, 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_TRAPDOOR), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_STAIRS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_FENCE), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.WITCHWOOD_SLAB), 0);

        //Ghostly stuff
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_LOG), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_LEAVES), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_PLANKS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_SAPLING), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_GATE), 0);
        itemModels(ItemsSB.GHOSTLY_DOOR, 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_TRAPDOOR), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_STAIRS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_FENCE), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.GHOSTLY_SLAB), 0);

        //Oozing stuff
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_LOG), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_LEAVES), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_PLANKS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_SAPLING), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_GATE), 0);
        itemModels(ItemsSB.OOZING_DOOR, 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_TRAPDOOR), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_STAIRS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_FENCE), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.OOZING_SLAB), 0);

        //Blood stuff
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_LOG), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_LEAVES), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_PLANKS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_SAPLING), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_GATE), 0);
        itemModels(ItemsSB.BLOOD_DOOR, 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_TRAPDOOR), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_STAIRS), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_FENCE), 0);
        itemModels(Item.getItemFromBlock(BlocksSB.BLOOD_SLAB), 0);
    }

    private static void itemModels(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
