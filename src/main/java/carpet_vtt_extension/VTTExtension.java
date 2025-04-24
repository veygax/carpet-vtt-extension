package carpet_vtt_extension;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import carpet.api.settings.SettingsManager;
import carpet.utils.Messenger;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

public class VTTExtension implements CarpetExtension
{
    public static void noop() { }
    private static SettingsManager mySettingManager;
    static
    {
        mySettingManager = new SettingsManager("1.0.0", "carpet-vtt-extension", "Carpet VTT Extension");
        CarpetServer.manageExtension(new VTTExtension());
    }

    @Override
    public void onGameStarted()
    {
        // Parse our settings class
        mySettingManager.parseSettingsClass(VTTSettings.class);
    }

    @Override
    public void onServerLoaded(MinecraftServer server)
    {
        // reloading of /carpet settings is handled by carpet
        // reloading of own settings is handled as an extension, since we claim own settings manager
    }

    @Override
    public void onTick(MinecraftServer server)
    {
        // no need to add this.
    }

    @Override
    public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher)
    {
        VTTCommand.register(dispatcher);
    }

    @Override
    public void onPlayerLoggedIn(ServerPlayerEntity player)
    {
        //
    }

    @Override
    public void onPlayerLoggedOut(ServerPlayerEntity player)
    {
        //
    }
}
