package io.github.thebusybiscuit.slimefun4.implementation.listeners;
import javax.annotation.Nonnull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.weapons.SeismicAxe;


public class ZeusLightningListener implements Listener {

    private final ZeusLightning zeusLightning;

    public ZeusLightning(@Nonnull Slimefun plugin, @Nonnull ZeusLightning seismicAxe) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.zeusLightning = zeusLightning;
    }

    @EventHandler
    public void onBlockFall(EntityChangeBlockEvent e) {
        if (zeusLightning == null || zeusLightning.isDisabled()) {
            return;
        }

        if (e.getEntity().getType() == EntityType.FALLING_BLOCK && e.getEntity().hasMetadata("zeus_lightning")) {
            e.setCancelled(true);
            e.getEntity().removeMetadata("zeus_lightning", Slimefun.instance());
            e.getEntity().remove();
        }
    }
}
