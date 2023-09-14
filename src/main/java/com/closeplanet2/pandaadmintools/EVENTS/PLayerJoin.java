package com.closeplanet2.pandaadmintools.EVENTS;

import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.PlayerAccount;
import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaspigotcore.EVENTS.PandaEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@PandaEvent
public class PLayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        var player = event.getPlayer();
        CreatePlayerAccount(player);
    }

    public void CreatePlayerAccount(Player player){
        var playerAccount = new PlayerAccount(player);
        playerAccount.PlayerJoinServer(player);
    }

}
