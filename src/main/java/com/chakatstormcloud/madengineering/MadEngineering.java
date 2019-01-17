package com.chakatstormcloud.madengineering;

import com.chakatstormcloud.madengineering.backend.CommonProxy;
import com.chakatstormcloud.madengineering.backend.handlers.CreativeTabHandler;
import com.chakatstormcloud.madengineering.backend.handlers.RecipeHandler;
import com.chakatstormcloud.madengineering.block.BlocksHandler;
import com.chakatstormcloud.madengineering.block.MadEngBlocks;
import com.chakatstormcloud.madengineering.item.ItemsHandler;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
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
	public static final String MCVERSION = "1.12.2";
	public static final String CLIENTPROXY = "com.chakatstormcloud.madengineering.backend.ClientProxy";
	public static final String COMMONPROXY = "com.chakatstormcloud.madengineering.backend.CommonProxy";
	public static final String SERVERPROXY = "com.chakatstormcloud.madengineering.backend.ServerProxy";
	
	
	@Instance
	public static MadEngineering instance;
	
	@SidedProxy(serverSide = SERVERPROXY, clientSide = CLIENTPROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		Utility.getLogger().info("PreInit - Mad Engineering...");
		
		proxy.preinit();
		
		MadEngItems.init();
		MadEngBlocks.init();
		CreativeTabHandler.init();
		CreativeTabHandler.assignCreativeTabs();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		Utility.getLogger().info("Init - Mad Engineering...");
		
		proxy.init();
		
		RecipeHandler.registerCraftingRecipies();
		RecipeHandler.registerSmeltingRecipies();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		Utility.getLogger().info("PostInit - Mad Engineering...");
		
		proxy.postinit();
		
		
	}
}
