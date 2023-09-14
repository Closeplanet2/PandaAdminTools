package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.PlayerAccount;
import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

@PandaEvent
public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
       PlayerLeaveServer(event.getPlayer());
    }

    public void PlayerLeaveServer(Player player){
        var playerAccount = PandaAdminTools.PlayerAccounts.get(player.getUniqueId());
        playerAccount.PlayerLeaveServer();
    }

}
