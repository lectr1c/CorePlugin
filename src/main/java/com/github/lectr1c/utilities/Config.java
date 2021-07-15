package com.github.lectr1c.utilities;

import com.github.lectr1c.Main;
import org.bukkit.Location;

public class Config {

    private Main main;
    private Location spawnLocation;

    public Config(Main main){
        this.main = main;
        this.main.getConfig().options().copyDefaults();
        this.main.saveDefaultConfig();

        spawnLocation = main.getConfig().getLocation("server.spawn location");
    }



    public Location getSpawnLocation(){
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation){
        main.getConfig().set("server.spawn location", spawnLocation);
        this.spawnLocation = spawnLocation;
    }


}
