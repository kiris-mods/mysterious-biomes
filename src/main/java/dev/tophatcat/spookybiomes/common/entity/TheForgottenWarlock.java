/*
 * Spooky Biomes - https://github.com/tophatcats-mods/spooky-biomes
 * Copyright (C) 2013-2022 <KiriCattus>
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
package dev.tophatcat.spookybiomes.common.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class TheForgottenWarlock extends HostileEntity implements RangedAttackMob {

    private static final TrackedData<Byte> CLIMBING
        = DataTracker.registerData(TheForgottenWarlock.class, TrackedDataHandlerRegistry.BYTE);

    public TheForgottenWarlock(EntityType<? extends TheForgottenWarlock> type, World world) {
        super(type, world);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(1, new SwimGoal(this));
        goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        goalSelector.add(3, new LookAroundGoal(this));
        goalSelector.add(4, new RevengeGoal(this));
        goalSelector.add(5, new WanderAroundGoal(this, 1.0D));
        targetSelector.add(6, new TheForgottenWarlockAttackGoal(this));
        targetSelector.add(7, new TheForgottenWarlockTargetGoal<>(this, PlayerEntity.class));
        targetSelector.add(8, new TheForgottenWarlockTargetGoal<>(this, AbstractSkeletonEntity.class));
        targetSelector.add(9, new TheForgottenWarlockTargetGoal<>(this, ZombieEntity.class));
        isFireImmune();
    }

    /**
     * prepare the mobs basic stats.
     *
     * @return The attributes of the mob for setup.
     */
    public static DefaultAttributeContainer.Builder createHostileAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 25.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.set(CLIMBING, (byte) 0);
    }

    @Override
    public void tick() {
        super.tick();
        if (!world.isClient) {
            setClimbingWall(horizontalCollision);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (world.isClient) {
            for (int i = 0; i < 2; ++i) {
                world.addParticle(ParticleTypes.PORTAL, getX() + (random.nextDouble()
                        - 0.5D) * (double) getWidth(), getY() + random.nextDouble()
                        * (double) getHeight(), getZ() + (random.nextDouble() - 0.5D)
                        * (double) getWidth(), (random.nextDouble() - 0.5D) * 2.0D,
                    -random.nextDouble(), (random.nextDouble() - 0.5D) * 2.0D);
            }
        }
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.25F;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    @Override
    public void attack(@NotNull LivingEntity target, float p_82196_2_) {
        PersistentProjectileEntity arrow = new ArrowEntity(world, this);
        double targetX = target.getX() - getX();
        double targetY = target.getBodyY(0.3333333333333333D) - arrow.getY();
        double targetZ = target.getZ() - getZ();
        double d0 = Math.sqrt(targetX * targetX + targetZ * targetZ) * 0.20000000298023224D;
        arrow.setVelocity(targetX, targetY + d0, targetZ, 1.5F, 10.0F);
        playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        world.spawnEntity(arrow);
    }

    @Override
    public boolean isClimbing() {
        return isClimbingWall();
    }

    public boolean isClimbingWall() {
        return (dataTracker.get(CLIMBING) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte value = dataTracker.get(CLIMBING);
        if (climbing) {
            value |= 1;
        } else {
            value &= -2;
        }

        dataTracker.set(CLIMBING, value);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    public static class TheForgottenWarlockAttackGoal extends ProjectileAttackGoal {

        public TheForgottenWarlockAttackGoal(TheForgottenWarlock theForgottenWarlock) {
            super(theForgottenWarlock, 0.25D, 40, 10.0F);
        }
    }

    public static class TheForgottenWarlockTargetGoal<T extends LivingEntity> extends TargetGoal<T> {

        public TheForgottenWarlockTargetGoal(TheForgottenWarlock theForgottenWarlock, Class<T> classTarget) {
            super(theForgottenWarlock, classTarget, true);
        }
    }
}
