package org.github.tovy.tovyvanish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vanishcmd implements CommandExecutor {

    private List<UUID> vanished = new ArrayList<>();

    private BossBar bossBar;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (vanished.contains(player.getUniqueId())) { // vanished
                vanished.add(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.hidePlayer(player);

                }
                bossBar = Bukkit.createBossBar(ChatColor.BOLD.WHITE + "Vanished✔️", BarColor.BLUE, BarStyle.SOLID);
                bossBar.addPlayer(player);
                bossBar.setVisible(true);
                player.sendTitle(ChatColor.BOLD.BLUE + "Vanished", ChatColor.BLUE + "You are now vanished!", 20 , 60 , 20);
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH, 1f, 1f);

            } else { // not vanished
                vanished.remove(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(player);

                }
                player.sendTitle(ChatColor.BOLD.BLUE + "UnVanished", ChatColor.BLUE + "You are now unvanished!", 20 , 60 , 20);
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_DEATH, 1f, 1f);
                bossBar.removeAll();




            }
        }
        return false;
    }
}

