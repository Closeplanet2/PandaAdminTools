package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import com.closeplanet2.pandaspigotcore.PLAYER.PlayerAPI;
import com.closeplanet2.pandaspigotcore.PLAYER.TOGGLE_ACTIONS;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

@PandaEvent
public class BedLeave implements Listener {

    @EventHandler
    public void onBedEnter(PlayerBedLeaveEvent event){
        var player = event.getPlayer();
        var toggleState = PlayerAPI.GET_TOGGLE_STAT(player, TOGGLE_ACTIONS.PlayerBedLeaveEvent);
        event.setCancelled(!toggleState);
    }

}
