package org.polyfrost.overflowanimations.mixin;

import net.minecraft.client.network.NetHandlerPlayClient;
import org.polyfrost.overflowanimations.config.OldAnimationsSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NetHandlerPlayClient.class)
public abstract class NetHandlerPlayClientMixin {

    @ModifyConstant(method = "handleSpawnExperienceOrb", constant = @Constant(doubleValue = 32.0D))
    private double oldXPOrbs(double original) {
        return OldAnimationsSettings.oldXPOrbs && OldAnimationsSettings.INSTANCE.enabled ? 1.0d : original;
    }

    @ModifyConstant(method = "handleCollectItem", constant = @Constant(floatValue = 0.5f))
    private float oldItemPickup(float original) {
        return OldAnimationsSettings.oldPickup && OldAnimationsSettings.INSTANCE.enabled ? 0.9f : original;
    }

}