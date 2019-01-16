package com.chakatstormcloud.madengineering.backend.handlers;

import com.chakatstormcloud.madengineering.Utility;
import com.chakatstormcloud.madengineering.block.MadEngBlocks;
import com.chakatstormcloud.madengineering.item.IHasModel;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		
		IForgeRegistry<Item> registry = event.getRegistry();
		
		for(Item item: MadEngItems.Items) {
			registry.register(item);
			Utility.getLogger().info("Registered item: " + item.getUnlocalizedName());
		}
		
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		
		IForgeRegistry<Block> registry = event.getRegistry();
		
		for(Block block: MadEngBlocks.Blocks) {
			registry.register(block);
			Utility.getLogger().info("Registered block: " + block.getUnlocalizedName());
		}
		
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		
		for(Item item: MadEngItems.Items) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModel();
			}
		}
		for(Block block: MadEngBlocks.Blocks) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModel();
			}
		}
	}
	
	
	
	
}
