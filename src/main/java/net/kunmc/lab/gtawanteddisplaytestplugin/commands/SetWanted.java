package net.kunmc.lab.gtawanteddisplaytestplugin.commands;

import net.kunmc.lab.gtawanteddisplaytestplugin.GTAWantedDisplayTestPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SetWanted implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 2) {
            sender.sendMessage("引数の数おかしいぞ");
            sender.sendMessage("/wanted <max> <now>");
            return true;
        }

        try {
            Integer.parseInt(args[0]);
            Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("引数バグってんぞ");
            return true;
        }

        try
        {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(baos);
            out.writeByte(0);
            out.writeBytes("" + args[0] + "|" + args[1]);
            out.writeByte(0);
            byte[] bytes = baos.toByteArray();

            player.sendPluginMessage(GTAWantedDisplayTestPlugin.plugin, "gta:changewanted", bytes);
            sender.sendMessage("Packets sent.");
            sender.sendMessage("Packet: " + baos.toString());
            sender.sendMessage("Byte: " + Arrays.toString(baos.toString().getBytes(StandardCharsets.UTF_8)));


        }
        catch (Exception e)
        {
            sender.sendMessage(ChatColor.RED + "A exception has occurred. Please see console.");
            e.printStackTrace();
        }

        return true;
    }
}
