package org.mythicmc.editstick;

import org.bukkit.plugin.java.JavaPlugin;
import org.mythicmc.editstick.command.GiveStickCommand;
import org.mythicmc.editstick.listener.PlayerInteractListener;

public class EditStick extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("givestick").setExecutor(new GiveStickCommand());
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {}
}
