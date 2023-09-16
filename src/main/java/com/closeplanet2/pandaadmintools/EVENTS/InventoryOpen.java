package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

@PandaEvent
public class InventoryOpen implements Listener {

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event){
        var playerEntity = event.getPlayer();
        if(playerEntity instanceof Player){
            var player = (Player) playerEntity;
            var toggleState = PlayerAPI.GET_TOGGLE_STAT(player, TOGGLE_ACTIONS.InventoryOpenEvent);
            event.setCancelled(!toggleState);
        }
    }

}
