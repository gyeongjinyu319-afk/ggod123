package com.holygrailwar.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import com.holygrailwar.HolyGrailWar;

public class PlayerEventListener implements Listener {
    private HolyGrailWar plugin;

    public PlayerEventListener(HolyGrailWar plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§6=== 성배전쟁에 오신 것을 환영합니다! ===");
        event.getPlayer().sendMessage("§a/감자 또는 §d/고구마 §f명령어로 진영에 입교하세요!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // 플레이어 데이터 저장 (필요시)
    }
}