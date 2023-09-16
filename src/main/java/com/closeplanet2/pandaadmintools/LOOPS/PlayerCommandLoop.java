package com.closeplanet2.pandaadmintools.LOOPS;

import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.PlayerCommand;
import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaconfigcore.API.MongoAPI;
import com.closeplanet2.pandaspigotcore.CONSOLE.ConsoleAPI;
import com.closeplanet2.pandaspigotcore.LOOPS.LoopValues;
import com.closeplanet2.pandaspigotcore.LOOPS.PandaLoop;
import org.bukkit.Bukkit;

@PandaLoop
public class PlayerCommandLoop implements LoopValues {
    @Override
    public String ReturnID() { return "PlayerCommandLoop"; }

    @Override
    public int RegisterLoop() {
        return Bukkit.getScheduler().scheduleSyncRepeatingTask(PandaAdminTools.INSTANCE, new Runnable() {
            @Override
            public void run() {
                var databaseName = PandaAdminTools.MONGO_SETTINGS.databaseName;
                var collectionName = PlayerCommand.class.getSimpleName();

                var firstDocument = MongoAPI.RETURN_FIRST_DOCUMENT(databaseName, collectionName);
                if(firstDocument == null) return;

                var playerCommand = new PlayerCommand();
                playerCommand.LOAD_FROM_DOCUMENT(firstDocument);
                playerCommand.RunCommand();
            }
        }, 0L, (long) PandaAdminTools.MONGO_SETTINGS.timeBetweenSaves);
    }
}
