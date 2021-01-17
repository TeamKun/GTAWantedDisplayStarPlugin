package net.kunmc.lab.gtawanteddisplaytestplugin.commands;

import net.kunmc.lab.gtawanteddisplaytestplugin.GTAWantedDisplayTestPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

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

        try
        {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(baos);
            out.writeByte(0);
            out.writeBytes("" + args[0] + "|" + args[1]);
            out.writeByte(0);
            byte[] bytes = baos.toByteArray();

            player.sendPluginMessage(GTAWantedDisplayTestPlugin.plugin, "gta:changewanted", bytes);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }
}
