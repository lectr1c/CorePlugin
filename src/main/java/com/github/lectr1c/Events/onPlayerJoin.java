package com.github.lectr1c.Events;

import com.github.lectr1c.utilities.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {

    private Config pluginConfig;

    public onPlayerJoin(Config pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().teleport(pluginConfig.getSpawnLocation());
    }

}
