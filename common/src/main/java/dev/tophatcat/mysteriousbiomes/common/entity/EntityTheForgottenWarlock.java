package dev.tophatcat.mysteriousbiomes.common.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class EntityTheForgottenWarlock extends Monster implements RangedAttackMob {

    private static final EntityDataAccessor<Byte> CLIMBING
        = SynchedEntityData.defineId(EntityTheForgottenWarlock.class, EntityDataSerializers.BYTE);

    public EntityTheForgottenWarlock(EntityType<? extends EntityTheForgottenWarlock> type, Level world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        goalSelector.addGoal(4, new HurtByTargetGoal(this));
        goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
        targetSelector.addGoal(6, new TheForgottenWarlockAttackGoal(this));
        targetSelector.addGoal(7, new TheForgottenWarlockTargetGoal<>(
            this, Player.class));
        targetSelector.addGoal(8, new TheForgottenWarlockTargetGoal<>(
            this, AbstractSkeleton.class));
        targetSelector.addGoal(9, new TheForgottenWarlockTargetGoal<>(
            this, Zombie.class));
        targetSelector.addGoal(9, new TheForgottenWarlockTargetGoal<>(
            this, Creeper.class));
        fireImmune();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 40.0D)
            .add(Attributes.ATTACK_DAMAGE, 7.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(CLIMBING, (byte) 0);
    }

    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide) {
            setClimbingWall(horizontalCollision);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (level().isClientSide) {
            for (int i = 0; i < 2; ++i) {
                level().addParticle(ParticleTypes.PORTAL, getX() + (random.nextDouble()
                        - 0.5D) * (double) getBbWidth(), getY() + random.nextDouble()
                        * (double) getBbHeight(), getZ() + (random.nextDouble() - 0.5D)
                        * (double) getBbWidth(), (random.nextDouble() - 0.5D) * 2.0D,
                    -random.nextDouble(), (random.nextDouble() - 0.5D) * 2.0D);
            }
        }
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
        return 2.15F;
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    //TODO Change it from an arrow to a blue fireball that doesn't burn flammable in world blocks, only entities.
    @Override
    public void performRangedAttack(@NotNull LivingEntity target, float pullProgress) {
        ItemStack item = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
        AbstractArrow arrow = getArrow(item, pullProgress);
        double targetX = target.getX() - getX();
        double targetY = target.getY(0.3333333333333333) - arrow.getY();
        double targetZ = target.getZ() - getZ();
        double d0 = Math.sqrt(targetX * targetX + targetZ * targetZ) * 0.20000000298023224D;
        arrow.shoot(targetX, targetY + d0, targetZ, 1.5F, 10.0F);
        playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        level().addFreshEntity(arrow);
    }

    protected AbstractArrow getArrow(ItemStack $$0, float $$1) {
        return ProjectileUtil.getMobArrow(this, $$0, $$1);
    }

    @Override
    public boolean onClimbable() {
        return isClimbingWall();
    }

    public boolean isClimbingWall() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte b = this.entityData.get(CLIMBING);
        if (climbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(CLIMBING, b);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    public static class TheForgottenWarlockAttackGoal extends RangedAttackGoal {

        public TheForgottenWarlockAttackGoal(EntityTheForgottenWarlock theForgottenWarlock) {
            super(theForgottenWarlock, 0.25D, 40, 10.0F);
        }
    }

    public static class TheForgottenWarlockTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {

        public TheForgottenWarlockTargetGoal(EntityTheForgottenWarlock theForgottenWarlock, Class<T> classTarget) {
            super(theForgottenWarlock, classTarget, true);
        }
    }
}
