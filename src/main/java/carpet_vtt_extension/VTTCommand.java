package carpet_vtt_extension;

import carpet.utils.Messenger;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.literal;

public class VTTCommand
{
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        dispatcher.register(literal("testcommand").
                then(literal("first").
                        executes( (c)-> {
                            Messenger.m(c.getSource(), "gi Shhhh.....");
                            return 1;
                        })).
                then(literal("second").
                        executes( (c)-> listSettings(c.getSource()))));

    }

    private static int listSettings(ServerCommandSource source)
    {
        Messenger.m(source, "w Here is all the settings we manage:");
        Messenger.m(source, "w Settings:");
        Messenger.m(source, "w  - boolean: "+VTTSettings.boolSetting);
        return 1;
    }
} 