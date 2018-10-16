package io.github.proxyneko.spookybiomes.common.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

public enum MobInfo {

    THEFORGOTTENWARLOCK(EntityTheForgottenWarlock.class, 25, 7);

    final Class<? extends EntityLiving> clazz;
    final double maxHealth;
    final double attackDamage;

    MobInfo(Class<? extends EntityLiving> clazz, double baseHealth, double baseAttack) {
        this.clazz = clazz;
        maxHealth = baseHealth;
        attackDamage = baseAttack;
    }

    public Class<? extends EntityLiving> getClazz() {
        return clazz;
    }

    public void applyAttributes(EntityLivingBase entity) {
        entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(maxHealth);
        IAttributeInstance ai = entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE);
        if (ai == null) {
            entity.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
            ai = entity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE);
        }

        ai.setBaseValue(attackDamage);
    }
}