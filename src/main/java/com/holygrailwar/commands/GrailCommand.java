package com.holygrailwar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.holygrailwar.HolyGrailWar;

public class GrailCommand implements CommandExecutor {
    private HolyGrailWar plugin;

    public GrailCommand(HolyGrailWar plugin) {
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
            player.sendMessage("§6=== 성배 명령어 ===");
            player.sendMessage("§6/성배 상태 - 성배 상태 확인");
            player.sendMessage("§6/성배 소원 [내용] - 성배에 소원을 빕니다");
            return true;
        }

        if (args[0].equalsIgnoreCase("상태")) {
            player.sendMessage("§6=== 성배 상태 ===");
            player.sendMessage("§6현재 교황: " + plugin.getFactionManager().getCurrentPope());
            player.sendMessage("§6감자교: " + plugin.getFactionManager().getFactionCount("감자교") + "명");
            player.sendMessage("§6고구마교: " + plugin.getFactionManager().getFactionCount("고구마교") + "명");
            return true;
        }

        if (args[0].equalsIgnoreCase("소원")) {
            StringBuilder wish = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                wish.append(args[i]).append(" ");
            }
            player.sendMessage("§6성배에 소원을 빌었습니다: " + wish.toString());
            return true;
        }

        return false;
    }
}