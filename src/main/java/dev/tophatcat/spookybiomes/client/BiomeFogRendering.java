package dev.tophatcat.spookybiomes.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3d;
import dev.tophatcat.spookybiomes.SpookyBiomes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpookyBiomes.MOD_ID, value = Dist.CLIENT)
public class BiomeFogRendering {
    private static double mistX, mistZ;
    private static boolean mistInit;
    private static float mistFarPlaneDistance;

    @SubscribeEvent
    public static void onGetFogColor(EntityViewRenderEvent.FogColors event) {
        Player player = Minecraft.getInstance().player;
        Level level = player.level;
        int x = Mth.floor(player.getX());
        int y = Mth.floor(player.getY());
        int z = Mth.floor(player.getZ());
        BlockState blockStateAtEyes = event.getInfo().getBlockAtCamera();
        if (blockStateAtEyes.getMaterial() == Material.LAVA) {
            return;
        }
        Vector3d mixedColor;
        if (blockStateAtEyes.getMaterial() == Material.WATER) {
            mixedColor = getFogBlendColorWater(level, player, x, y, z, event.getRenderPartialTicks());
        } else {
            mixedColor = getFogBlendColor(level, player, x, y, z, event.getRed(), event.getGreen(), event.getBlue(), event.getRenderPartialTicks());
        }
        if (level.dimension() == Level.NETHER) {
            event.setRed((float) mixedColor.x * 20.5F);
            event.setGreen((float) mixedColor.y * 20.5F);
            event.setBlue((float) mixedColor.z * 20.5F);
        } else {
            event.setRed((float) mixedColor.x);
            event.setGreen((float) mixedColor.y);
            event.setBlue((float) mixedColor.z);
        }
    }

    @SubscribeEvent
    public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
        Player entity = Minecraft.getInstance().player;
        Level level = entity.level;
        int playerX = Mth.floor(entity.getX());
        int playerZ = Mth.floor(entity.getZ());

        if (playerX == mistX && playerZ == mistZ && mistInit) {
            renderFog(event.getType(), mistFarPlaneDistance, 0.50f);
            return;
        }

        mistInit = true;
        int distance = 20;
        float fpDistanceBiomeFog = 0F;
        float weightBiomeFog = 0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(0, 0, 0);

        for (int x = -distance; x <= distance; ++x) {
            for (int z = -distance; z <= distance; ++z) {
                pos.set(playerX + x, 0, playerZ + z);
                //@Nullable IMistyBiome biome = ProxysLib.getMistyBiome(Minecraft.getInstance().getConnection().func_239165_n_().getRegistry(Registry.BIOME_KEY).getKey(level.getBiome(pos)));
                Biome biome = level.getBiome(pos);
                if (Minecraft.getInstance().getConnection().registryAccess().registry(Registry.BIOME_REGISTRY).map(r -> r.getKey(biome).getNamespace().equals(SpookyBiomes.MOD_ID)).orElse(false)) {
                    float distancePart = 0.1f; //biome.getMistDensity(pos); TODO: Make dynamic
                    float weightPart = 1;

                    if (x == -distance) {
                        double xDiff = 1 - (entity.getX() - playerX);
                        distancePart *= xDiff;
                        weightPart *= xDiff;
                    } else {
                        if (x == distance) {
                            double xDiff = (entity.getX() - playerX);
                            distancePart *= xDiff;
                            weightPart *= xDiff;
                        }
                    }

                    if (z == -distance) {
                        double zDiff = 1 - (entity.getZ() - playerZ);
                        distancePart *= zDiff;
                        weightPart *= zDiff;
                    } else {
                        if (z == distance) {
                            double zDiff = (entity.getZ() - playerZ);
                            distancePart *= zDiff;
                            weightPart *= zDiff;
                        }
                    }

                    fpDistanceBiomeFog += distancePart;
                    weightBiomeFog += weightPart;
                }
            }
        }

        float weightMixed = (distance * 2) * (distance * 2);
        float weightDefault = weightMixed - weightBiomeFog;
        float fpDistanceBiomeFogAvg = (weightBiomeFog == 0) ? 0 : fpDistanceBiomeFog / weightBiomeFog;
        float farPlaneDistance = (fpDistanceBiomeFog * 240 + event.getFarPlaneDistance() * weightDefault) / weightMixed;
        float farPlaneDistanceScaleBiome = (0.1f * (1 - fpDistanceBiomeFogAvg) + 0.75f * fpDistanceBiomeFogAvg);
        float farPlaneDistanceScale = (farPlaneDistanceScaleBiome * weightBiomeFog + 0.75f * weightDefault) / weightMixed;
        mistX = entity.getX();
        mistZ = entity.getZ();
        mistFarPlaneDistance = Math.min(farPlaneDistance, event.getFarPlaneDistance());
        renderFog(event.getType(), mistFarPlaneDistance, farPlaneDistanceScale);
    }

    private static void renderFog(FogRenderer.FogMode type, float farPlaneDistance, float farPlaneDistanceScale) {
        if (type == FogRenderer.FogMode.FOG_SKY) {
            RenderSystem.setShaderFogStart(0.0F);
            RenderSystem.setShaderFogEnd(farPlaneDistance);
        } else {
            RenderSystem.setShaderFogStart(farPlaneDistance * farPlaneDistanceScale);
            RenderSystem.setShaderFogEnd(farPlaneDistance);
        }
    }

    private static Vector3d postProcessColor(Level level, LivingEntity player, double r, double g, double b, double renderPartialTicks) {
        double darkScale = (player.yOld + (player.getY() - player.yOld) * renderPartialTicks) * 0.03125; //Hardcoded the void render fog as it doesn't exist anymore
        if (player.hasEffect(MobEffects.BLINDNESS)) {
            int duration = player.getEffect(MobEffects.BLINDNESS).getDuration();
            darkScale *= (duration < 20) ? (1 - duration / 20f) : 0;
        }

        if (darkScale < 1) {
            darkScale = (darkScale < 0) ? 0 : darkScale * darkScale;
            r *= darkScale;
            g *= darkScale;
            b *= darkScale;
        }

        if (player.hasEffect(MobEffects.NIGHT_VISION)) {
            int duration = player.getEffect(MobEffects.NIGHT_VISION).getDuration();
            float brightness = (duration > 200) ? 1 : 0.7f + Mth.sin((float) ((duration - renderPartialTicks) * Math.PI * 0.2f)) * 0.3f;
            double scale = 1 / r;
            scale = Math.min(scale, 1 / g);
            scale = Math.min(scale, 1 / b);
            r = r * (1 - brightness) + r * scale * brightness;
            g = g * (1 - brightness) + g * scale * brightness;
            b = b * (1 - brightness) + b * scale * brightness;
        }

        return new Vector3d(r, g, b);
    }

    private static Vector3d getFogBlendColor(Level level, LivingEntity Player, int playerX, int playerY, int playerZ, float defR, float defG, float defB, double renderPartialTicks) {
        Options settings = Minecraft.getInstance().options;
        int[] ranges = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34};
        int distance = 6;
        if (Minecraft.useFancyGraphics() && settings.renderDistance >= 0 && settings.renderDistance < ranges.length) {
            distance = ranges[settings.renderDistance];
        }

        double rBiomeFog = 0;
        double gBiomeFog = 0;
        double bBiomeFog = 0;
        double weightBiomeFog = 0;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(0, 0, 0);

        for (int x = -distance; x <= distance; ++x) {
            for (int z = -distance; z <= distance; ++z) {
                pos.set(playerX + x, 0, playerZ + z);
                Biome biome = level.getBiome(pos);
                //@Nullable IMistyBiome biome = ProxysLib.getMistyBiome(Minecraft.getInstance().getConnection().func_239165_n_().getRegistry(Registry.BIOME_KEY).getKey(level.getBiome(pos)));

                if (Minecraft.getInstance().getConnection().registryAccess().registry(Registry.BIOME_REGISTRY).map(r -> r.getKey(biome).getNamespace().equals(SpookyBiomes.MOD_ID)).orElse(false)) {
                    int mistColour = biome.getFogColor();

                    if (mistColour >= 0) {
                        double rPart = (mistColour & 0xFF0000) >> 16;
                        double gPart = (mistColour & 0x00FF00) >> 8;
                        double bPart = mistColour & 0x0000FF;
                        float weightPart = 1;

                        if (x == -distance) {
                            double xDiff = 1 - (Player.getX() - playerX);
                            rPart *= xDiff;
                            gPart *= xDiff;
                            bPart *= xDiff;
                            weightPart *= xDiff;
                        } else {
                            if (x == distance) {
                                double xDiff = Player.getX() - playerX;
                                rPart *= xDiff;
                                gPart *= xDiff;
                                bPart *= xDiff;
                                weightPart *= xDiff;
                            }
                        }

                        if (z == -distance) {
                            double zDiff = 1 - (Player.getZ() - playerZ);
                            rPart *= zDiff;
                            gPart *= zDiff;
                            bPart *= zDiff;
                            weightPart *= zDiff;
                        } else {
                            if (z == distance) {
                                double zDiff = Player.getZ() - playerZ;
                                rPart *= zDiff;
                                gPart *= zDiff;
                                bPart *= zDiff;
                                weightPart *= zDiff;
                            }
                        }

                        rBiomeFog += rPart;
                        gBiomeFog += gPart;
                        bBiomeFog += bPart;
                        weightBiomeFog += weightPart;
                    }
                }
            }
        }

        if (weightBiomeFog == 0 || distance == 0) {
            return new Vector3d(defR, defG, defB);
        }

        rBiomeFog /= 255f;
        gBiomeFog /= 255f;
        bBiomeFog /= 255f;

        float celestialAngle = level.getSunAngle((float) renderPartialTicks);
        float baseScale = Mth.clamp(Mth.cos(celestialAngle) * 2.0F + 0.5F, 0, 1);
        double rScale = baseScale * 0.94F + 0.06F;
        double gScale = baseScale * 0.94F + 0.06F;
        double bScale = baseScale * 0.91F + 0.09F;

        float rainStrength = level.getRainLevel((float) renderPartialTicks);
        if (rainStrength > 0) {
            rScale *= 1 - rainStrength * 0.5f;
            gScale *= 1 - rainStrength * 0.5f;
            bScale *= 1 - rainStrength * 0.4f;
        }

        float thunderStrength = level.getThunderLevel((float) renderPartialTicks);
        if (thunderStrength > 0) {
            rScale *= 1 - thunderStrength * 0.5f;
            gScale *= 1 - thunderStrength * 0.5f;
            bScale *= 1 - thunderStrength * 0.5f;
        }

        rBiomeFog *= rScale / weightBiomeFog;
        gBiomeFog *= gScale / weightBiomeFog;
        bBiomeFog *= bScale / weightBiomeFog;
        Vector3d processedColor = postProcessColor(level, Player, rBiomeFog, gBiomeFog, bBiomeFog, renderPartialTicks);
        rBiomeFog = processedColor.x;
        gBiomeFog = processedColor.y;
        bBiomeFog = processedColor.z;

        double weightMixed = (distance * 2) * (distance * 2);
        double weightDefault = weightMixed - weightBiomeFog;
        double rFinal = (rBiomeFog * weightBiomeFog + defR * weightDefault) / weightMixed;
        double gFinal = (gBiomeFog * weightBiomeFog + defG * weightDefault) / weightMixed;
        double bFinal = (bBiomeFog * weightBiomeFog + defB * weightDefault) / weightMixed;

        return new Vector3d(rFinal, gFinal, bFinal);
    }

    private static Vector3d getFogBlendColorWater(Level level, LivingEntity Player, int playerX, int playerY, int playerZ, double renderPartialTicks) {
        byte distance = 2;
        float rBiomeFog = 0.0F;
        float gBiomeFog = 0.0F;
        float bBiomeFog = 0.0F;

        float bMixed;
        for (int weight = -distance; weight <= distance; ++weight) {
            for (int respirationLevel = -distance; respirationLevel <= distance; ++respirationLevel) {
                Biome rMixed = level.getBiome(new BlockPos(playerX + weight, playerY + weight, playerZ + respirationLevel));
                int gMixed = rMixed.getWaterColor(); //Color is stored as is now and not as a multiplier, gonna leave as is for now
                bMixed = (float) ((gMixed & 16711680) >> 16);
                float gPart = (float) ((gMixed & '\uff00') >> 8);
                float bPart = (float) (gMixed & 255);
                double zDiff;
                if (weight == -distance) {
                    zDiff = 1.0D - (Player.getX() - (double) playerX);
                    bMixed = (float) ((double) bMixed * zDiff);
                    gPart = (float) ((double) gPart * zDiff);
                    bPart = (float) ((double) bPart * zDiff);
                } else if (weight == distance) {
                    zDiff = Player.getX() - (double) playerX;
                    bMixed = (float) ((double) bMixed * zDiff);
                    gPart = (float) ((double) gPart * zDiff);
                    bPart = (float) ((double) bPart * zDiff);
                }

                if (respirationLevel == -distance) {
                    zDiff = 1.0D - (Player.getZ() - (double) playerZ);
                    bMixed = (float) ((double) bMixed * zDiff);
                    gPart = (float) ((double) gPart * zDiff);
                    bPart = (float) ((double) bPart * zDiff);
                } else if (respirationLevel == distance) {
                    zDiff = Player.getZ() - (double) playerZ;
                    bMixed = (float) ((double) bMixed * zDiff);
                    gPart = (float) ((double) gPart * zDiff);
                    bPart = (float) ((double) bPart * zDiff);
                }

                rBiomeFog += bMixed;
                gBiomeFog += gPart;
                bBiomeFog += bPart;
            }
        }

        rBiomeFog /= 255.0F;
        gBiomeFog /= 255.0F;
        bBiomeFog /= 255.0F;
        float var20 = (float) (distance * 2 * distance * 2);
        float var21 = (float) EnchantmentHelper.getRespiration(Player) * 0.2F;
        float var22 = (rBiomeFog * 0.02F + var21) / var20;
        float var23 = (gBiomeFog * 0.02F + var21) / var20;
        bMixed = (bBiomeFog * 0.2F + var21) / var20;
        return postProcessColor(level, Player, var22, var23, bMixed, renderPartialTicks);
    }

    // New code for simplification, needs more work
    /*private static final int[] FOG_RANGES = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34 };

    @SubscribeEvent
    public static void setFogColor(final EntityViewRenderEvent.FogColors event) {
        final Player player = Minecraft.getInstance().player;
        final BlockState eyeState = event.getInfo().getBlockAtCamera();
        if (eyeState.getMaterial() == Material.LAVA) return;
        final Vector3d color = eyeState.getMaterial() == Material.WATER
            ? blendWaterFog(player.level, player, event.getRenderPartialTicks())
            : blendFog(player.level, player, event.getRed(), event.getGreen(), event.getBlue(), event.getRenderPartialTicks());
        final float multiplier = player.level.dimension() == Level.NETHER ? 20.5f : 1f;
        event.setRed((float) (color.x * multiplier));
        event.setGreen((float) (color.y * multiplier));
        event.setBlue((float) (color.z * multiplier));
    }

    @SubscribeEvent
    public static void renderFog(final EntityViewRenderEvent.RenderFogEvent event) {
        final Player player = Minecraft.getInstance().player;
        if (mistInit && player.blockPosition().getX() == mistX && player.blockPosition().getZ() == mistZ) {
            renderFog(event.getType(), mistFarPlaneDistance, 0.5f);
            return;
        }

        mistInit = true;
        final Pair<Vector3d, Double> fogData = blend(player.level, b -> 1, 20, new Vector3d(player.getX(), player.getY(), player.getZ()), new BlockPos(player.position()), false, true);
        final float distance = (float) (fogData.getFirst().z * 255f);
        final float weight = fogData.getSecond().floatValue();
        final float weightMixed = 1600;
        final float weightDefault = weightMixed - weight;
        final float avgDist = (weight == 0) ? 0 : distance / weight;
        final float farPlaneDistance = (distance * 240 + event.getFarPlaneDistance() * weightDefault) / weightMixed;
        final float farPlaneDistanceScaleBiome = (0.1f * (1 - avgDist) + 0.75f * avgDist);
        final float farPlaneDistanceScale = (farPlaneDistanceScaleBiome * weight + 0.75f * weightDefault) / weightMixed;
        mistX = player.getX();
        mistZ = player.getZ();
        mistFarPlaneDistance = Math.min(farPlaneDistance, event.getFarPlaneDistance());
        renderFog(event.getType(), mistFarPlaneDistance, farPlaneDistanceScale);
    }

    private static void renderFog(final FogRenderer.FogMode type, final float farPlaneDistance, final float farPlaneDistanceScale) {
        RenderSystem.setShaderFogStart(type == FogRenderer.FogMode.FOG_SKY ? 0f : farPlaneDistance * farPlaneDistanceScale);
        RenderSystem.setShaderFogEnd(farPlaneDistance);
    }

    private static Vector3d postProcessColor(final Player player, double r, double g, double b, final double partialTick) {
        double darkScale = Mth.lerp(partialTick, player.yOld, player.getY()) * 0.03125;
        if (player.hasEffect(MobMobEffects.BLINDNESS)) {
            final int duration = player.getEffect(MobMobEffects.BLINDNESS).getDuration();
            darkScale *= (duration < 20) ? (1 - duration / 20f) : 0;
        }
        if (darkScale < 1) {
            darkScale = (darkScale < 0) ? 0 : darkScale * darkScale;
            r *= darkScale;
            g *= darkScale;
            b *= darkScale;
        }

        if (player.hasEffect(MobMobEffects.NIGHT_VISION)) {
            final int duration = player.getEffect(MobMobEffects.NIGHT_VISION).getDuration();
            final float brightness = (duration > 200) ? 1 : 0.7f + Mth.sin((float) (duration - partialTick) * Mth.PI * 0.2f) * 0.3f;
            final double scale = Math.min(1 / r, Math.min(1 / g, 1 / b));
            r = r * (1 - brightness) + r * scale * brightness;
            g = g * (1 - brightness) + g * scale * brightness;
            b = b * (1 - brightness) + b * scale * brightness;
        }

        return new Vector3d(r, g, b);
    }

    private static Vector3d blendFog(final Level level, final Player player, final float oR, final float oG, final float oB, final double partialTick) {
        final Options options = Minecraft.getInstance().options;
        final int distance = Minecraft.useFancyGraphics() && options.renderDistance >= 0 && options.renderDistance < FOG_RANGES.length
            ? FOG_RANGES[options.renderDistance] : 6;

        final Pair<Vector3d, Double> colors = blend(level, Biome::getFogColor, distance, new Vector3d(player.getX(), player.getY(), player.getZ()), new BlockPos(player.position()), false, false);

        if (colors.getSecond() == 0)
            return  new Vector3d(oR, oG, oB);

        double r = colors.getFirst().x,
            g = colors.getFirst().y,
            b = colors.getFirst().z,
            weight = colors.getSecond();

        final float base = Mth.clamp(Mth.cos(level.getSunAngle((float) partialTick)) * 2f + 0.5f, 0, 1);
        double rScale = base * 0.94f + 0.06f;
        double gScale = base * 0.94f + 0.06f;
        double bScale = base * 0.91f + 0.09f;

        final float rain = level.getRainLevel((float) partialTick);
        if (rain > 0) {
            rScale *= 1 - rain * 0.5f;
            gScale *= 1 - rain * 0.5f;
            bScale *= 1 - rain * 0.5f;
        }

        final float thunder = level.getThunderLevel((float) partialTick);
        if (thunder > 0) {
            rScale *= 1 - thunder * 0.5f;
            gScale *= 1 - thunder * 0.5f;
            bScale *= 1 - thunder * 0.5f;
        }

        r *= rScale / weight;
        g *= gScale / weight;
        b *= bScale / weight;
        final Vector3d color = postProcessColor(player, r, g, b, partialTick);
        final double weightMixed = distance * distance * 4;
        final double weightDefault = weightMixed - weight;
        return new Vector3d(
            (color.x * weight + oR * weightDefault) / weightMixed,
            (color.y * weight + oG * weightDefault) / weightMixed,
            (color.z * weight + oB * weightDefault) / weightMixed
        );
    }

    private static Vector3d blendWaterFog(final Level level, final Player player, final double partialTick) {
        final Pair<Vector3d, Double> colors = blend(level, Biome::getWaterColor, 2, new Vector3d(player.getX(), player.getY(), player.getZ()), new BlockPos(player.position()), true, false);

        final float respiration = EnchantmentHelper.getRespiration(player) * 0.2f;
        return postProcessColor(player,
            (colors.getFirst().x * 0.02F + respiration) / 16,
            (colors.getFirst().y * 0.02F + respiration) / 16,
            (colors.getFirst().z * 0.02F + respiration) / 16,
            partialTick);
    }

    private static Pair<Vector3d, Double> blend(final Level level, final ToDoubleFunction<Biome> color, final int distance, final Vector3d playerPos, final BlockPos playerBlockPos, final boolean alwaysApply, final boolean useRaw) {
        double r = 0, g = 0, b = 0, weight = 0, xDiff = playerPos.x - playerBlockPos.getX(), zDiff = playerPos.z - playerBlockPos.getZ();
        final BlockPos.MutableBlockPosBlockPos pos = new BlockPos.MutableBlockPosBlockPos(0, 0, 0);

        for (int x = -distance; x <= distance; ++x) {
            for (int z = -distance; z <= distance; ++z) {
                pos.set(playerBlockPos.getX() + x, 0, playerBlockPos.getZ() + z);

                final Biome biome = level.getBiome(playerBlockPos);
                if (alwaysApply || Minecraft.getInstance().getConnection().registryAccess().registry(Registry.BIOME_REGISTRY).map(reg -> reg.getKey(biome).getNamespace().equals(SpookyBiomes.MOD_ID)).orElse(false)) {
                    final double col = color.applyAsDouble(biome);

                    if (alwaysApply || col >= 0) {
                        final Pair<Vector3d, Float> calc = mulDiff(distance, ((int) col & 0xFF0000) >> 16, ((int) col & 0xFF00) >> 8, useRaw ? col : ((int) col & 0xFF), 1, ImmutableBlockPosList.of(
                            Pair.of(x, xDiff),
                            Pair.of(z, zDiff)
                        ));

                        r += calc.getFirst().x;
                        g += calc.getFirst().y;
                        b += calc.getFirst().z;
                        weight += calc.getSecond();
                    }
                }
            }
        }

        r /= 255f;
        g /= 255f;
        b /= 255f;

        return Pair.of(new Vector3d(r, g, b), weight);
    }

    private static Pair<Vector3d, Float> mulDiff(final int distance, final double r, final double g, final double b, final float weight, final List<Pair<Integer, Double>> diffs) {
        return diffs.stream().reduce(Pair.of(new Vector3d(r, g, b), weight),
            (part, diff) -> mulDiff(diff.getFirst(), distance, part.getFirst().x, part.getFirst().y, part.getFirst().z, part.getSecond(), diff.getSecond()),
            (part1, part2) -> part2);
    }

    private static Pair<Vector3d, Float> mulDiff(final int coord, final int distance, final double r, final double g, final double b, final float weight, double diff) {
        if (coord == -distance) {
            diff = 1 - diff;
            return Pair.of(new Vector3d(r * diff, g * diff, b * diff), (float) (weight * diff));
        } else if (coord == distance) {
            return Pair.of(new Vector3d(r * diff, g * diff, b * diff), (float) (weight * diff));
        } else {
            return Pair.of(new Vector3d(r, g, b), weight);
        }
    }*/
}
