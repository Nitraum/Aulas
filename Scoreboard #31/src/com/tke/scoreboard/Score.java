package com.tke.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.tke.scoreboard.api.LineAdder;
import com.tke.scoreboard.api.Money;

public class Score implements Listener {

	public Score() {
		
		new BukkitRunnable() {
			@Override
			public void run() {
				for (Player players : Bukkit.getOnlinePlayers()) {
					update(players);
				}
			}
		}.runTaskTimerAsynchronously(Main.getPlugin(), 0L, 20L);
		
	}
	
	public void build(Player p) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = sb.registerNewObjective("score", "dummy");
		
		obj.setDisplayName("§6§lVídeo");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		LineAdder line = new LineAdder(sb, obj);
		
		line.addLine("§aSejam Bem-Vind", "§aos Jogadores", "", 15);
		line.addLine("", "§0", "", 14);
		line.addLine(" ", "§aMoney: §f", "§aCarregando...", 13);
		line.addLine("", "§1", "", 12);
		line.addLine(" ", "§cMortes: §f", "§aCarregando...", 11);
		line.addLine("", "§2", "", 10);
		
		p.setScoreboard(sb);
	}
	
	public void update(Player p) {
		
		Scoreboard sb = p.getScoreboard();
		if (sb.getObjective("score") != null) {
			Team money = sb.getTeam("line13");
			money.setSuffix(Money.get(p) + "");
			
			Team mortes = sb.getTeam("line11");
			mortes.setSuffix(p.getStatistic(Statistic.DEATHS) + "");
		}
	}
	
	@EventHandler
	void evento(PlayerJoinEvent e) {
		build(e.getPlayer());
	}
	
	
}
