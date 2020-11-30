package me.dkim19375.tabplayershowhide;

import me.dkim19375.tabplayershowhide.api.TpshAPI;
import me.dkim19375.tabplayershowhide.commands.CommandClass;
import me.dkim19375.tabplayershowhide.commands.TabCompleterClass;
import org.bukkit.plugin.java.JavaPlugin;

public class TabPlayerShowHide extends JavaPlugin {
    @Override
    public void onEnable() {
        printToConsole("Starting up " + getDescription().getName() + " version " + getDescription().getVersion() + "!");
        this.getCommand("tabplayershowhide").setExecutor(new CommandClass());
        this.getCommand("tabplayershowhide").setTabCompleter(new TabCompleterClass());
        this.getCommand("tpsh").setExecutor(new CommandClass());
        this.getCommand("tpsh").setTabCompleter(new TabCompleterClass());
        printToConsole("Started up " + getDescription().getName() + " version " + getDescription().getVersion() + "!");
    }

    @Override
    public void onDisable() {
        printToConsole("Disabling " + getDescription().getName() + " version " + getDescription().getVersion() + "!");
    }

    public static TpshAPI getAPI() {
        return new TpshL(null);
    }

    public void printToConsole(String msg) {
        this.getServer().getConsoleSender().sendMessage("[" + getDescription().getName() + "] " + msg);
    }
}
