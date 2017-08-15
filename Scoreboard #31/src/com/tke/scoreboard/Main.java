package com.tke.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.tke.scoreboard.api.Money;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Money.register();
		Bukkit.getPluginManager().registerEvents(new Score(), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static Main getPlugin() {
		return getPlugin(Main.class);
	}
	
	
	
}
