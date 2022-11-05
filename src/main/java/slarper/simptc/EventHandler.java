package slarper.simptc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slarper.simptc.capability.home.IPlayerHome;
import slarper.simptc.capability.home.PlayerHomeProvider;

public class EventHandler {


    /**
     * Copy data from dead player to the new player
     */
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();
        IPlayerHome home = player.getCapability(PlayerHomeProvider.PLAYER_HOME_CAPABILITY, null);
        IPlayerHome oldHome = event.getOriginal().getCapability(PlayerHomeProvider.PLAYER_HOME_CAPABILITY, null);

        home.setPlayerHome(oldHome.getPlayerHome());
    }
}
