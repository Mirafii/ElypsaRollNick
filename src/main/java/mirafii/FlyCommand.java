package mirafii;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    // /roll [max]
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if (p.isFlying()) {

                if (!p.isOp())
                    p.setAllowFlight(false);
                p.setFlying(false);
                p.sendMessage(ChatColor.BLUE + "[Système] " + ChatColor.YELLOW + "Fly désactivé.");

            } else {
                p.setAllowFlight(true);
                p.setFlying(true);
                p.sendMessage(ChatColor.BLUE + "[Système] " + ChatColor.YELLOW + "Fly activé.");
            }
        }
        return true;
    }


}
