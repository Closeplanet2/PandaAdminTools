package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Date;

@PandaEvent
public class PlayerMessage implements Listener {

    @EventHandler
    public void onPlayerMessage(AsyncPlayerChatEvent event){
        var playerAccount = PandaAdminTools.PlayerAccounts.get(event.getPlayer().getUniqueId());
        playerAccount.AddPlayerMessage(event.getMessage());
    }

}
