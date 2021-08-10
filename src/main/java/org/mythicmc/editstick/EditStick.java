package org.mythicmc.editstick;

import org.bukkit.plugin.java.JavaPlugin;
import org.mythicmc.editstick.command.EditStickCommand;
import org.mythicmc.editstick.listener.PlayerInteractListener;

public class EditStick extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("editstick").setExecutor(new EditStickCommand());
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {}
}
