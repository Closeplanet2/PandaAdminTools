package com.closeplanet2.pandaadmintools.HELPERS;

import java.util.Random;

public class LinkCodeHelper {

    private static final String DATA = "abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ1234567890";

    public static String GenerateLinkCode(int size){
        var linkCode = new StringBuilder("");
        for(var i = 0; i < size; i++) linkCode.append(DATA.charAt(new Random().nextInt(DATA.length())));
        linkCode.append("-");
        for(var i = 0; i < size; i++) linkCode.append(DATA.charAt(new Random().nextInt(DATA.length())));
        return linkCode.toString();
    }
}
