package net.kunmc.lab.gtawanteddisplaytestplugin;

import net.kunmc.lab.gtawanteddisplaytestplugin.commands.SetWanted;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public final class GTAWantedDisplayTestPlugin extends JavaPlugin implements PluginMessageListener {

    public static GTAWantedDisplayTestPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.getPluginCommand("wanted").setExecutor(new SetWanted());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "gta:changewanted");
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "gta:changewanted", this);
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
    }
}
