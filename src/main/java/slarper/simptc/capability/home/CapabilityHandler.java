package slarper.simptc.capability.home;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slarper.simptc.SimpleTeamCommands;

public class CapabilityHandler
{
    public static final ResourceLocation PLAYER_HOME_CAPABILITY_ID = new ResourceLocation(SimpleTeamCommands.MODID, "mana");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(PLAYER_HOME_CAPABILITY_ID, new PlayerHomeProvider());
    }
}
