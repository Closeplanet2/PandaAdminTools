package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

@PandaEvent
public class DealDamage implements Listener {

    @EventHandler
    public void onDamageDelt(EntityDamageByEntityEvent event){
        var playerEntity = event.getDamager();
        if(playerEntity instanceof Player){
            var player = (Player) playerEntity;
            var toggleState = PlayerAPI.GET_TOGGLE_STAT(player, TOGGLE_ACTIONS.PlayerDamageEvent);
            event.setCancelled(!toggleState);
        }
    }

}
