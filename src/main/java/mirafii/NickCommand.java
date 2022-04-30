package mirafii;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.StringJoiner;

public class NickCommand implements CommandExecutor {

    public NickCommand() {
    }


    // /roll [max]
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if (!p.isOp()) {
                return false;
            }

            if (args.length >= 2) {
                if (Bukkit.getServer().getPlayerExact(args[0]) == null) {
                    p.sendMessage(ChatColor.RED + "Joueur déconnecté.");
                } else {

                    Player pl = Bukkit.getPlayer(args[0]);
                    StringJoiner joiner = new StringJoiner(" ");
                    for (int i = 1; i < args.length; i++) {
                        joiner.add(args[i]);
                    }

                    pl.setDisplayName(ChatTools.applyColors(joiner.toString()));
                    pl.setPlayerListName(ChatTools.applyColors(joiner.toString()));
                    p.sendMessage(ChatColor.YELLOW + "Nickname de " + pl.getName() + ChatColor.YELLOW + " changé en : " + pl.getDisplayName() );

                }

            } else if (args.length == 1) {

                p.setDisplayName(args[0]);
                p.setPlayerListName(args[0]);
                p.sendMessage(ChatColor.BLUE + "[Système]" + ChatColor.YELLOW + "Nickname changé en : " + p.getDisplayName() );


            } else {
                p.sendMessage(ChatColor.RED + "Utilisation : /nick [pseudo] [nom]");
                p.sendMessage(ChatColor.RED + "-> Le nom peut avoir des espaces, les codes couleurs tolorés sont :");
                p.sendMessage(ChatColor.RED + "-> '&'[code] : Minecraft basique");
                p.sendMessage(ChatColor.RED + "-> '#'[code] : Code hexadécimal de la couleur");
            }
        }
        return true;
    }
}
