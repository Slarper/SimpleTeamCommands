package slarper.simptc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slarper.simptc.capability.IPlayerBlockPos;
import slarper.simptc.capability.back.PlayerBackProvider;
import slarper.simptc.capability.home.PlayerHomeProvider;

public class EventHandler {


    /**
     * Copy data from dead player to the new player
     */
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();

        IPlayerBlockPos home = player.getCapability(PlayerHomeProvider.PLAYER_HOME_CAPABILITY, null);
        IPlayerBlockPos oldHome = event.getOriginal().getCapability(PlayerHomeProvider.PLAYER_HOME_CAPABILITY, null);
        home.set(oldHome.get());

        IPlayerBlockPos back = player.getCapability(PlayerBackProvider.PLAYER_BACK_CAPABILITY, null);
        IPlayerBlockPos oldBack = event.getOriginal().getCapability(PlayerBackProvider.PLAYER_BACK_CAPABILITY, null);
        back.set(oldBack.get());

    }
}
