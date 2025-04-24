package dev.veygax.carpetvttextension;

import carpet.settings.Rule;
import carpet.settings.Validator;
import carpet.settings.ParsedRule;
import net.minecraft.server.command.ServerCommandSource;

public class VTTSettings {
    @Rule(desc="Sets the maximum stack size for Totems of Undying (1 is default)", category = {"item", "stackable", "VTT"}, options = {"1", "16", "64"}, strict = false)
    public static int stackableTotems = 1;
}
