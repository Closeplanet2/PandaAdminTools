package com.closeplanet2.pandaadmintools.MONGO_CONFIGS;

import com.closeplanet2.pandaadmintools.ENUMS.PlayerCommandAction;
import com.closeplanet2.pandaadmintools.HELPERS.PlayerCommandHelper;
import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaconfigcore.INTERFACE.IgnoreSave;
import com.closeplanet2.pandaconfigcore.INTERFACE.PandaMongo;
import com.closeplanet2.pandaspigotcore.CONSOLE.CHAT.ChatAPI;
import com.closeplanet2.pandaspigotcore.CONSOLE.ConsoleAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.MOVEMENT.MovementAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerCommand implements PandaMongo {
    @Override
    public String DATABASE_NAME() { return PandaAdminTools.MONGO_SETTINGS.databaseName; }

    @Override
    public String DOCUMENT_ID() {
        return MongoID;
    }

    @Override
    public Class<?> ReturnClassType() { return PlayerCommand.class; }

    public String MongoID = "";
    public String playerCommand = "";

    public void RunCommand(){
        var args = playerCommand.split(" ");
        var commandPlayer = Bukkit.getPlayer(MongoID);
        if(commandPlayer != null){
            var playerCommandAction = PlayerCommandAction.valueOf(args[0]);
            if(playerCommandAction.runAsToggleAction) ToggleAction(playerCommandAction, commandPlayer, args);
            else NonToggleAction(playerCommandAction, commandPlayer, args);
        }
    }

    private void ToggleAction(PlayerCommandAction playerCommandAction, Player commandPlayer, String[] args){
        var targetPlayer = Bukkit.getPlayer(args[1]);
        if(targetPlayer == null) return;
        var newState = !PlayerAPI.GET_TOGGLE_STAT(targetPlayer, playerCommandAction.toggle_actions);
        PlayerAPI.TOGGLE_STAT(targetPlayer, playerCommandAction.toggle_actions, newState);
        PlayerCommandHelper.SendToggleCommandMessage(commandPlayer, targetPlayer, newState, playerCommandAction.key);
        DELETE_DOCUMENT();
    }

    private void NonToggleAction(PlayerCommandAction playerCommandAction, Player commandPlayer, String[] args){
        var targetPlayer = Bukkit.getPlayer(args[1]);
        if(targetPlayer == null) return;

        if(playerCommandAction == PlayerCommandAction.TOGGLE_MOVE){
            if(PlayerAPI.GET_TOGGLE_STAT(targetPlayer, TOGGLE_ACTIONS.PlayerMoveEvent)) MovementAPI.LOCK_PLAYER_LOCATION(targetPlayer);
            else MovementAPI.UN_FREEZE_PLAYER_LOCATION(targetPlayer);
            PlayerCommandHelper.SendToggleCommandMessage(commandPlayer, targetPlayer, PlayerAPI.GET_TOGGLE_STAT(targetPlayer, TOGGLE_ACTIONS.PlayerMoveEvent), playerCommandAction.key);
        }
        else if(playerCommandAction == PlayerCommandAction.TELEPORT_TO_PLAYER) commandPlayer.teleport(targetPlayer);
        else if(playerCommandAction == PlayerCommandAction.SPECTATE_PLAYER) targetPlayer.addPassenger(commandPlayer);
        else if(playerCommandAction == PlayerCommandAction.VIEW_INVENTORY) commandPlayer.openInventory(targetPlayer.getInventory());
        else if(playerCommandAction == PlayerCommandAction.KICK_PLAYER) targetPlayer.kickPlayer("Kicked By: " + commandPlayer.getDisplayName());

        DELETE_DOCUMENT();
    }

}
