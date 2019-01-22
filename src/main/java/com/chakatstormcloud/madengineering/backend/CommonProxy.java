package com.chakatstormcloud.madengineering.backend;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.block.tileentity.TileEngineerDesk;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preinit() {
		
	}
	
	
	public void init(){
		
	}
	
	public void postinit() {
		
	}
	
	
	public void registerRender(){
		
	}

	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(TileEngineerDesk.class, MadEngineering.MODID + ":" + BlocksHandler.blockEngineerDesk.getUnlocalizedName().substring(5));
		
	}

	public void registerItemRenderer(Item item, int meta, String location, String id) {
		
	}
	
}
