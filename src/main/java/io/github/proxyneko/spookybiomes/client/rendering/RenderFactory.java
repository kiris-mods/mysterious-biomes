package io.github.proxyneko.spookybiomes.client.rendering;

import io.github.proxyneko.spookybiomes.server.entity.EntityTheForgottenWarlock;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public enum RenderFactory implements IRenderFactory {

    THE_FORGOTTEN_WARLOCK(EntityTheForgottenWarlock.class, RenderTheForgottenWarlock.class);

    private Class<? extends Entity> entityClass;
    private Class<? extends Render<? extends Entity>> renderClass;
    private Object[] renderArgs;

    <T extends Entity> RenderFactory(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    <T extends Entity> RenderFactory(Class<T> entityClass, Class<? extends Render<T>> renderClass) {
        this(entityClass);
        this.renderClass = renderClass;
    }

    <T extends Entity> RenderFactory(Class<T> entityClass, Class<? extends Render<T>> renderClass, Object... renderArgs) {
        this(entityClass, renderClass);
        this.renderArgs = renderArgs;
    }

    @Override
    public Render createRenderFor(RenderManager manager) {
        try {
            Class<?>[] argClasses;
            Object[] args;
            if (renderArgs != null) {
                argClasses = new Class<?>[renderArgs.length + 1];
                argClasses[0] = RenderManager.class;
                args = new Object[renderArgs.length + 1];
                args[0] = manager;
                for (int i = 0; i < renderArgs.length; i++) {
                    Object arg = renderArgs[i];
                    argClasses[i + 1] = arg.getClass();
                    args[i + 1] = arg;
                }
            } else {
                argClasses = new Class<?>[]{RenderManager.class};
                args = new Object[]{manager};
            }
            return renderClass.getConstructor(argClasses).newInstance(args);
        } catch (Exception e) {
            return null;
        }
    }

    public static void registerRenders() {
        for (RenderFactory factory : RenderFactory.values()) {
            RenderingRegistry.registerEntityRenderingHandler(factory.entityClass, factory);
        }
    }
}