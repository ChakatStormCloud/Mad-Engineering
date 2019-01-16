package com.chakatstormcloud.madengineering.item;


import java.util.ArrayList;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.Utility;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;


@EventBusSubscriber
public class ItemsHandler {
	
	
	
	
	
	
	

	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MadEngineering.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenderMeta(Item item,IMetaEnum[] enums){
		ArrayList<ResourceLocation> list = new ArrayList<ResourceLocation>();
		
		for(IMetaEnum e:enums){
			
			ModelLoader.setCustomModelResourceLocation(item, (e).getMeta(), new ModelResourceLocation(new ResourceLocation(MadEngineering.MODID, item.getUnlocalizedName().substring(5) + "_" + e.toString()), "inventory"));
			Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5) + "." + e.toString());
			
			list.add(new ResourceLocation(MadEngineering.MODID,e.toString()));
		}
		// Thanks to irc.furnet.org/#CodingFurs for help with this little mess
		ModelBakery.registerItemVariants(item,list.toArray(new ResourceLocation[list.size()]));
		
	}

}
