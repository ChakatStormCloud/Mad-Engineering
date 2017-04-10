package StormCloud.madengineering.backend;

import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.block.BlocksHandler;
import StormCloud.madengineering.gui.GuiHandler;
import StormCloud.madengineering.item.ItemsHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	
	@Override
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(MadEngineering.instance, new GuiHandler());
	}
	
	
	@Override
	public void registerRenders(){
		ItemsHandler.registerRenders();
		BlocksHandler.registerRenders();
	}
	
}
