package dev.tophatcat.mysteriousbiomes.items;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotAttributes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class CharmOfMistProtection extends TrinketItem {

    public CharmOfMistProtection(Properties settings) {
        super(settings);
    }

    //TODO Figure out why testing this doesn't let you put the item into the trinkets slot.
    public Multimap<Attribute, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        // +10% movement speed
        modifiers.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(uuid, "mysteriousbiomes:movement_speed", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL));
        // If the player has access to ring slots, this will give them an extra one
        SlotAttributes.addSlotModifier(modifiers, "hand/ring", uuid, 1, AttributeModifier.Operation.ADDITION);
        return modifiers;
    }
}
