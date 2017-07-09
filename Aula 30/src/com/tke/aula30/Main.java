package com.tke.aula30;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.tke.aula30.JSON.JSONChatClickEventType;
import com.tke.aula30.JSON.JSONChatColor;
import com.tke.aula30.JSON.JSONChatExtra;
import com.tke.aula30.JSON.JSONChatFormat;
import com.tke.aula30.JSON.JSONChatHoverEventType;
import com.tke.aula30.JSON.JSONChatMessage;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
	}
	
	public static Main getPlugin(){
		return getPlugin(Main.class);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (cmd.getName().equalsIgnoreCase("item")){
			Player p = (Player)sender;
			ItemStack espada = Criar.add(Material.DIAMOND_SWORD, "§e§lESPADA DE ZEUS", Enchantment.DAMAGE_ALL, 20);
			p.getInventory().addItem(espada);
			p.sendMessage("§6Parabéns você pegou a espada de §e§lZEUS");
		}
		if (cmd.getName().equalsIgnoreCase("teste")){
			Player p = (Player)sender;
			JSONChatMessage texto = new JSONChatMessage("   ", null, null);
			JSONChatExtra site = new JSONChatExtra("§b[SITE] ");
			site.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, "§7Clique aqui para entrar no site de compra de plugins");
			site.setClickEvent(JSONChatClickEventType.OPEN_URL, "www.thgplugins.com");
			texto.addExtra(site);
			
			JSONChatExtra item = new JSONChatExtra("§e[ITEM] ");
			item.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, "§eClique aqui para ganhar uma espada");
			item.setClickEvent(JSONChatClickEventType.RUN_COMMAND, "/item");
			texto.addExtra(item);
			
			JSONChatExtra hello = new JSONChatExtra("§d[HELLO WORLD]");
			hello.setHoverEvent(JSONChatHoverEventType.SHOW_TEXT, "§aClique aqui para pegar uma sugestão de comando admin.");
			hello.setClickEvent(JSONChatClickEventType.SUGGEST_COMMAND, "/say Parabéns pelo servidor");
			texto.addExtra(hello);
			
			texto.sendToPlayer(p);
//			   [SITE] [ITEM] [HELLO WORLD]
		}
		
		
		return false;
	}
	
}
