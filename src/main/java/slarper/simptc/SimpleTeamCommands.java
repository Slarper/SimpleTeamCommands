package slarper.simptc;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import slarper.simptc.command.*;

@Mod(modid = SimpleTeamCommands.MODID, name = SimpleTeamCommands.NAME, version = SimpleTeamCommands.VERSION)
public class SimpleTeamCommands
{
    public static final String MODID = "simptc";
    public static final String NAME = "Simple Team Commands";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
        logger.info("Simple Team Commands Mod initialized!");
    }

    @EventHandler
    public void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new To());
        event.registerServerCommand(new Sethome());
        event.registerServerCommand(new Home());
        event.registerServerCommand(new Here());
        event.registerServerCommand(new Back());
    }

    @SidedProxy(clientSide = "slarper.simptc.CommonProxy", serverSide = "slarper.simptc.CommonProxy")
    public static CommonProxy proxy;
}
