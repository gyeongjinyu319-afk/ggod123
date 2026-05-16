package com.holygrailwar.managers;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public class BlessingManager {
    private JavaPlugin plugin;
    private Map<String, Long> blessedPlayers = new HashMap<>(); // UUID -> 만료시간
    private Map<String, Long> cursedPlayers = new HashMap<>(); // UUID -> 만료시간

    public BlessingManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    // 축복 부여
    public void blessPlayer(Player player) {
        String uuid = player.getUniqueId().toString();
        blessedPlayers.put(uuid, System.currentTimeMillis() + 600000); // 10분
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 1));
        
        player.sendMessage("§a축복을 받았습니다! (10분)");
    }

    // 저주 부여
    public void cursePlayer(Player player) {
        String uuid = player.getUniqueId().toString();
        cursedPlayers.put(uuid, System.currentTimeMillis() + 300000); // 5분
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 300, 2));
        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 300, 2));
        
        player.sendMessage("§c저주를 받았습니다! (5분)");
    }

    // 축복 확인
    public boolean isBlessed(Player player) {
        String uuid = player.getUniqueId().toString();
        if (blessedPlayers.containsKey(uuid)) {
            if (System.currentTimeMillis() < blessedPlayers.get(uuid)) {
                return true;
            } else {
                blessedPlayers.remove(uuid);
            }
        }
        return false;
    }

    // 저주 확인
    public boolean isCursed(Player player) {
        String uuid = player.getUniqueId().toString();
        if (cursedPlayers.containsKey(uuid)) {
            if (System.currentTimeMillis() < cursedPlayers.get(uuid)) {
                return true;
            } else {
                cursedPlayers.remove(uuid);
            }
        }
        return false;
    }
}