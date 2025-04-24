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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Mixin(ItemStack.class)
public class ItemStack_stackableUnstackablesMixin
{
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void getMaxCount(CallbackInfoReturnable<Integer> cir)
    {
        if (VTTSettings.stackableUnstackables.isEmpty()) {
            return;
        }

        Item currentItem = ((ItemStack)(Object)this).getItem();
        Identifier currentItemId = Registries.ITEM.getId(currentItem);
        String currentItemPath = currentItemId.toString();
        
        try {
            JsonArray items = JsonParser.parseString(VTTSettings.stackableUnstackables).getAsJsonArray();
            for (JsonElement element : items) {
                JsonObject item = element.getAsJsonObject();
                if (item.has("id") && item.has("amount")) {
                    String itemId = item.get("id").getAsString();
                    if (!itemId.contains(":")) {
                        itemId = "minecraft:" + itemId.toLowerCase();
                    }
                    
                    if (itemId.equals(currentItemPath)) {
                        int amount = item.get("amount").getAsInt();
                        if (amount > 1) {
                            cir.setReturnValue(amount);
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            CarpetVTTExtension.LOGGER.error("Error parsing JSON for stackable unstackables: " + VTTSettings.stackableUnstackables, e);
        }
    }
} 