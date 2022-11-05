package slarper.simptc;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import slarper.simptc.capability.back.IPlayerBack;
import slarper.simptc.capability.back.PlayerBack;
import slarper.simptc.capability.CapabilityHandler;
import slarper.simptc.capability.home.IPlayerHome;
import slarper.simptc.capability.home.PlayerHome;
import slarper.simptc.capability.back.PlayerBackStorage;
import slarper.simptc.capability.home.PlayerHomeStorage;

public class CommonProxy {
    public void init()
    {
        CapabilityManager.INSTANCE.register(IPlayerHome.class, new PlayerHomeStorage(), PlayerHome::new);
        CapabilityManager.INSTANCE.register(IPlayerBack.class, new PlayerBackStorage(), PlayerBack::new);

        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
