package com.closeplanet2.pandaadmintools;

import com.closeplanet2.pandaadmintools.CONFIGS.MongoSettings;
import com.closeplanet2.pandaadmintools.EVENTS.PLayerJoin;
import com.closeplanet2.pandaadmintools.EVENTS.PlayerQuit;
import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.PlayerAccount;
import com.closeplanet2.pandacommandcore.PandaCommandCore;
import com.closeplanet2.pandaconfigcore.API.MongoAPI;
import com.closeplanet2.pandaspigotcore.JAVA_CLASS.JavaClassAPI;
import com.mongodb.client.MongoCollection;
import it.unimi.dsi.fastutil.Hash;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

public class PandaAdminTools extends JavaPlugin {

    public static HashMap<UUID, PlayerAccount> PlayerAccounts = new HashMap<>();
    public static PandaAdminTools INSTANCE;
    public static MongoSettings MONGO_SETTINGS;

    @Override
    public void onEnable() {
        INSTANCE = this;
        MONGO_SETTINGS = ReturnMongoSettings();

        try {
            PandaCommandCore.Register(this, "com.closeplanet2.pandaadmintools");
            JavaClassAPI.Register(this, "com.closeplanet2.pandaadmintools");
        }
        catch (Exception exception) { exception.printStackTrace(); }

        MongoAPI.SET_LOGGER_LEVEL(Level.SEVERE);
        MongoAPI.CREATE_CONNECTION(MONGO_SETTINGS.mongoIP, MONGO_SETTINGS.databaseName);

        for(var player : Bukkit.getOnlinePlayers()) new PLayerJoin().CreatePlayerAccount(player);
    }

    @Override
    public void onDisable() {
        for(var player : Bukkit.getOnlinePlayers()) new PlayerQuit().PlayerLeaveServer(player);
    }

    private MongoSettings ReturnMongoSettings(){
        var mongoSettings = new MongoSettings();
        try { mongoSettings.LOAD(); }
        catch (Exception exception) { exception.printStackTrace(); }
        return mongoSettings;
    }
}
