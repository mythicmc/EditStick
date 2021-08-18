package org.mythicmc.editstick.util;

import com.plotsquared.core.location.Location;
import com.plotsquared.core.plot.Plot;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Chest;
import org.bukkit.block.data.type.Door;

public class EditStickUtils {
    public static void giveEditStick(Player p) {
        ItemStack item = new ItemStack(Material.DEBUG_STICK);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.displayName(Component.text("Edit Stick"));
        item.setItemMeta(itemMeta);
        p.getInventory().addItem(item);
    }

    public static boolean isEditStick(ItemStack item) {
        return item.getType() == Material.DEBUG_STICK;
    }

    public static boolean canBuild(Player p, Location location) {
        if (location.isUnownedPlotArea()) {
            if (location.isPlotRoad() && (p.hasPermission("plots.admin.build.road")) ||
                    p.hasPermission("plots.admin") ||
                    p.hasPermission("plots.admin.build")) {
                return true;
            } else if (!location.isPlotRoad() && (p.hasPermission("plots.admin.build.unowned") ||
                    p.hasPermission("plots.admin") ||
                    p.hasPermission("plots.admin.build"))) {
                return true;
            }
            return false;
        }
        Plot plot = location.getPlot();
        if (plot != null && (plot.getMembers().contains(p.getUniqueId()) ||
                plot.getTrusted().contains(p.getUniqueId()) ||
                plot.getOwners().contains(p.getUniqueId()) ||
                p.hasPermission("plots.admin.build.other") ||
                p.hasPermission("plots.admin") ||
                p.hasPermission("plots.admin.build"))) {
            return true;
        }
        return false;
    }

    public static boolean isOrientBlacklisted(Block b) {
        if (b.getBlockData() instanceof Bed)
            return true;
        else if (b.getBlockData() instanceof Chest c && c.getType() != Chest.Type.SINGLE)
            return true;

        return false;
    }

    public static boolean isBisectBlacklisted(Block b) {
        if (b.getBlockData() instanceof Door)
            return true;
        return false;
    }
}
