package com.github.lectr1c.Commands;

import com.github.lectr1c.utilities.Feedback;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import com.github.lectr1c.Commands.HealCommand;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        GameMode gm;

        if (sender instanceof Player){
            Player player = (Player) sender;
            gm = player.getGameMode();



            if (args.length > 0) {
                switch (args[0]) {
                    case "0": gm = GameMode.SURVIVAL;
                        break;
                    case "1": gm = GameMode.CREATIVE;
                        break;
                    case "2": gm = GameMode.ADVENTURE;
                        break;
                    case "3": gm = GameMode.SPECTATOR;
                        break;
                    default:
                        break;
                }
            }

            if (player.hasPermission("core.admin")) {

                if (args.length == 0) {
                        Feedback.sendWarning(player,"Please choose gamemode to change to.");
                        return false;
                }


                if ((args.length > 1 && player.hasPermission("core.owner"))) {


                    try{
                        Player otherPlayer = Bukkit.getPlayerExact(args[1]);
                        assert otherPlayer != null;
                        otherPlayer.setGameMode(gm);
                        Feedback.sendSuccessMsg(otherPlayer, "Your gamemode has changed.");
                        Feedback.sendSuccessMsg(player, "Player gamemode changed.");
                        Feedback.sendSuccessSound(player);
                        Feedback.sendSuccessSound(otherPlayer);
                    } catch (NullPointerException e) {
                        Feedback.playerNotFound(player, args[1]);
                    }


                } else {

                    if (args.length == 0) {
                        if(sender instanceof Player){
                            Feedback.sendWarning(player,"Please choose gamemode to change to.");
                            return false;
                        }
                    }



                        player.setGameMode(gm);
                        Feedback.sendSuccessMsg(player, "Your gamemode has changed.");
                        Feedback.sendSuccessSound(player);



                }
            } else {
                Feedback.noPermError(player, "gamemode");
            }
        } else if (sender instanceof  ConsoleCommandSender){
            if (args.length > 1){
                try{
                    Player otherPlayer = Bukkit.getPlayerExact(args[1]);
                    assert otherPlayer != null;

                    gm = otherPlayer.getGameMode();
                    otherPlayer.setGameMode(gm);
                    Feedback.sendSuccessMsg(otherPlayer, "Your gamemode has changed.");
                    Feedback.sendSuccessSound(otherPlayer);
                } catch (NullPointerException e) {
                    System.out.println("Player not found");
                }
            } else {
                System.out.println("Please specify player to change gamemode.");
            }
        }



        return false;
    }
}
