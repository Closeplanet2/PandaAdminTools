package com.closeplanet2.pandaadmintools.CONFIGS;

import com.closeplanet2.pandaadmintools.PandaAdminTools;
import com.closeplanet2.pandaconfigcore.INTERFACE.PandaConfig;

public class MongoSettings implements PandaConfig {
    @Override
    public String CONFIG_ID() { return "MongoSettings"; }

    @Override
    public Class<?> CLASS_TYPE() { return null; }

    @Override
    public Class<?> MAIN_CLASS() { return PandaAdminTools.class; }

    public String mongoIP = "mongoIP";
    public String databaseName = "databaseName";
    public double timeBetweenSaves = 2.0;
}
