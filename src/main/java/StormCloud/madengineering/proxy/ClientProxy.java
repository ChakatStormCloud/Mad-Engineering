package StormCloud.madengineering.proxy;

import StormCloud.madengineering.block.BlocksHandler;
import StormCloud.madengineering.item.ItemsHandler;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders(){
		ItemsHandler.registerRenders();
		BlocksHandler.registerRenders();
	}
}
