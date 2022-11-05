package slarper.simptc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import slarper.simptc.util.SimpleTeamCommandsUtils;

import javax.annotation.Nullable;
import java.util.*;

/*
 * to : teleport to the nearest player
 * to [playerName] : teleport to the player
 */

public class To extends CommandBase {
    @Override
    public String getName() {
        return "to";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        String playerName = null;
        if (args.length == 0) {
            Optional<String> playerName1 = Arrays.stream(server.getOnlinePlayerNames())
                    .filter(name -> !name.equals(sender.getName())).findFirst();
            if (playerName1.isPresent()) {
                playerName = playerName1.get();
            } else {
                return;
            }
        } else {
            playerName = args[0];
        }
        EntityPlayerMP player = getPlayer(server, sender, playerName);
        EntityPlayerMP sender1 = getCommandSenderAsPlayer(sender);
        SimpleTeamCommandsUtils.playerToPlayer(sender1, player);
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        if (args.length == 1)
        {
            return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
        } else {
            return super.getTabCompletions(server, sender, args, targetPos);
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
