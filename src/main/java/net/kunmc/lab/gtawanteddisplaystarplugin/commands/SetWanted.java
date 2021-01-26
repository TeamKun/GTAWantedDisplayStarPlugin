package net.kunmc.lab.gtawanteddisplaystarplugin.commands;

import net.kunmc.lab.gtawanteddisplaystarplugin.GTAWantedDisplayStarPlugin;
import net.kunmc.lab.gtawanteddisplaystarplugin.api.Flag;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWanted implements CommandExecutor

{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "プレイヤーから実行してください！");
            return true;
        }

        if (!sender.hasPermission("star.set"))
        {
            sender.sendMessage(ChatColor.RED + "エラー：権限がありません！");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 3) {
            sender.sendMessage(ChatColor.RED + "引数の数がおかしいようです！");
            sender.sendMessage(ChatColor.RED + "使用法：/setstar <now> <max> <点滅>");
            return true;
        }

        try {
            Integer.parseInt(args[0]);
            Integer.parseInt(args[1]);
            Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage("引数がおかしいようです！");
            sender.sendMessage(ChatColor.RED + "使用法：/setstar <数値> <数値> <数値>");

            return true;
        }

        GTAWantedDisplayStarPlugin.getApi().showStar(player,
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Flag.BLINK.setValue(Integer.parseInt(args[2])
                ));
        sender.sendMessage(ChatColor.GREEN + "パケットを送信しました。");

        return true;
    }
}
