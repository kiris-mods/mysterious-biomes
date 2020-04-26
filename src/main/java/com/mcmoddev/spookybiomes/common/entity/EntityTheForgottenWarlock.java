package com.mcmoddev.spookybiomes.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class EntityTheForgottenWarlock extends EntityMob implements IRangedAttackMob {

    private static final DataParameter<Byte> CLIMBING =
            EntityDataManager.createKey(EntityTheForgottenWarlock.class, DataSerializers.BYTE);

    public EntityTheForgottenWarlock(World world) {
        super(world);
        setSize(0.65F, 1.45F);
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(5, new EntityAIWander(this, 1.0D));
        tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(6, new EntityAILookIdle(this));
        targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        tasks.addTask(4, new AITheForgottenWarlockAttack(this));
        targetTasks.addTask(2, new AITheForgottenWarlockTarget<>(this, EntityPlayer.class));
        targetTasks.addTask(3, new AITheForgottenWarlockTarget<>(this, EntitySkeleton.class));
        targetTasks.addTask(3, new AITheForgottenWarlockTarget<>(this, EntityZombie.class));
        isImmuneToFire = true;
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(CLIMBING, (byte) 0);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!world.isRemote) {
            setBesideClimbableBlock(isCollidedHorizontally);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (world.isRemote) {
            for (int i = 0; i < 2; ++i) {
                world.spawnParticle(EnumParticleTypes.PORTAL, posX + (rand.nextDouble() - 0.5D) * (double)
                        width, posY + rand.nextDouble() * (double) height, posZ
                        + (rand.nextDouble() - 0.5D) * (double) width, (rand.nextDouble() - 0.5D)
                        * 2.0D, -this.rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Override
    public boolean isOnLadder() {
        return isBesideClimbableBlock();
    }

    @Nonnull
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float p_82196_2_) {
        EntityArrow arrow = new EntityTippedArrow(world, this);
        double d0 = target.posX - posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - arrow.posY;
        double d2 = target.posZ - posZ;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        arrow.setThrowableHeading(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, (float) (14 -
                world.getDifficulty().getDifficultyId() * 4));
        arrow.setDamage((double) (p_82196_2_ * 2.0F) + rand.nextGaussian() * 0.25D
                + (double) ((float) world.getDifficulty().getDifficultyId() * 0.11F));
        playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
        world.spawnEntity(arrow);
    }

    public boolean isBesideClimbableBlock() {
        return (dataManager.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte value = dataManager.get(CLIMBING);
        if (climbing) {
            value = (byte) (value | 1);
        } else {
            value = (byte) (value & -2);
        }

        dataManager.set(CLIMBING, value);
    }

    public static class AITheForgottenWarlockAttack extends EntityAIAttackRanged {

        public AITheForgottenWarlockAttack(EntityTheForgottenWarlock theForgottenWarlock) {
            super(theForgottenWarlock, 0.25D, 40, 10.0F);
        }
    }

    public static class AITheForgottenWarlockTarget<T extends EntityLivingBase>
            extends EntityAINearestAttackableTarget<T> {

        public AITheForgottenWarlockTarget(EntityTheForgottenWarlock theForgottenWarlock, Class<T> classTarget) {
            super(theForgottenWarlock, classTarget, true);
        }
    }
}
