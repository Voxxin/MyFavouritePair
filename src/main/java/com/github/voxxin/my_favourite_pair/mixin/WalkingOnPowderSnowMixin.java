package com.github.voxxin.my_favourite_pair.mixin;

import com.github.voxxin.my_favourite_pair.item.ModItems;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public class WalkingOnPowderSnowMixin {

    @Inject(method = "canWalkOnPowderSnow(Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private static void mixin(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (entity instanceof LivingEntity && ((LivingEntity) entity).getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.LEATHER_RABBIT_HIDE)) {
            ci.setReturnValue(true);
        } else if (entity instanceof LivingEntity && ((LivingEntity) entity).isSprinting() && !(((LivingEntity) entity).isInPose(EntityPose.CROUCHING))) {
            if (((LivingEntity) entity).getEquippedStack(EquipmentSlot.FEET).isOf(Items.LEATHER_BOOTS)) {
                ci.setReturnValue(false);
            }
        }
    }
}

