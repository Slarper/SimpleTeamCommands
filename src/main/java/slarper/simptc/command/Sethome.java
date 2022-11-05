package slarper.simptc.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import slarper.simptc.capability.IPlayerHome;
import slarper.simptc.capability.PlayerHomeProvider;

/*
 * sethome : add current postion to player entity's 'home' nbt.
 */
public class Sethome extends CommandBase {
    @Override
    public String getName() {
        return "sethome";
    }

    @Override
    public String getUsage( ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (sender instanceof EntityPlayerMP) {
            EntityPlayerMP player = ((EntityPlayerMP) sender);
            IPlayerHome home = player.getCapability(PlayerHomeProvider.PLAYER_HOME_CAPABILITY,null);
            home.setPlayerHome(player.getPosition());
        }
    }
}
