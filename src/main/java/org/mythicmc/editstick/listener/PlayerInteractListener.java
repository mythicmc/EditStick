package org.mythicmc.editstick.listener;

import com.plotsquared.core.location.Location;
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
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            if (p.isOp())
                return;
            if (EditStickUtils.isEditStick(p.getInventory().getItemInMainHand())) {
                Block block = e.getClickedBlock();
                if (Bukkit.getPluginManager().getPlugin("PlotSquared") != null &&
                        p.hasPermission("editstick.use") && !EditStickUtils.isBlacklisted(block)) {
                    Location location = Location.at(p.getWorld().getName(), block.getX(),
                            block.getY(), block.getZ());
                    if (EditStickUtils.canBuild(p, location)) {
                        if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
                            BlockUtils.rotateBlock(block);
                        else
                            BlockUtils.changeHalf(block);
                        e.setCancelled(true);
                    }
                } else if (p.hasPermission("editstick.use") && !EditStickUtils.isBlacklisted(block)) {
                    if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
                        BlockUtils.rotateBlock(block);
                    else
                        BlockUtils.changeHalf(block);
                    e.setCancelled(true);
                }
            }
        }
    }
}
