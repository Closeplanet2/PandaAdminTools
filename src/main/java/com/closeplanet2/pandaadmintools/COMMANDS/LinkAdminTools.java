package com.closeplanet2.pandaadmintools.COMMANDS;

import com.closeplanet2.pandaadmintools.HELPERS.LinkCodeHelper;
import com.closeplanet2.pandaadmintools.HELPERS.MessageLibary;
import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.LinkAccount;
import com.closeplanet2.pandacommandcore.ENUMS.PlayerCommandError;
import com.closeplanet2.pandacommandcore.INTERFACE.PCCommand;
import com.closeplanet2.pandacommandcore.INTERFACE.PCMethod;
import com.closeplanet2.pandacommandcore.INTERFACE.PCPerm;
import com.closeplanet2.pandacommandcore.PlayerCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

@PCCommand
public class LinkAdminTools extends PlayerCommand {
    public LinkAdminTools() { super("LinkAdminTools", true); }

    @Override
    public void InvokeVoid(Method method, Object[] objects) throws InvocationTargetException, IllegalAccessException { method.invoke(this, objects); }

    @Override
    public boolean CommandError(PlayerCommandError playerCommandError, Player player, String s) {
        if(playerCommandError == PlayerCommandError.PLAYER_COMMANDS_LOCKED) player.sendMessage(playerCommandError.error);
        return false;
    }

    @PCMethod
    @PCPerm("AdminTools.AdminAccount")
    public void LinkAdminTools(UUID playerUUID){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;

        var linkAccount = new LinkAccount(player);
        try { linkAccount.SAVE(); }
        catch (Exception exception) { exception.printStackTrace(); }

        MessageLibary.SendLinkCodeGenTOPlayer(player, linkAccount);
    }
}
