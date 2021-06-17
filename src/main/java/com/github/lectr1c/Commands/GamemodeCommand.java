package com.github.lectr1c.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;

        if (sender instanceof ConsoleCommandSender || player.hasPermission("core.gamemode")) {
            if (args.length > 1 && player.hasPermission("core.gamemode.others")) {
                Player otherPlayer = Bukkit.getPlayer(args[0]);

                otherPlayer.setHealth(20.0);
                otherPlayer.setFoodLevel(20);
                otherPlayer.playSound(otherPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 50.0f, 10.0f);

            } else {

                if (sender instanceof Player) {


                    player.setHealth(20.0);
                    player.setFoodLevel(20);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 10.0f);


                } else {
                    System.out.println("Please execute this command as a player.");
                }

            }
        } else {
            player.sendMessage(ChatColor.RED + "No permission to use heal command.");
        }


        return false;
    }
}