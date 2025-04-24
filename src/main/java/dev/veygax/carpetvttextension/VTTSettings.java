package dev.veygax.carpetvttextension;

import carpet.api.settings.Rule;

import static carpet.api.settings.RuleCategory.*;

public class VTTSettings {
    public static final String VTTCategory = "VTT";
    
    @Rule(categories = {VTTCategory, SURVIVAL})
    public static String stackableUnstackables = "";
    // Format: [{"id":"minecraft:totem_of_undying","amount":16},{"id":"minecraft:water_bucket","amount":64}]

    @Rule(categories = {VTTCategory, SURVIVAL})
    public static boolean playerLeash = false;
}
