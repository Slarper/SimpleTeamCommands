package slarper.simptc;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import slarper.simptc.capability.CapabilityHandler;
import slarper.simptc.capability.IPlayerHome;
import slarper.simptc.capability.PlayerHome;
import slarper.simptc.capability.PlayerHomeStorage;

public class CommonProxy {
    public void init()
    {
        CapabilityManager.INSTANCE.register(IPlayerHome.class, new PlayerHomeStorage(), PlayerHome::new);

        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
