package com.chakatstormcloud.madengineering.block;

import java.util.ArrayList;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.Utility;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.EngineerDeskTypes;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IMetaEnum;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.OreTypes;
import com.chakatstormcloud.madengineering.block.itemblock.ItemBlockMetaBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksHandler {
	

	
	
	//===========Render Registers============
	
	public static void registerRender(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(MadEngineering.MODID,block.getUnlocalizedName().substring(5)), "inventory"));
		
		Utility.getLogger().info("Registered render for block: " + block.getUnlocalizedName().substring(5));
	}
	// for meta
	public static void registerRenderMeta(Block block,IMetaEnum[] enums){
		ArrayList<ResourceLocation> list = new ArrayList<ResourceLocation>();
		
		for(IMetaEnum e:enums){
			
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), e.getMeta(), new ModelResourceLocation(new ResourceLocation(MadEngineering.MODID, block.getUnlocalizedName().substring(5) + "_" + e.toString()), "inventory"));
			Utility.getLogger().info("Registered render for item: " + block.getUnlocalizedName().substring(5) + "." + e.getName());
			
			list.add(new ResourceLocation(MadEngineering.MODID,block.getUnlocalizedName().substring(5) + "_" + e.getName()));
		}
		// Thanks to irc.furnet.org/#CodingFurs for help with this little mess
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block),list.toArray(new ResourceLocation[list.size()]));
		
	}
}
