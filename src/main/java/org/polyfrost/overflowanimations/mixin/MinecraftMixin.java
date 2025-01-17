package org.polyfrost.overflowanimations.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.server.S0BPacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.WorldServer;
import org.polyfrost.overflowanimations.config.OldAnimationsSettings;
import org.polyfrost.overflowanimations.hooks.SwingHook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Shadow
    public MovingObjectPosition objectMouseOver;
    @Shadow
    public EffectRenderer effectRenderer;
    @Shadow
    public EntityPlayerSP thePlayer;
    @Shadow
    public WorldClient theWorld;
    @Shadow
    private int leftClickCounter;

    @Shadow public GameSettings gameSettings;

    @Shadow public abstract NetHandlerPlayClient getNetHandler();

    @Inject(method = "sendClickBlockToController", at = @At("HEAD"))
    public void blockHitAnimation(boolean leftClick, CallbackInfo ci) {
        if (OldAnimationsSettings.oldBlockhitting && OldAnimationsSettings.punching && OldAnimationsSettings.INSTANCE.enabled && gameSettings.keyBindUseItem.isKeyDown()) {
            if (leftClickCounter <= 0 && leftClick && objectMouseOver != null && objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK
                    && (thePlayer.isUsingItem() || !OldAnimationsSettings.adventurePunching)) {
                BlockPos posBlock = objectMouseOver.getBlockPos();
                if (!theWorld.isAirBlock(posBlock)) {
                    if ((thePlayer.isAllowEdit() || !OldAnimationsSettings.adventureParticles) && OldAnimationsSettings.punchingParticles) {
                        effectRenderer.addBlockHitEffects(posBlock, objectMouseOver.sideHit);
                    }
                    if ((thePlayer.isAllowEdit() || !OldAnimationsSettings.adventureBlockHit)) {
                        SwingHook.swingItem();
                    }
                }
            }
        }
    }

    @Inject(method = "clickMouse", at = @At(value = "TAIL"))
    public void onHitParticles(CallbackInfo ci) {
        if (OldAnimationsSettings.visualSwing && OldAnimationsSettings.INSTANCE.enabled && leftClickCounter > 0) {
            if (objectMouseOver != null && objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY &&
                    !objectMouseOver.entityHit.hitByEntity(thePlayer) && objectMouseOver.entityHit instanceof EntityLivingBase) {
                if (thePlayer.fallDistance > 0.0F && !thePlayer.onGround && !thePlayer.isOnLadder() &&
                        !thePlayer.isInWater() && !thePlayer.isPotionActive(Potion.blindness) && thePlayer.ridingEntity == null) {
                    thePlayer.onCriticalHit(objectMouseOver.entityHit);
                }
                if (EnchantmentHelper.getModifierForCreature(thePlayer.getHeldItem(),
                        ((EntityLivingBase)objectMouseOver.entityHit).getCreatureAttribute()) > 0.0F) {
                    thePlayer.onEnchantmentCritical(objectMouseOver.entityHit);
                }
            }
            SwingHook.swingItem();
        }
    }

    @Redirect(method = "rightClickMouse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/PlayerControllerMP;getIsHittingBlock()Z"))
    public boolean enabledRightClick(PlayerControllerMP instance) {
        return (!OldAnimationsSettings.oldBlockhitting || !OldAnimationsSettings.INSTANCE.enabled) && instance.getIsHittingBlock();
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;isPressed()Z", ordinal = 7))
    public void fakeBlockHit(CallbackInfo ci) {
        if (OldAnimationsSettings.fakeBlockHit && OldAnimationsSettings.INSTANCE.enabled) {
            while (gameSettings.keyBindAttack.isPressed()) {
                SwingHook.swingItem();
            }
        }
    }

}