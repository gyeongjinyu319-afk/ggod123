package com.holygrailwar.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import com.holygrailwar.HolyGrailWar;

public class EntityEventListener implements Listener {
    private HolyGrailWar plugin;

    public EntityEventListener(HolyGrailWar plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        player.sendMessage("§c당신은 전쟁에서 패배했습니다!");
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player victim = (Player) event.getEntity();
            Player attacker = (Player) event.getDamager();
            
            // 축복 체크
            if (plugin.getBlessingManager().isBlessed(victim)) {
                event.setDamage(event.getDamage() * 0.5); // 50% 감소
            }
            
            // 저주 체크
            if (plugin.getBlessingManager().isCursed(victim)) {
                event.setDamage(event.getDamage() * 1.5); // 50% 증가
            }
        }
    }
}