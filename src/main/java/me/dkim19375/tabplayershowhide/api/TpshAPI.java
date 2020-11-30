package me.dkim19375.tabplayershowhide.api;

import me.dkim19375.tabplayershowhide.Status;
import org.bukkit.entity.Player;

import java.util.Set;

public interface TpshAPI {

    /**
     * Determine if a given player is visible in the player list.
     * @param player - the player to check.
     * @return Status.SHOWN if it is, Status.HIDDEN otherwise.
     */
    Status getStatus(Player player);

    /**
     * Show a player on the list.
     * @param player - the player to show on the list.
     * @return TRUE if the player was previously hidden, FALSE otherwise.
     */
    boolean showPlayer(Player player);

    /**
     * Hide a player from the list.
     * @param player - the player to hide from the list.
     * @return TRUE if the player was not previously hidden, FALSE otherwise.
     */
    boolean hidePlayer(Player player);

    /**
     * Retrieve every hidden player.
     * @return Every hidden player.
     */
    Set<String> getHiddenPlayers();
}
