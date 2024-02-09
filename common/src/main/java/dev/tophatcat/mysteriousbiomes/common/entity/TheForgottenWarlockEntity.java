/*
 * A Minecraft mod made for SpookyJam 2017, contains Halloween themed biomes and content.
 * Copyright (C) KiriCattus 2013 - 2024
 * https://github.com/kiris-mods/mysterious-biomes/blob/dev/LICENSE.md
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
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
 */
package dev.tophatcat.mysteriousbiomes.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class TheForgottenWarlockEntity extends Monster implements RangedAttackMob {

    private static final EntityDataAccessor<Byte> CLIMBING =
        SynchedEntityData.defineId(TheForgottenWarlockEntity.class, EntityDataSerializers.BYTE);

    public TheForgottenWarlockEntity(
        EntityType<? extends TheForgottenWarlockEntity> type, Level world) {
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
        targetSelector.addGoal(7, new TheForgottenWarlockTargetGoal<>(this, Player.class));
        targetSelector.addGoal(8, new TheForgottenWarlockTargetGoal<>(this, AbstractSkeleton.class));
        targetSelector.addGoal(9, new TheForgottenWarlockTargetGoal<>(this, Zombie.class));
        targetSelector.addGoal(9, new TheForgottenWarlockTargetGoal<>(this, Creeper.class));
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
                level()
                    .addParticle(
                        ParticleTypes.PORTAL,
                        getX() + (random.nextDouble() - 0.5D) * (double) getBbWidth(),
                        getY() + random.nextDouble() * (double) getBbHeight(),
                        getZ() + (random.nextDouble() - 0.5D) * (double) getBbWidth(),
                        (random.nextDouble() - 0.5D) * 2.0D,
                        -random.nextDouble(),
                        (random.nextDouble() - 0.5D) * 2.0D);
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

    // TODO Change it from an arrow to a blue fireball that doesn't burn flammable in world blocks,
    // only entities.
    @Override
    public void performRangedAttack(LivingEntity target, float pullProgress) {
        ItemStack item =
            this.getProjectile(
                this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
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

    public static <T extends Mob> boolean checkSpawnRules(
        EntityType<T> entityType,
        ServerLevelAccessor levelAccessor,
        MobSpawnType spawnType,
        BlockPos pos,
        RandomSource source) {
        return true;
    }

    public static class TheForgottenWarlockAttackGoal extends RangedAttackGoal {

        public TheForgottenWarlockAttackGoal(TheForgottenWarlockEntity theForgottenWarlock) {
            super(theForgottenWarlock, 0.25D, 40, 10.0F);
        }
    }

    public static class TheForgottenWarlockTargetGoal<T extends LivingEntity>
        extends NearestAttackableTargetGoal<T> {

        public TheForgottenWarlockTargetGoal(
            TheForgottenWarlockEntity theForgottenWarlock, Class<T> classTarget) {
            super(theForgottenWarlock, classTarget, true);
        }
    }
}
