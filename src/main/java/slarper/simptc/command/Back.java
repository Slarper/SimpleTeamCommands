package slarper.simptc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import slarper.simptc.capability.back.IPlayerBack;
import slarper.simptc.capability.back.PlayerBackProvider;
import slarper.simptc.util.SimpleTeamCommandsUtils;

public class Back extends CommandBase {
    @Override
    public String getName() {
        return "back";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = ((EntityPlayerMP) sender);
            IPlayerBack back = player.getCapability(PlayerBackProvider.PLAYER_BACK_CAPABILITY,null);
            SimpleTeamCommandsUtils.playerTo(player, back.get());
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
