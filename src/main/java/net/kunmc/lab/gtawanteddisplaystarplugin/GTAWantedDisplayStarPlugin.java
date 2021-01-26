package net.kunmc.lab.gtawanteddisplaystarplugin;

import net.kunmc.lab.gtawanteddisplaystarplugin.api.StarDisplayAPI;
import net.kunmc.lab.gtawanteddisplaystarplugin.commands.SetWanted;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class GTAWantedDisplayStarPlugin extends JavaPlugin {

    private static StarDisplayAPI api;

    /**
     * APIプロバイダを取得
     * @return APIプロバイダ
     */
    public static StarDisplayAPI getApi()
    {
        return api;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("setstar").setExecutor(new SetWanted());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "gta:changewanted");
        api = new PrivateAPI(this);
    }

    @Override
    public void onDisable() {
    }
}
