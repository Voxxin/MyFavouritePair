package com.github.voxxin.my_favourite_pair.mixin;

import com.github.voxxin.my_favourite_pair.item.ModItems;
import com.github.voxxin.my_favourite_pair.util.ModTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.VibrationListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VibrationListener.class)
public class WalkQuitetlyMixin {

    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/event/listener/VibrationListener;listen(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/event/GameEvent$Message;)Z", cancellable = true)
    public void wearingBoots(ServerWorld world, GameEvent.Message event, CallbackInfoReturnable<Boolean> cir) {
        assert event.getEmitter().sourceEntity() != null;
        if (event.getEmitter().sourceEntity() instanceof PlayerEntity player) {
            assert MinecraftClient.getInstance().player != null;
            if (MinecraftClient.getInstance().player.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.LEATHER_WOOL)) {
                if (event.getEvent().getId().equals("step") || event.getEvent().getId().equals("hit_ground")) {
                    cir.setReturnValue(false);
                }
            }
        }

        if (event.getEmitter().sourceEntity() instanceof ItemEntity) {

            Entity entity = event.getEmitter().sourceEntity();

            ItemEntity Item = (ItemEntity) entity;

            if (Item.getStack().isIn(ModTags.DAMPENS_VIBRATIONS)) {
                cir.setReturnValue(false);
            }
        }
    }
}
