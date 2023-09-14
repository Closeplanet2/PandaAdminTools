package com.closeplanet2.pandaadmintools.MONGO_CONFIGS;

import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaconfigcore.INTERFACE.IgnoreSave;
import com.closeplanet2.pandaconfigcore.INTERFACE.PandaMongo;
import org.bukkit.entity.Player;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class PlayerAccount implements PandaMongo {

    @Override
    public String DATABASE_NAME() { return PandaAdminTools.MONGO_SETTINGS.databaseName; }

    @Override
    public String DOCUMENT_ID() { return _ID; }

    @Override
    public Class<?> ReturnClassType() { return PlayerAccount.class; }

    @IgnoreSave
    public String _ID;
    @IgnoreSave
    public boolean editFlag = false;

    public String playerName = "";
    public boolean isActive = false;
    public String lockedBy = "";
    public HashMap<String, String> playerMessages = new HashMap<>();

    public PlayerAccount(){}
    public PlayerAccount(Player player){
        _ID = player.getUniqueId().toString();
        playerName = player.getDisplayName();
        try { LOAD(); }
        catch (Exception exception) { exception.printStackTrace(); }
    }

    public void SetPlayerOnlineState(boolean isActive){
        editFlag = true;
        this.isActive = isActive;
    }

    public void PlayerJoinServer(Player player){
        SetPlayerOnlineState(true);
        PandaAdminTools.PlayerAccounts.put(player.getUniqueId(), this);
    }

    public void PlayerLeaveServer(){
        isActive = false;
        try { SAVE(); }
        catch (Exception exception) { exception.printStackTrace(); }
        PandaAdminTools.PlayerAccounts.remove(UUID.fromString(_ID));
    }

    public void AddPlayerMessage(String message){
        editFlag = true;
        playerMessages.put(new Date().toString(), message);
    }

    public void SaveAccount(){
        if(!editFlag) return;
        try { SAVE(); }
        catch (Exception exception) { exception.printStackTrace(); }
        editFlag = false;
    }

}
