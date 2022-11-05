package slarper.simptc.capability;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slarper.simptc.SimpleTeamCommands;
import slarper.simptc.capability.back.PlayerBackProvider;
import slarper.simptc.capability.home.PlayerHomeProvider;

public class CapabilityHandler
{
    public static final ResourceLocation PLAYER_HOME_CAPABILITY_ID = new ResourceLocation(SimpleTeamCommands.MODID, "home");
    public static final ResourceLocation PLAYER_BACK_CAPABILITY_ID = new ResourceLocation(SimpleTeamCommands.MODID, "back");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(PLAYER_HOME_CAPABILITY_ID, new PlayerHomeProvider());
        event.addCapability(PLAYER_BACK_CAPABILITY_ID, new PlayerBackProvider());
    }
}
