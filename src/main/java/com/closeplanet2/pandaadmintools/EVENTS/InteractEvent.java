package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

@PandaEvent
public class InteractEvent implements Listener {

    @EventHandler
    public void interactEntity(PlayerInteractEntityEvent event){
        var player = event.getPlayer();
        var toggleState = PlayerAPI.GET_TOGGLE_STAT(player, TOGGLE_ACTIONS.PlayerInteractEvent);
        event.setCancelled(!toggleState);
    }

    @EventHandler
    public void interactEntity(PlayerInteractEvent event){
        var player = event.getPlayer();
        var toggleState = PlayerAPI.GET_TOGGLE_STAT(player, TOGGLE_ACTIONS.PlayerInteractEvent);
        event.setCancelled(!toggleState);
    }

}
