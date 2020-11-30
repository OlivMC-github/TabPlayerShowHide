package me.dkim19375.tabplayershowhide;

import me.dkim19375.tabplayershowhide.api.TpshAPI;
import org.bukkit.entity.Player;

import java.util.Set;

public class TpshL implements TpshAPI {
    ShowHidePlayer showHidePlayer;
    public TpshL(ShowHidePlayer showHidePlayer) {
        this.showHidePlayer = showHidePlayer;
    }

    @Override
    public Status getStatus(Player player) {
        if (showHidePlayer.isVisible(player)) {
            return Status.SHOWN;
        }
        return Status.HIDDEN;
    }

    @Override
    public boolean showPlayer(Player player) {
        return showHidePlayer.showPlayer(player);
    }

    @Override
    public boolean hidePlayer(Player player) {
        return showHidePlayer.hidePlayer(player);
    }

    @Override
    public Set<String> getHiddenPlayers() {
        return showHidePlayer.getHiddenPlayers();
    }
}
