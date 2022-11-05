package slarper.simptc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import slarper.simptc.capability.IPlayerHome;
import slarper.simptc.capability.PlayerHomeProvider;
import slarper.simptc.util.SimpleTeamCommandsUtils;

public class Home extends CommandBase {
    @Override
    public String getName() {
        return "home";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = ((EntityPlayerMP) sender);
            IPlayerHome home = player.getCapability(PlayerHomeProvider.PLAYER_HOME_CAPABILITY,null);
            SimpleTeamCommandsUtils.playerTp(player, home.getPlayerHome(), player.getPitchYaw());
        }
    }
}
