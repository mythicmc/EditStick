package org.mythicmc.editstick.listener;

import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mythicmc.editstick.util.BlockUtils;
import org.mythicmc.editstick.util.EditStickUtils;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            if (p.isOp())
                return;
            if (EditStickUtils.isEditStick(p.getInventory().getItemInMainHand())) {
                Block block = e.getClickedBlock();
                if (Bukkit.getPluginManager().getPlugin("PlotSquared") != null &&
                        p.hasPermission("editstick.use")) {
                    Location location = new Location(p.getWorld().getName(), block.getX(),
                            block.getY(), block.getZ());
                    if (location.isUnownedPlotArea()) {
                        if (location.isPlotRoad() && (p.hasPermission("plots.admin.build.road")) ||
                                p.hasPermission("plots.admin") ||
                                p.hasPermission("plots.admin.build")) {
                            BlockUtils.rotateBlock(block);
                            e.setCancelled(true);
                        } else if (!location.isPlotRoad() && (p.hasPermission("plots.admin.build.unowned") ||
                                p.hasPermission("plots.admin") ||
                                p.hasPermission("plots.admin.build"))) {
                            BlockUtils.rotateBlock(block);
                            e.setCancelled(true);
                        }
                        return;
                    }
                    Plot plot = location.getPlot();
                    if (plot != null && (plot.getMembers().contains(p.getUniqueId()) ||
                            plot.getTrusted().contains(p.getUniqueId()) ||
                            plot.getOwners().contains(p.getUniqueId()) ||
                            p.hasPermission("plots.admin.build.other") ||
                            p.hasPermission("plots.admin") ||
                            p.hasPermission("plots.admin.build"))) {
                        BlockUtils.rotateBlock(block);
                        e.setCancelled(true);
                    }
                } else if (p.hasPermission("editstick.use")) {
                    BlockUtils.rotateBlock(block);
                    e.setCancelled(true);
                }
            }
        }
    }
}
