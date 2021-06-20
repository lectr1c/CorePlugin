package com.github.lectr1c.Commands;

import com.github.lectr1c.Main;
import com.github.lectr1c.utilities.Feedback;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.Console;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player){
            Player player = (Player) sender;

            if (player.hasPermission("core.moderator")) {
                if (args.length > 0 && player.hasPermission("core.admin")) {


                    try{
                        Player otherPlayer = Bukkit.getPlayerExact(args[0]);
                        assert otherPlayer != null;
                        otherPlayer.setHealth(20.0);
                        otherPlayer.setFoodLevel(20);
                        Feedback.sendSuccessSound(player);
                        Feedback.sendSuccessSound(otherPlayer);
                        Feedback.sendSuccessMsg(player, "Healed player.");
                        Feedback.sendSuccessMsg(otherPlayer, "You have been healed.");
                    } catch (NullPointerException e) {
                        Feedback.playerNotFound(player, args[0]);
                    }

                } else {


                        player.setHealth(20.0);
                        player.setFoodLevel(20);
                        Feedback.sendSuccessSound(player);



                }

            } else {
                Feedback.noPermError(player, "heal");
            }
        } else if (sender instanceof ConsoleCommandSender) {
            if (args.length > 1){
                try{
                    Player otherPlayer = Bukkit.getPlayerExact(args[0]);
                    assert otherPlayer != null;
                    otherPlayer.setHealth(20.0);
                    otherPlayer.setFoodLevel(20);
                    Feedback.sendSuccessSound(otherPlayer);
                    Feedback.sendSuccessMsg(otherPlayer, "You have been healed.");
                } catch (NullPointerException e) {
                    System.out.println("Player not found");
                }
            } else {
                System.out.println("Please specify player to heal.");
            }
        }



        return false;
    }
}
