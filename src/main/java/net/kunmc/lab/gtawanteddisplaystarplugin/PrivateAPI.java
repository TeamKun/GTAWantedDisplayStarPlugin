package net.kunmc.lab.gtawanteddisplaystarplugin;

import net.kunmc.lab.gtawanteddisplaystarplugin.api.Flag;
import net.kunmc.lab.gtawanteddisplaystarplugin.api.StarDisplayAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class PrivateAPI implements StarDisplayAPI
{
    private GTAWantedDisplayStarPlugin plugin;

    public PrivateAPI(GTAWantedDisplayStarPlugin plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public void showStar(Player player, int now, int max, Flag... flags)
    {
        int flag = Flag.encode(flags);

        try
        {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(baos);
            out.writeByte(0);
            out.writeBytes("" + now + "|" + max + "|" + flag + (Flag.BLINK.check(flag) ? "|" + Flag.BLINK.getValue(): ""));
            out.writeByte(0);
            byte[] bytes = baos.toByteArray();

            player.sendPluginMessage(plugin, "gta:changewanted", bytes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void showStarBroadcast(int now, int max, Flag... flags)
    {
        Bukkit.getOnlinePlayers()
                .forEach(player -> showStar(player, now, max, flags));
    }
}
