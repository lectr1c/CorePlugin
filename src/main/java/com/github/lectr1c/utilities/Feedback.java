package com.github.lectr1c.utilities;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Feedback {

    public static void noPermError(Player player, String command){
        player.sendMessage(ChatColor.RED + "No permission to use " + command + " command.");
    }

    public static void consoleCmdError(){
        System.out.println("Please execute this command as a player.");
    }
    public static void playerNotFound(Player player, String otherPlayerName){

        player.sendMessage(ChatColor.RED + "Player " + ChatColor.WHITE + otherPlayerName + ChatColor.RED + " not found");

    }

    public static void sendWarning(Player player, String message){

        player.sendMessage(ChatColor.YELLOW + message);

    }

    public static void sendSuccessMsg(Player player, String message) {
        player.sendMessage(ChatColor.GREEN + message);
    }

    public static void sendSuccessSound(Player player){
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100.0f, 100.0f);
    }




}
