package com.github.lectr1c;

import com.github.lectr1c.Commands.GamemodeCommand;
import com.github.lectr1c.Commands.HealCommand;
import com.github.lectr1c.Commands.SetSpawnCommand;
import com.github.lectr1c.Commands.SpawnCommand;
import com.github.lectr1c.Events.onPlayerJoin;
import com.github.lectr1c.utilities.Config;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Config pluginConfig = new Config(this);
        System.out.println("[CorePlugin] Plugin Loaded");
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(pluginConfig));
        getCommand("spawn").setExecutor(new SpawnCommand(pluginConfig));

        Bukkit.getPluginManager().registerEvents(new onPlayerJoin(pluginConfig), this);


    }


    @Override
    public void onDisable() {

        System.out.println("[CorePlugin] Plugin Unloaded");
        saveConfig();
    }
}
