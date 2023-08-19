/*
 * Mysterious Biomes - https://github.com/tophatcats-mods/mysterious-biomes
 * Copyright (C) 2013-2023 <KiriCattus>
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
package dev.tophatcat.mysteriousbiomes.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class EntityTheForgottenWarlock extends HostileEntity implements RangedAttackMob {

    private static final TrackedData<Byte> CLIMBING
            = DataTracker.registerData(EntityTheForgottenWarlock.class, TrackedDataHandlerRegistry.BYTE);

    public EntityTheForgottenWarlock(EntityType<? extends EntityTheForgottenWarlock> type, World world) {
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
        targetSelector.add(7, new TheForgottenWarlockTargetGoal<>(
            this, PlayerEntity.class));
        targetSelector.add(8, new TheForgottenWarlockTargetGoal<>(
                this, AbstractSkeletonEntity.class));
        targetSelector.add(9, new TheForgottenWarlockTargetGoal<>(
            this, ZombieEntity.class));
        targetSelector.add(9, new TheForgottenWarlockTargetGoal<>(
            this, CreeperEntity.class));
        isFireImmune();
    }

    public static DefaultAttributeContainer.Builder theForgottenWarlockAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(CLIMBING, (byte) 0);
    }

    @Override
    public void tick() {
        super.tick();
        if (!getWorld().isClient) {
            setClimbingWall(horizontalCollision);
        }
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (getWorld().isClient) {
            for (int i = 0; i < 2; ++i) {
                getWorld().addParticle(ParticleTypes.PORTAL, getX() + (random.nextDouble()
                                - 0.5D) * (double) getWidth(), getY() + random.nextDouble()
                                * (double) getHeight(), getZ() + (random.nextDouble() - 0.5D)
                                * (double) getWidth(), (random.nextDouble() - 0.5D) * 2.0D,
                        -random.nextDouble(), (random.nextDouble() - 0.5D) * 2.0D);
            }
        }
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 2.15F;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    //TODO Change it from an arrow to a blue fireball that doesn't burn flammable in world blocks, only entities.
    @Override
    public void attack(@NotNull LivingEntity target, float pullProgress) {
        PersistentProjectileEntity arrow = new ArrowEntity(getWorld(), this);
        double targetX = target.getX() - getX();
        double targetY = target.getBodyY(0.3333333333333333) - arrow.getY();
        double targetZ = target.getZ() - getZ();
        double d0 = Math.sqrt(targetX * targetX + targetZ * targetZ) * 0.20000000298023224D;
        arrow.setVelocity(targetX, targetY + d0, targetZ, 1.5F, 10.0F);
        playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (getRandom().nextFloat() * 0.4F + 0.8F));
        getWorld().spawnEntity(arrow);
    }

    @Override
    public boolean isClimbing() {
        return isClimbingWall();
    }

    public boolean isClimbingWall() {
        return (this.dataTracker.get(CLIMBING) & 1) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte b = this.dataTracker.get(CLIMBING);
        if (climbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.dataTracker.set(CLIMBING, b);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    public static class TheForgottenWarlockAttackGoal extends ProjectileAttackGoal {

        public TheForgottenWarlockAttackGoal(EntityTheForgottenWarlock theForgottenWarlock) {
            super(theForgottenWarlock, 0.25D, 40, 10.0F);
        }
    }

    public static class TheForgottenWarlockTargetGoal<T extends LivingEntity> extends ActiveTargetGoal<T> {

        public TheForgottenWarlockTargetGoal(EntityTheForgottenWarlock theForgottenWarlock, Class<T> classTarget) {
            super(theForgottenWarlock, classTarget, true);
        }
    }
}
