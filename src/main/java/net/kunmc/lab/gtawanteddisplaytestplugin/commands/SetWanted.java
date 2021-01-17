package net.kunmc.lab.gtawanteddisplaytestplugin.commands;

import net.kunmc.lab.gtawanteddisplaytestplugin.GTAWantedDisplayTestPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.nio.charset.StandardCharsets;

public class SetWanted implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 2) {
            return true;
        }

        try {
            Integer.parseInt(args[0]);
            Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("引数バグってんぞ");
            return true;
        }

        byte[] message = ("ChangeWanted " + args[0] + " " + args[1]).getBytes(StandardCharsets.UTF_8);

        player.sendPluginMessage(GTAWantedDisplayTestPlugin.plugin, "GTA", message);

        return true;
    }
}
