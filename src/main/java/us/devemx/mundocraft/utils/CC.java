package us.devemx.mundocraft.utils;

import org.bukkit.ChatColor;

public class CC {
    public static String getColoredMessage(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}