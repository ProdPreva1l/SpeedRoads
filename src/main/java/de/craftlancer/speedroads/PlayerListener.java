package de.craftlancer.speedroads;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created on 20/05/2025
 *
 * @author Preva1l
 */
public class PlayerListener implements Listener {
    @EventHandler
    public void on(PlayerJoinEvent event) {
        SpeedRoadsTask.dontTouchMePlease.remove(event.getPlayer().getUniqueId());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(PlayerQuitEvent e) {
        SpeedRoadsTask.dontTouchMePlease.add(e.getPlayer().getUniqueId());

        AttributeInstance attrib = e.getPlayer().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        attrib.removeModifier(SpeedRoadsTask.EMPTY_MODIFIER);
    }
}
