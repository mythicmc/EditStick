package org.sanguineous.editstick;

import org.bukkit.plugin.java.JavaPlugin;
import org.sanguineous.editstick.command.GiveStickCommand;
import org.sanguineous.editstick.listener.PlayerInteractListener;

public class EditStick extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("givestick").setExecutor(new GiveStickCommand());
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {}
}
