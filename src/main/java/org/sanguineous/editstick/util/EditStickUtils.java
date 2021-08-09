package org.sanguineous.editstick.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
}
