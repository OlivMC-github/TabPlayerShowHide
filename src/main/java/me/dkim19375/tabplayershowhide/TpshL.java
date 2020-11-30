package me.dkim19375.tabplayershowhide;

import me.dkim19375.tabplayershowhide.api.TpshAPI;
import org.bukkit.entity.Player;

import java.util.Set;

public class TpshL implements TpshAPI {
    ShowHidePlayer showHidePlayer;
    public TpshL(ShowHidePlayer showHidePlayer) {
        this.showHidePlayer = showHidePlayer;
    }

    /**
     * Determine if a given player is visible in the player list.
     * @param player - the player to check.
     * @return Status.SHOWN if it is, Status.HIDDEN otherwise.
     */
    @Override
    public Status getStatus(Player player) {
        if (showHidePlayer.isVisible(player)) {
            return Status.SHOWN;
        }
        return Status.HIDDEN;
    }

    /**
     * Show a player on the list.
     * @param player - the player to show on the list.
     * @return TRUE if the player was previously hidden, FALSE otherwise.
     */
    @Override
    public boolean showPlayer(Player player) {
        return showHidePlayer.showPlayer(player);
    }

    /**
     * Hide a player from the list.
     * @param player - the player to hide from the list.
     * @return TRUE if the player was not previously hidden, FALSE otherwise.
     */
    @Override
    public boolean hidePlayer(Player player) {
        return showHidePlayer.hidePlayer(player);
    }

    /**
     * Retrieve every hidden player.
     * @return Every hidden player.
     */
    @Override
    public Set<String> getHiddenPlayers() {
        return showHidePlayer.getHiddenPlayers();
    }
}
