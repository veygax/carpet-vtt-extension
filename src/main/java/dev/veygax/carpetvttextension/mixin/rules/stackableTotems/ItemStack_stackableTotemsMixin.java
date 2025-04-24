package dev.veygax.carpetvttextension.mixin.rules.stackableTotems;

import dev.veygax.carpetvttextension.VTTSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStack_stackableTotemsMixin
{
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void getMaxCount(CallbackInfoReturnable<Integer> cir)
    {
        if (VTTSettings.stackableTotems > 1
                && ((ItemStack)(Object)this).getItem() == Items.TOTEM_OF_UNDYING)
        {
            cir.setReturnValue(VTTSettings.stackableTotems);
        }
    }
} 