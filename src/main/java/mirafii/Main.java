package mirafii;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("roll").setExecutor(new RollCommand());
        getCommand("nick").setExecutor(new NickCommand());
        getCommand("fly").setExecutor(new FlyCommand());


    }

}
