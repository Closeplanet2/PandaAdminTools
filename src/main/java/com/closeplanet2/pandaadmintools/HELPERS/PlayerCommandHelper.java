package com.closeplanet2.pandaadmintools.HELPERS;

import com.closeplanet2.pandaadmintools.ENUMS.PlayerCommandAction;
import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.PlayerCommand;
import com.closeplanet2.pandaspigotcore.CONSOLE.CHAT.ChatAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerCommandHelper {

    public static void SendToggleCommandMessage(Player commandPlayer, Player targetPlayer, boolean newState, String type){
        var commandPlayerMessage = !newState ?
                ChatColor.RED + type + " Locked For: " + ChatColor.AQUA + targetPlayer.getDisplayName() :
                ChatColor.GREEN + type + " Un-Locked For: " + ChatColor.AQUA + targetPlayer.getDisplayName();
        var targetPlayerMessage = !newState ?
                ChatColor.RED + type + " Locked By: " + ChatColor.AQUA + commandPlayer.getDisplayName() :
                ChatColor.GREEN + type + " Un-Locked By: " + ChatColor.AQUA + commandPlayer.getDisplayName();
        ChatAPI.SEND(commandPlayerMessage, commandPlayer);
        ChatAPI.SEND(targetPlayerMessage, targetPlayer);
    }
}
