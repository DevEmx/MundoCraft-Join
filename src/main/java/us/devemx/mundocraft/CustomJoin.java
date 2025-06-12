package us.devemx.mundocraft;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import us.devemx.mundocraft.listeners.FirstJoin;
import us.devemx.mundocraft.utils.CC;
import us.devemx.mundocraft.listeners.PlayerJoin;

import java.io.File;
import java.io.IOException;

public final class CustomJoin extends JavaPlugin {

    public static String prefix = "&7[&aMundo&eCraft&7] ";
    private File jugadoresFile;
    private FileConfiguration jugadoresConfig;

    @Override
    public void onEnable() {
        registerEvents();
        saveDefaultConfig();
        jugadoresFile = new File(getDataFolder(), "jugadores.yml");
        if (!jugadoresFile.exists()) {
            try {
                jugadoresFile.createNewFile();
            } catch (IOException e) {
                getLogger().severe("No se pudo crear jugadores.yml");
                e.printStackTrace();
            }
        }
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage("-----------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage(prefix+"&aHas enable"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage(prefix+"Version: &a1.0"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage(prefix+"Author: DevEmx"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage("-----------------------------------"));

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage("-----------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage(prefix+"&aHas disable"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage(prefix+"Version: &a1.0"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage(prefix+"Author: DevEmx"));
        Bukkit.getConsoleSender().sendMessage(CC.getColoredMessage("-----------------------------------"));
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new FirstJoin(this), this);
    }
    public File getJugadoresFile() {
        return jugadoresFile;
    }

}

