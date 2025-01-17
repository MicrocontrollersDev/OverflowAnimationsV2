package org.polyfrost.overflowanimations.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import org.polyfrost.overflowanimations.config.OldAnimationsSettings;
import org.polyfrost.overflowanimations.hooks.TransformTypeHook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RendererLivingEntity.class)
public abstract class RendererLivingEntityMixin<T extends EntityLivingBase> extends Render<T> {

    protected RendererLivingEntityMixin(RenderManager renderManager) {
        super(renderManager);
    }

    @Inject(method = "doRender(Lnet/minecraft/entity/EntityLivingBase;DDDFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V"))
    public void movePlayerModel(T entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (OldAnimationsSettings.smoothModelSneak && OldAnimationsSettings.INSTANCE.enabled && entity instanceof AbstractClientPlayer) {
            boolean player = entity.getName().equals(Minecraft.getMinecraft().thePlayer.getName());
            float eyeHeight = player ? TransformTypeHook.sneakingHeight : entity.getEyeHeight();
            if (entity.isSneaking()) {
                GlStateManager.translate(0.0F, -0.2F, 0.0F);
            }
            GlStateManager.translate(0.0F, 1.62F - eyeHeight, 0.0F);
        }
    }

    @Inject(method = "rotateCorpse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;rotate(FFFF)V", shift = At.Shift.AFTER))
    public void rotateCorpse(T bat, float p_77043_2_, float p_77043_3_, float partialTicks, CallbackInfo ci) {
        boolean player = bat.getName().equals(Minecraft.getMinecraft().thePlayer.getName());
        if (OldAnimationsSettings.dinnerBoneMode && OldAnimationsSettings.INSTANCE.enabled && player) {
            GlStateManager.translate(0.0f, bat.height + 0.1f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        }
    }

}
