package dev.veygax.carpetvttextension.mixin.rules.stackableUnstackables;

import dev.veygax.carpetvttextension.VTTSettings;
import dev.veygax.carpetvttextension.CarpetVTTExtension;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStack_stackableUnstackablesMixin
{
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void getMaxCount(CallbackInfoReturnable<Integer> cir)
    {
        if (VTTSettings.stackableUnstackablesAmount <= 1 || VTTSettings.stackableUnstackables.isEmpty()) {
            return;
        }

        Item currentItem = ((ItemStack)(Object)this).getItem();
        
        Identifier currentItemId = Registries.ITEM.getId(currentItem);
        String currentItemPath = currentItemId.toString();
        
        // if (Math.random() < 0.01) {
        //     CarpetVTTExtension.LOGGER.info("Current item: " + currentItemPath);
        //     CarpetVTTExtension.LOGGER.info("Configured unstackables: " + VTTSettings.stackableUnstackables);
        // }
        
        String[] itemIds = VTTSettings.stackableUnstackables.split(",");
        
        for (String itemId : itemIds) {
            itemId = itemId.trim();
            if (itemId.isEmpty()) continue;
            
            try {
                if (!itemId.contains(":")) {
                    itemId = "minecraft:" + itemId.toLowerCase();
                }
                
                if (itemId.equals(currentItemPath)) {
                    // if (Math.random() < 0.1) {
                    //     CarpetVTTExtension.LOGGER.info("Making " + itemId + " stackable to " + VTTSettings.stackableUnstackablesAmount);
                    // }
                    cir.setReturnValue(VTTSettings.stackableUnstackablesAmount);
                    return;
                }
            } catch (Exception e) {
                // if (Math.random() < 0.05) {
                //     CarpetVTTExtension.LOGGER.error("Error processing item ID: " + itemId, e);
                // }
            }
        }
    }
} 