package chmodsayshello.extremeultrahardcore;


import chmodsayshello.extremeultrahardcore.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExtremeUltraHardcore extends JavaPlugin{

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Mob(), this);
        getServer().getPluginManager().registerEvents(new Player(), this);
        getServer().getPluginManager().registerEvents(new Block(), this);

        getLogger().info("Started challange");
        // Plugin startup logic

    }


    public void onDisable() {
        getLogger().info("The challange is now turned off");
        // Plugin shutdown logic
    }
}
