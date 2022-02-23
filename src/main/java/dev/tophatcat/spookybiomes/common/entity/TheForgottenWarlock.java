/*
 * Spooky Biomes - https://tophatcat.dev/spooky-biomes
 * Copyright (C) 2016-2022 <KiriCattus>
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
 * https://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 */
package dev.tophatcat.spookybiomes.common.entity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class TheForgottenWarlock extends Monster implements RangedAttackMob {

    private static final EntityDataAccessor<Byte> CLIMBING
        = SynchedEntityData.defineId(TheForgottenWarlock.class, EntityDataSerializers.BYTE);

    public TheForgottenWarlock(EntityType<? extends TheForgottenWarlock> type, Level world) {
        super(type, world);
    }

    @Override
    //TODO Fix priorities
    protected void registerGoals() {
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        goalSelector.addGoal(4, new HurtByTargetGoal(this));
        goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
        targetSelector.addGoal(6, new TheForgottenWarlockAttackGoal(this));
        targetSelector.addGoal(7, new TheForgottenWarlockTargetGoal<>(this,
            Player.class));
        targetSelector.addGoal(8, new TheForgottenWarlockTargetGoal<>(this,
            AbstractSkeleton.class));
        targetSelector.addGoal(9, new TheForgottenWarlockTargetGoal<>(this,
            Zombie.class));
        fireImmune();
    }

    /**
     * prepare the mobs basic stats.
     *
     * @return The attributes of the mob for setup.
     */
    public static AttributeSupplier.Builder prepareAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 25.0D)
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
        if (!level.isClientSide) {
            setClimbing(horizontalCollision);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (level.isClientSide) {
            for (int i = 0; i < 2; ++i) {
                level.addParticle(ParticleTypes.PORTAL, getX() + (random.nextDouble()
                        - 0.5D) * (double) getBbWidth(), getY() + random.nextDouble()
                        * (double) getBbHeight(), getZ() + (random.nextDouble() - 0.5D)
                        * (double) getBbWidth(), (random.nextDouble() - 0.5D) * 2.0D,
                    -random.nextDouble(), (random.nextDouble() - 0.5D) * 2.0D);
            }
        }
    }

    @Override
    protected float getStandingEyeHeight(@Nonnull Pose pose, @Nonnull EntityDimensions dimensions) {
        return 1.25F;
    }

    @Nonnull
    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    @Override
    public void performRangedAttack(@Nonnull LivingEntity target, float p_82196_2_) {
        AbstractArrow arrow = new Arrow(level, this);
        double targetX = target.getX() - getX();
        double targetY = target.getY(0.3333333333333333D) - arrow.getY();
        double targetZ = target.getZ() - getZ();
        double d0 = Math.sqrt(targetX * targetX + targetZ * targetZ) * 0.20000000298023224D;
        arrow.shoot(targetX, targetY + d0, targetZ, 1.5F, 10.0F);
        playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        level.addFreshEntity(arrow);
    }

    @Override
    public boolean onClimbable() {
        return isClimbing();
    }

    public boolean isClimbing() {
        return (entityData.get(CLIMBING) & 1) != 0;
    }

    public void setClimbing(boolean climbing) {
        byte value = entityData.get(CLIMBING);
        if (climbing) {
            value |= 1;
        } else {
            value &= -2;
        }

        entityData.set(CLIMBING, value);
    }

    public static class TheForgottenWarlockAttackGoal extends RangedAttackGoal {

        public TheForgottenWarlockAttackGoal(TheForgottenWarlock theForgottenWarlock) {
            super(theForgottenWarlock, 0.25D, 40, 10.0F);
        }
    }

    public static class TheForgottenWarlockTargetGoal<T extends LivingEntity>
        extends NearestAttackableTargetGoal<T> {

        public TheForgottenWarlockTargetGoal(TheForgottenWarlock theForgottenWarlock, Class<T> classTarget) {
            super(theForgottenWarlock, classTarget, true);
        }
    }
}
