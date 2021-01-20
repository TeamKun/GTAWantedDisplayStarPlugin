package net.kunmc.lab.gtawanteddisplaystarplugin.commands;

import net.kunmc.lab.gtawanteddisplaystarplugin.GTAWantedDisplayStarPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SetWanted implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 3) {
            sender.sendMessage(ChatColor.RED + "引数の数がおかしいようです！");
            sender.sendMessage(ChatColor.RED + "使用法：/wanted <now> <max> <点滅>");
            return true;
        }

        try {
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("引数がおかしいようです！");
            return true;
        }

        GTAWantedDisplayStarPlugin.getApi().showStar(player,
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Boolean.parseBoolean(args[2]));
        sender.sendMessage(ChatColor.GREEN + "パケットを送信しました。");

        return true;
    }
}
