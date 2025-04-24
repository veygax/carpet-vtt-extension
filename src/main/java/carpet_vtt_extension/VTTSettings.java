package carpet_vtt_extension;

import carpet.api.settings.Rule;
import carpet.api.settings.Validator;
import carpet.utils.Messenger;
import net.minecraft.server.command.ServerCommandSource;

import static carpet.settings.RuleCategory.CREATIVE;

/**
 * Settings class for the carpet-vtt-extension
 */
public class VTTSettings
{
    public enum Option
    {
        OPTION_A, OPTION_B, OPTION_C
    }

    /**
     *  Custom validator class for your setting. If validate returns null - settings is not changed.
     */
    private static class CheckValue extends Validator<Integer>
    {
        @Override
        public Integer validate(ServerCommandSource source, carpet.api.settings.CarpetRule<Integer> currentRule, Integer newValue, String typedString)
        {
            Messenger.m(source, "rb Congrats, you just changed a setting to "+newValue);
            return newValue < 20000000 ? newValue : null;
        }
    }
    

    /**
     * Example bool setting
     */
    @Rule(categories = {"VTT"})
    public static boolean boolSetting;
} 