package StormCloud.madengineering;

import StormCloud.madengineering.block.BlocksHandler;
import StormCloud.madengineering.item.ItemsHandler;
import StormCloud.madengineering.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MadEngineering.MODID,
		name = MadEngineering.MODNAME,
		version = MadEngineering.MODVERSION,
		acceptedMinecraftVersions = MadEngineering.MCVERSION)
public class MadEngineering {
	
	public static final String MODID = "madengineering";
	public static final String MODNAME = "Mad Engineering";
	public static final String MODVERSION = "0.1.1";
	public static final String MCVERSION = "1.10.2";
	public static final String CLIENTPROXY = "StormCloud.madengineering.proxy.ClientProxy";
	public static final String COMMONPROXY = "StormCloud.madengineering.proxy.CommonProxy";
	public static final String SERVERPROXY = "StormCloud.madengineering.proxy.ServerProxy";
	
	
	@Mod.Instance(MODID)
	public static MadEngineering instance;
	
	@SidedProxy(serverSide = SERVERPROXY, clientSide = CLIENTPROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Utility.getLogger().info("PreInit - Mad Engineering...");
		
		ItemsHandler.init();
		BlocksHandler.init();
		ItemsHandler.register();
		BlocksHandler.register();
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		Utility.getLogger().info("Init - Mad Engineering...");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		Utility.getLogger().info("PostInit - Mad Engineering...");
	}
}
