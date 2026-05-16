package com.holygrailwar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.holygrailwar.HolyGrailWar;

public class SweetPotatoCommand implements CommandExecutor {
    private HolyGrailWar plugin;

    public SweetPotatoCommand(HolyGrailWar plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§c플레이어만 사용할 수 있습니다!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§d=== 고구마교 명령어 ===");
            player.sendMessage("§d/고구마 입교 - 고구마교에 입교합니다");
            player.sendMessage("§d/고구마 상태 - 고구마교 상태 확인");
            player.sendMessage("§d/고구마 헌금 [금액] - 헌금합니다");
            return true;
        }

        if (args[0].equalsIgnoreCase("입교")) {
            plugin.getFactionManager().joinFaction(player, "고구마교");
            return true;
        }

        if (args[0].equalsIgnoreCase("상태")) {
            player.sendMessage("§d당신의 진영: " + plugin.getFactionManager().getFaction(player));
            player.sendMessage("§d고구마토큰: " + plugin.getCurrencyManager().getSweetPotatoTokens(player));
            return true;
        }

        if (args[0].equalsIgnoreCase("헌금") && args.length > 1) {
            try {
                double amount = Double.parseDouble(args[1]);
                plugin.getFactionManager().donate(player, amount);
            } catch (NumberFormatException e) {
                player.sendMessage("§c올바른 숫자를 입력하세요!");
            }
            return true;
        }

        return false;
    }
}