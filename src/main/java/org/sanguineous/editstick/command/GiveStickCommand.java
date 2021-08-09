package org.sanguineous.editstick.command;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.sanguineous.editstick.util.EditStickUtils;

public class GiveStickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            EditStickUtils.giveEditStick(p);
        } else {
            sender.sendMessage(Component.text("Only players may run this command"));
        }
        return true;
    }
}
