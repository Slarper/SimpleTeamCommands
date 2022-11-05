package slarper.simptc;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import slarper.simptc.capability.back.PlayerBack;
import slarper.simptc.capability.CapabilityHandler;
import slarper.simptc.capability.IPlayerBlockPos;
import slarper.simptc.capability.home.PlayerHome;
import slarper.simptc.capability.PlayerBlockPosStorage;

public class CommonProxy {
    public void init()
    {
        CapabilityManager.INSTANCE.register(IPlayerBlockPos.class, new PlayerBlockPosStorage(), PlayerHome::new);
        CapabilityManager.INSTANCE.register(IPlayerBlockPos.class, new PlayerBlockPosStorage(), PlayerBack::new);

        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
