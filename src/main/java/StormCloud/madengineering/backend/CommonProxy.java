package StormCloud.madengineering.backend;

import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.block.BlocksHandler;
import StormCloud.madengineering.block.tileentity.TileEngineerDesk;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void init(){
		
	}
	
	public void registerRenders(){
		
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEngineerDesk.class, MadEngineering.MODID + ":" + BlocksHandler.blockEngineerDesk.getUnlocalizedName().substring(5));
		
		
	}
	
}
