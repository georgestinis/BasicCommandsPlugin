package com.jaymun;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.jaymun.commands.HealCommand;

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
		instance.getCommand("heal").setExecutor((CommandExecutor)new HealCommand());
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
}
