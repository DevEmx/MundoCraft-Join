package us.devemx.mundocraft.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import us.devemx.mundocraft.CustomJoin;

public class FirstJoin implements Listener {

    private final CustomJoin plugin;

    public FirstJoin(CustomJoin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        FileConfiguration jugadores = YamlConfiguration.loadConfiguration(plugin.getJugadoresFile());
        List<String> listaUUIDs = jugadores.getStringList("uuids");

        if (!listaUUIDs.contains(uuid.toString())) {
            // Es la primera vez que se conecta

            String mensaje = plugin.getConfig().getString(
                    "mensaje-primera-vez",
                    "🐣 §9%player%, ¡esta es tu primera vez aquí! §f¡Bienvenido al mundo!"
            );
            mensaje = ChatColor.translateAlternateColorCodes('&', mensaje.replace("%player%", player.getName()));
            player.getServer().broadcastMessage(mensaje);

            // Guardar UUID
            listaUUIDs.add(uuid.toString());
            jugadores.set("uuids", listaUUIDs);

            try {
                jugadores.save(plugin.getJugadoresFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}