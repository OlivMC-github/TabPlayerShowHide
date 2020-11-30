package me.dkim19375.tabplayershowhide.commands;

import me.dkim19375.tabplayershowhide.Status;
import me.dkim19375.tabplayershowhide.TabPlayerShowHide;
import me.dkim19375.tabplayershowhide.api.TpshAPI;
import me.dkim19375.utilities.api.UtilitiesAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(label.equalsIgnoreCase("tabplayershowhide") || label.equalsIgnoreCase("tpsh"))) {
            return false;
        }
        if (args.length < 1) {
            showHelp(sender, label);
            return true;
        }
        if (args.length > 2) {
            sender.sendMessage(ChatColor.RED + "Too many arguments!");
            showHelp(sender, label);
            return true;
        }
        switch(args[0]) {
            case "help":
                showHelp(sender, label);
                return true;
            case "status":
                if (args.length == 1) {
                    sender.sendMessage(ChatColor.RED + "Too little arguments!");
                    showHelp(sender, label);
                    return true;
                }
                if (UtilitiesAPI.getPlayerFromAll(args[1]) == null) {
                    sender.sendMessage(ChatColor.RED + "Invalid player!");
                    showHelp(sender, label);
                    return true;
                }
                final Player p = UtilitiesAPI.getPlayerFromAll(args[1]);
                final TpshAPI api = TabPlayerShowHide.getAPI();
                if (api.getStatus(p) == Status.SHOWN) {
                    sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.GOLD + p.getName() + ChatColor.GREEN +
                            " is shown!");
                } else {
                    sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + p.getName() + ChatColor.RED +
                            " is hidden!");
                }
                return true;
            case "hide":
                if (args.length == 1) {
                    sender.sendMessage(ChatColor.RED + "Too little arguments!");
                    showHelp(sender, label);
                    return true;
                }
                if (UtilitiesAPI.getPlayerFromAll(args[1]) == null) {
                    sender.sendMessage(ChatColor.RED + "Invalid player!");
                    showHelp(sender, label);
                    return true;
                }
                final Player pl = UtilitiesAPI.getPlayerFromAll(args[1]);
                final TpshAPI tapi = TabPlayerShowHide.getAPI();
                if (tapi.hidePlayer(pl)) {
                    sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.GOLD + pl.getName() + ChatColor.GREEN +
                            " successfully hidden from the tab list!" + ChatColor.RED + " (Player was already hidden)");
                    return true;
                }
                sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.GOLD + pl.getName() + ChatColor.GREEN +
                        " successfully hidden from the tab list!");
                return true;
            case "show":
                if (args.length == 1) {
                    sender.sendMessage(ChatColor.RED + "Too little arguments!");
                    showHelp(sender, label);
                    return true;
                }
                if (UtilitiesAPI.getPlayerFromAll(args[1]) == null) {
                    sender.sendMessage(ChatColor.RED + "Invalid player!");
                    showHelp(sender, label);
                    return true;
                }
                final Player player = UtilitiesAPI.getPlayerFromAll(args[1]);
                final TpshAPI apit = TabPlayerShowHide.getAPI();
                if (apit.showPlayer(player)) {
                    sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.GOLD + player.getName() + ChatColor.GREEN +
                            " successfully shown on the tab list!" + ChatColor.RED + " (Player was already shown)");
                    return true;
                }
                sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.GOLD + player.getName() + ChatColor.GREEN +
                        " successfully shown on the tab list!");
                return true;
        }
        return false;
    }

    private void showHelp(CommandSender sender, String label) {
        sender.sendMessage(ChatColor.GREEN + "TabPlayerShowHide Commands");
        sender.sendMessage(ChatColor.AQUA + "- /" + label + " help: Help");
        sender.sendMessage(ChatColor.AQUA + "- /" + label + " status <player>: Check if a player is hidden or not");
        sender.sendMessage(ChatColor.AQUA + "- /" + label + " hide <player>: Hide a player from the tab list");
        sender.sendMessage(ChatColor.AQUA + "- /" + label + " show <player>: Show a player on the tab list");
    }
}