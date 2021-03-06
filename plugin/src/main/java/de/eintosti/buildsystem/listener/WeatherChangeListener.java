package de.eintosti.buildsystem.listener;

import de.eintosti.buildsystem.BuildSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 * @author einTosti
 */
public class WeatherChangeListener implements Listener {
    private final BuildSystem plugin;

    public WeatherChangeListener(BuildSystem plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWeatherChange(WeatherChangeEvent event) {
        if (!plugin.isLockWeather()) return;
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onThunderChange(ThunderChangeEvent event) {
        if (!plugin.isLockWeather()) return;
        if (event.toThunderState()) {
            event.setCancelled(true);
        }
    }
}
