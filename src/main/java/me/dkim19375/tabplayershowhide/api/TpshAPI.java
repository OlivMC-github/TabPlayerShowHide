package me.dkim19375.tabplayershowhide.api;

import me.dkim19375.tabplayershowhide.Status;
import org.bukkit.entity.Player;

import java.util.Set;

public interface TpshAPI {
    Status getStatus(Player player);

    boolean showPlayer(Player player);

    boolean hidePlayer(Player player);

    Set<String> getHiddenPlayers();
}
