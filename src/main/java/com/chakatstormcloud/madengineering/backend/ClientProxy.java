package com.chakatstormcloud.madengineering.backend;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.gui.GuiHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {
	
	
	@Override
	public void init() {
		super.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(MadEngineering.instance, new GuiHandler());
	}
	
	
	@Override
	public void registerRender(){
		
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String location, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(location, id));
	}
	
}
