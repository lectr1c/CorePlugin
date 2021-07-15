package com.github.lectr1c.Commands;

import com.github.lectr1c.utilities.Config;
import com.github.lectr1c.utilities.Feedback;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    Config pluginConfig;

    public SpawnCommand(Config pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {


        if(commandSender instanceof Player){


            Player player = (Player) commandSender;

            if(player.hasPermission("core.member")){
                player.teleport(pluginConfig.getSpawnLocation());
                Feedback.sendSuccessSound(player);
                Feedback.sendSuccessMsg(player, "Teleported to spawn.");
            } else {
                Feedback.noPermError(player, "spawn");
            }

        } else {
            Feedback.consoleCmdError();
        }

        return false;
    }
}
