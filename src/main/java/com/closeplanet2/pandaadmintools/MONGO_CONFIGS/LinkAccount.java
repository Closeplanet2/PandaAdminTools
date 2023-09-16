package com.closeplanet2.pandaadmintools.MONGO_CONFIGS;

import com.closeplanet2.pandaadmintools.HELPERS.LinkCodeHelper;
import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaconfigcore.INTERFACE.IgnoreSave;
import com.closeplanet2.pandaconfigcore.INTERFACE.PandaMongo;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LinkAccount implements PandaMongo {
    @Override
    public String DATABASE_NAME() { return PandaAdminTools.MONGO_SETTINGS.databaseName; }

    @Override
    public String DOCUMENT_ID() {
        return _ID;
    }

    @Override
    public Class<?> ReturnClassType() {
        return LinkAccount.class;
    }

    @IgnoreSave
    public String _ID;
    public String linkCode;

    public LinkAccount(){}
    public LinkAccount(Player player){
        _ID = player.getDisplayName();
        linkCode = LinkCodeHelper.GenerateLinkCode(4);
    }
}
