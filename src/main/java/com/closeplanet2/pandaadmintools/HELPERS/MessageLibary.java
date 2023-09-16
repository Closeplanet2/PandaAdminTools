package com.closeplanet2.pandaadmintools.HELPERS;

import com.closeplanet2.pandaadmintools.MONGO_CONFIGS.LinkAccount;
import com.closeplanet2.pandaadmintools.PandaAdminTools;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageLibary {
    public static void SendLinkCodeGenTOPlayer(Player player, LinkAccount linkAccount){
        player.sendMessage(ChatColor.BLACK + "====================");

        var message1 = new TextComponent(ChatColor.GREEN + "Link code has been generated!");
        player.spigot().sendMessage(message1);

        var message2 = new TextComponent(ChatColor.AQUA + "[Click For Username]");
        message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("[CLICK TO COPY]")));
        message2.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getDisplayName()));
        player.spigot().sendMessage(message2);

        var message3 = new TextComponent(ChatColor.YELLOW + "[Click For Server Name]");
        message3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("[CLICK TO COPY]")));
        message3.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, PandaAdminTools.MONGO_SETTINGS.databaseName));
        player.spigot().sendMessage(message3);

        var message4 = new TextComponent(ChatColor.LIGHT_PURPLE + "[Click For Message Code]");
        message4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("[CLICK TO COPY]")));
        message4.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, linkAccount.linkCode));
        player.spigot().sendMessage(message4);

        player.sendMessage(ChatColor.BLACK + "====================");
    }
}
