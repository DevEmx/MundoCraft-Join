package us.devemx.mundocraft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import us.devemx.mundocraft.CustomJoin;
import us.devemx.mundocraft.utils.CC;

public class PlayerJoin implements Listener {

    private final CustomJoin plugin;
    public PlayerJoin(CustomJoin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String msg = plugin.getConfig().getString("join-message");
        msg = msg.replace("{player}", player.getName());
        event.setJoinMessage(CC.getColoredMessage(msg));
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String msg = plugin.getConfig().getString("quit-message");
        msg = msg.replace("{player}", player.getName());
        event.setQuitMessage(CC.getColoredMessage(msg));
    }
}
