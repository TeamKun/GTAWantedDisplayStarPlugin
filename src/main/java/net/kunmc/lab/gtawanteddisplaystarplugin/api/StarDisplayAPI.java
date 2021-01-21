package net.kunmc.lab.gtawanteddisplaystarplugin.api;

import org.bukkit.entity.Player;

public interface StarDisplayAPI
{
    /**
     * プレイヤに星を表示させる。
     * @param player 対象プレイヤ。
     * @param now 変更する星の数。
     * @param max 最大星の数。
     * @param flags フラグ。
     */
    void showStar(Player player, int now, int max, Flag... flags);

    /**
     * オンラインのすべてのプレイヤに星を表示させる。
     * @param now 変更する星の数。
     * @param max 最大星の数。
     * @param flags フラグ。
     */
    void showStarBroadcast(int now, int max, Flag... flags);
}
