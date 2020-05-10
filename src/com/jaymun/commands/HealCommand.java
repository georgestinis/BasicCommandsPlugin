package com.jaymun.commands;

import java.util.Collection;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

import com.jaymun.BasicCommands;


public class HealCommand implements CommandExecutor{
	private Plugin plugin = BasicCommands.getPlugin(BasicCommands.class);
	private boolean p_not_found;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player)sender;
			if (args.length == 0) {
				p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
				p.setFoodLevel(20);
			}
			else if (args[0].equalsIgnoreCase("@a")){
				Collection<? extends Player> players = plugin.getServer().getOnlinePlayers();
				healEveryone(players);
			}
			else {
				Collection<? extends Player> players = plugin.getServer().getOnlinePlayers();
				for (String arg : args) {
					p_not_found = true;					
					for (Player player : players) {
						if (arg.equalsIgnoreCase(player.getName())) {
							healPlayer(player);
							p_not_found = false;
							break;
						}
					}
					if (p_not_found) {
						p.sendMessage("Player " + arg + " not found");
						break;
					}
				}
			}
		}
		return true;
	}
	
	public void healEveryone(Collection<? extends Player> players) {
		for (Player player : players) {
			for (PotionEffect effect : player.getActivePotionEffects())
		        player.removePotionEffect(effect.getType());
			player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
			player.setFoodLevel(20);
		}
	}
	
	public void healPlayer(Player player) {
		for (PotionEffect effect : player.getActivePotionEffects())
	        player.removePotionEffect(effect.getType());
		player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue());
		player.setFoodLevel(20);
	}

}
