package io.github.proxyneko.spookybiomes.server.items;

import io.github.proxyneko.spookybiomes.server.blocks.BaseDoor;
import net.minecraft.item.ItemDoor;

public class ItemBaseDoor extends ItemDoor {

    public ItemBaseDoor(BaseDoor block) {
        super(block);
        setRegistryName(block.getRegistryName().getPath().replace("tile.", ""));
        setTranslationKey(block.getTranslationKey().replace("tile.", ""));
        setCreativeTab(block.getCreativeTab());
    }
}