package com.github.voxxin.my_favourite_pair.mixin;

import com.github.voxxin.my_favourite_pair.util.MFPTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.ItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (LivingEntity.class)
public abstract class DontFreezeMixin {

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot var1);

    @Inject(at = @At("HEAD"), method = "canFreeze", cancellable = true)
    public void dontFreeze(CallbackInfoReturnable<Boolean> cir){
        System.out.println("true");
        if (this.getEquippedStack(EquipmentSlot.FEET).isIn(MFPTags.FREEZE_IMMUNE_WEARABLES)) {
            cir.setReturnValue(false);
        }

    }

}