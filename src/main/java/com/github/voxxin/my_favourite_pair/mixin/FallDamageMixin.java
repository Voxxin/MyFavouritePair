package com.github.voxxin.my_favourite_pair.mixin;

import com.github.voxxin.my_favourite_pair.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin (PlayerEntity.class)
public abstract class FallDamageMixin {

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow public abstract void increaseStat(Identifier stat, int amount);

    @Inject(at = @At("HEAD"), method = "handleFallDamage", cancellable = true)
    public void fallDamageManager(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (fallDistance <= 6.0f && this.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.LEATHER_WOOL)) {
            this.increaseStat(Stats.FALL_ONE_CM, (int)Math.round((double)fallDistance * 100.0));
            cir.setReturnValue(false);
        }
    }

}
