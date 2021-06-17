package com.github.lectr1c;

import com.github.lectr1c.Commands.GamemodeCommand;
import com.github.lectr1c.Commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("[CorePlugin] Plugin Loaded");
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());

    }

    @Override
    public void onDisable() {

        System.out.println("[CorePlugin] Plugin Unloaded");

    }
}
