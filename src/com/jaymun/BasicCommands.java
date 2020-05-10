package com.jaymun;

import org.bukkit.plugin.java.JavaPlugin;

public class BasicCommands extends JavaPlugin{
	private static BasicCommands instance;

	public static BasicCommands getInstance() {
		return instance;
	}

	public static void setInstance(BasicCommands instance) {
		BasicCommands.instance = instance;
	}

	@Override
	public void onEnable() {
		instance = this;
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
}
