package mirafii;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class RollCommand implements CommandExecutor {

    final Random rand;
    final int distance = 20;

    public RollCommand() {
        this.rand = new Random(System.currentTimeMillis());
    }


    // /roll [max]
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if (args.length == 1) {

                final int max = Integer.parseInt(args[0]);

                final int value = rand.nextInt(max + 1);

                for (Player target : Bukkit.getOnlinePlayers()) {

                    if (p.getWorld() == target.getWorld()
                            && p.getLocation().distance(target.getLocation()) <= distance) {
                        target.sendMessage(target.getDisplayName() + ChatColor.YELLOW + " a roll "
                                + ChatColor.WHITE + value
                                + ChatColor.YELLOW + "/"
                                + ChatColor.WHITE + max
                                + ChatColor.YELLOW + ".");
                    }
                }
            } else {
                p.sendMessage(ChatColor.RED + "Utilisation : /roll [Maximum]");
            }
        }
        return true;
    }
}