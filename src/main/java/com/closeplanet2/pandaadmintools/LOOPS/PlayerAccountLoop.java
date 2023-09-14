package com.closeplanet2.pandaadmintools.LOOPS;

import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaspigotcore.LOOPS.LoopValues;
import com.closeplanet2.pandaspigotcore.LOOPS.PandaLoop;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

@PandaLoop
public class PlayerAccountLoop implements LoopValues {
    @Override
    public String ReturnID() { return "PlayerAccountLoop"; }

    @Override
    public int RegisterLoop() {
        return Bukkit.getScheduler().scheduleSyncRepeatingTask(PandaAdminTools.INSTANCE, new Runnable() {
            @Override
            public void run() {
                for(var uuid : PandaAdminTools.PlayerAccounts.keySet()) PandaAdminTools.PlayerAccounts.get(uuid).SaveAccount();
            }
        }, 0L, (long) PandaAdminTools.MONGO_SETTINGS.timeBetweenSaves);
    }
}
