package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

@PandaEvent
public class DropItem implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        var player = event.getPlayer();
        var toggleState = PlayerAPI.GET_TOGGLE_STAT(player, TOGGLE_ACTIONS.BlockDropEvent);
        event.setCancelled(!toggleState);
    }

}
