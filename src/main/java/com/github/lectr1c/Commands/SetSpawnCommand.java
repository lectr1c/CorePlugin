package com.github.lectr1c.Commands;

import com.github.lectr1c.utilities.Config;
import com.github.lectr1c.utilities.Feedback;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    Config pluginConfig;

    public SetSpawnCommand(Config pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {


        if (commandSender instanceof Player){

            Player player = (Player) commandSender;

            if (player.hasPermission("core.owner")){
                Location playerLocation = player.getLocation();
                pluginConfig.setSpawnLocation(playerLocation);
            }

        } else {
            System.out.println(pluginConfig.getSpawnLocation());
        }


        return false;
    }
}
