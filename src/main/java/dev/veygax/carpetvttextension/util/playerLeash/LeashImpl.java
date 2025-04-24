package dev.veygax.carpetvttextension.util.playerLeash;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public interface LeashImpl {
    ActionResult leashplayers$interact(PlayerEntity player, Hand hand);
} 