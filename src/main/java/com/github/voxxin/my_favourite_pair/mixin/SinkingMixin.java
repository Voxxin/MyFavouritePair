package com.github.voxxin.my_favourite_pair.mixin;

import com.github.voxxin.my_favourite_pair.item.MFPItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class SinkingMixin {

    @Shadow protected boolean isSubmergedInWater;


    @Inject(at = @At("TAIL"), method = "tickMovement")
    public void Sinking(CallbackInfo ci) {
        assert MinecraftClient.getInstance().player != null;
        ClientPlayerEntity player = MinecraftClient.getInstance().player;

        if (player != null) {

            if (isSubmergedInWater && player.getPose() == EntityPose.CROUCHING) {
                if (!player.isOnGround() && player.getEquippedStack(EquipmentSlot.FEET).isOf(MFPItems.LEATHER_COPPER) && player.getVelocity().y >= -0.2) {
                    player.setVelocity(player.getVelocity().x, (player.getVelocity().y - .15), player.getVelocity().z);

                }

            } else if (!player.isOnGround() && player.getPose() == EntityPose.CROUCHING && player.getEquippedStack(EquipmentSlot.FEET).isOf(MFPItems.LEATHER_COPPER) && player.getVelocity().y >= -0.2) {
                player.setVelocity(player.getVelocity().x, (player.getVelocity().y - .15), player.getVelocity().z);
            }
        }
    }
}
