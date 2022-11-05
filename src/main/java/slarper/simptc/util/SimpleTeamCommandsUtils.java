package slarper.simptc.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

public class SimpleTeamCommandsUtils {

    public static void playerTp(EntityPlayerMP teleportingPlayer, BlockPos pos, Vec2f pitchYaw) {
        Set<SPacketPlayerPosLook.EnumFlags> set = EnumSet.noneOf(SPacketPlayerPosLook.EnumFlags.class);
        double x = pos.getX() + 0.5;
        double y = pos.getY();
        double z = pos.getZ() + 0.5;
        teleportingPlayer.dismountRidingEntity();
        teleportingPlayer.connection.setPlayerLocation(x,y,z, pitchYaw.y, pitchYaw.x, set);
    }

    public static void playerToPlayer(EntityPlayerMP teleportingPlayer, EntityPlayerMP toPlayer) {
        BlockPos pos = toPlayer.getPosition();
        Vec2f pitchYaw = toPlayer.getPitchYaw();
        playerTp(teleportingPlayer, pos, pitchYaw);
    }

    public static String findAnotherPlayerName(MinecraftServer server, ICommandSender sender) {
        Optional<String> playerName = Arrays.stream(server.getOnlinePlayerNames())
                .filter(name -> !name.equals(sender.getName())).findFirst();

        return playerName.orElse(null);
    }
}
