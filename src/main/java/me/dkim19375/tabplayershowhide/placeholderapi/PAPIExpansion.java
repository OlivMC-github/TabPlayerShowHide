package me.dkim19375.tabplayershowhide.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.dkim19375.tabplayershowhide.Status;
import me.dkim19375.tabplayershowhide.TabPlayerShowHide;
import me.dkim19375.tabplayershowhide.api.TpshAPI;
import me.dkim19375.utilities.api.UtilitiesAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PAPIExpansion extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return "dkim19375";
    }

    @Override
    public String getIdentifier() {
        return "tabplayershowhide";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        if (identifier.equalsIgnoreCase("hidden_players")) {
            TpshAPI api = TabPlayerShowHide.getAPI();
            return api.getHiddenPlayers().toString();
        }
        if (identifier.toLowerCase().startsWith("status_") && (!identifier.endsWith("_"))) {
            String[] s;
            s = identifier.split("_");
            final Player p = UtilitiesAPI.getPlayerFromAll(s[1]);
            TpshAPI api = TabPlayerShowHide.getAPI();
            if (api.getStatus(p) == Status.SHOWN) {
                return "shown";
            }
            if (api.getStatus(p) == Status.HIDDEN) {
                return "hidden";
            }
        }

        if (identifier.toLowerCase().startsWith("hidden_") && (!identifier.endsWith("_"))) {
            String[] s;
            s = identifier.split("_");
            final Player p = UtilitiesAPI.getPlayerFromAll(s[1]);
            TpshAPI api = TabPlayerShowHide.getAPI();
            if (api.getStatus(p) == Status.SHOWN) {
                return "false";
            }
            if (api.getStatus(p) == Status.HIDDEN) {
                return "true";
            }
        }

        if (identifier.toLowerCase().startsWith("shown_") && (!identifier.endsWith("_"))) {
            String[] s;
            s = identifier.split("_");
            final Player p = UtilitiesAPI.getPlayerFromAll(s[1]);
            TpshAPI api = TabPlayerShowHide.getAPI();
            if (api.getStatus(p) == Status.SHOWN) {
                return "true";
            }
            if (api.getStatus(p) == Status.HIDDEN) {
                return "false";
            }
        }

        return null;
    }
}
