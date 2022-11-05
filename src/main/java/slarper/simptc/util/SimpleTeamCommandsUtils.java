package slarper.simptc.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import slarper.simptc.capability.back.PlayerBackProvider;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

public class SimpleTeamCommandsUtils {
    public static void tpCanBack(EntityPlayerMP teleportingPlayer, BlockPos pos, float pitch, float yaw){
        teleportingPlayer.getCapability(PlayerBackProvider.PLAYER_BACK_CAPABILITY, null).set(teleportingPlayer.getPosition());
        tp(teleportingPlayer, pos, pitch, yaw);
    }

    public static void tp(EntityPlayerMP teleportingPlayer, BlockPos pos, float pitch, float yaw) {
        Set<SPacketPlayerPosLook.EnumFlags> set = EnumSet.noneOf(SPacketPlayerPosLook.EnumFlags.class);
        double x = pos.getX() + 0.5;
        double y = pos.getY();
        double z = pos.getZ() + 0.5;
        teleportingPlayer.dismountRidingEntity();
        teleportingPlayer.connection.setPlayerLocation(x,y,z, yaw, pitch, set);
    }

    public static void playerTo(EntityPlayerMP teleportingPlayer, BlockPos pos) {
        tpCanBack(teleportingPlayer, pos, teleportingPlayer.rotationPitch, teleportingPlayer.rotationYaw);
    }

    public static void playerToPlayer(EntityPlayerMP teleportingPlayer, EntityPlayerMP toPlayer) {
        BlockPos pos = toPlayer.getPosition();
        tpCanBack(teleportingPlayer, pos, toPlayer.rotationPitch, toPlayer.rotationYaw);
    }

    public static String findAnotherPlayerName(MinecraftServer server, ICommandSender sender) {
        Optional<String> playerName = Arrays.stream(server.getOnlinePlayerNames())
                .filter(name -> !name.equals(sender.getName())).findFirst();

        return playerName.orElse(null);
    }
}
