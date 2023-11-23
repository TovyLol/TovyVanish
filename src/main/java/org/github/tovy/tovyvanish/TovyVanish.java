package org.github.tovy.tovyvanish;

import org.bukkit.plugin.java.JavaPlugin;

public final class TovyVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("vanish").setExecutor(new Vanishcmd());
        System.out.println("TovyVanish has been loaded succesfully!");

    }
}
