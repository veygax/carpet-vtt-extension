package dev.veygax.carpetvttextension;

import carpet.api.settings.Rule;
import carpet.settings.Validator;
import carpet.settings.ParsedRule;
import net.minecraft.server.command.ServerCommandSource;

import static carpet.api.settings.RuleCategory.*;

public class VTTSettings {
    public static final String VTTCategory = "VTT";
    
    @Rule(categories = {VTTCategory, SURVIVAL},options = {"1", "16", "64"}, strict = false)
    public static int stackableUnstackablesAmount = 1;
    
    @Rule(categories = {VTTCategory, SURVIVAL})
    public static String stackableUnstackables = "";

    @Rule(categories = {VTTCategory, SURVIVAL})
    public static boolean playerLeash = false;
}
