package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Date;

@PandaEvent
public class PlayerMessage implements Listener {

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent event){
        var toggleState = PlayerAPI.GET_TOGGLE_STAT(event.getPlayer(), TOGGLE_ACTIONS.BlockBreakEvent);
        if(!toggleState) event.setCancelled(true);
        var playerAccount = PandaAdminTools.PlayerAccounts.get(event.getPlayer().getUniqueId());
        playerAccount.AddPlayerMessage(event.getMessage());
    }

}
