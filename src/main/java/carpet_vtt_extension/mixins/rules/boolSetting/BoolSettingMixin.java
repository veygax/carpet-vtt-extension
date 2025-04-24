package carpet_vtt_extension.mixins.rules.boolSetting;

import carpet_vtt_extension.VTTSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobEntity.class)
public abstract class BoolSettingMixin extends LivingEntity
{
    protected BoolSettingMixin(EntityType<? extends LivingEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci)
    {
        if (VTTSettings.boolSetting && this.isOnGround())
        {
            // Example implementation for the boolSetting rule
            // Add your functionality here
        }
    }
} 