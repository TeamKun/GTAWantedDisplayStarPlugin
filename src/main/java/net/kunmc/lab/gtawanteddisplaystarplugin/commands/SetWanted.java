package net.kunmc.lab.gtawanteddisplaystarplugin.commands;

import net.kunmc.lab.gtawanteddisplaystarplugin.GTAWantedDisplayStarPlugin;
import net.kunmc.lab.gtawanteddisplaystarplugin.api.Flag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWanted implements CommandExecutor

{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!sender.hasPermission("star.set"))
        {
            sender.sendMessage(ChatColor.RED + "エラー：権限がありません！");
            return true;
        }

        if (args.length != 4) {
            sender.sendMessage(ChatColor.RED + "引数の数がおかしいようです！");
            sender.sendMessage(ChatColor.RED + "使用法：/setstar <プレイヤー> <now> <max> <点滅>");
            return true;
        }

        if (Bukkit.getPlayer(args[0]) == null)
        {
            sender.sendMessage(ChatColor.RED + "存在するプレイヤーを指定してください！");
            return true;
        }
        try {
            Integer.parseInt(args[1]);
            Integer.parseInt(args[2]);
            Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "引数がおかしいようです！");
            sender.sendMessage(ChatColor.RED + "使用法：/setstar <プレイヤー> <数値> <数値> <数値>");

            return true;
        }

        GTAWantedDisplayStarPlugin.getApi().showStar(Bukkit.getPlayer(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Flag.BLINK.setValue(Integer.parseInt(args[3])
                ));
        sender.sendMessage(ChatColor.GREEN + "パケットを送信しました。");

        return true;
    }
}
