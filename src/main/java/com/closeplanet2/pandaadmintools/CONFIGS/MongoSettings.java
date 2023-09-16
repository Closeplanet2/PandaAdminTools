package com.closeplanet2.pandaadmintools.CONFIGS;

import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaconfigcore.INTERFACE.IgnoreSave;
import com.closeplanet2.pandaconfigcore.INTERFACE.PandaConfig;

public class MongoSettings implements PandaConfig {
    @Override
    public String CONFIG_ID() { return "MongoSettings"; }

    @Override
    public Class<?> CLASS_TYPE() { return null; }

    @Override
    public Class<?> MAIN_CLASS() { return PandaAdminTools.class; }

    @IgnoreSave
    public String mongoIP = "mongodb+srv://dbLEvVXpJswSaxdUxSdP:3gWLuRzfzuUp072zy0h7@pandaadmintools.neqhjze.mongodb.net/?retryWrites=true&w=majority";
    @IgnoreSave
    public String databaseName = "TestServer";
    public double timeBetweenSaves = 2.0;
}
