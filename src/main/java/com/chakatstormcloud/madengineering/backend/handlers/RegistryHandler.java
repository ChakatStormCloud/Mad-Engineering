package com.chakatstormcloud.madengineering.backend.handlers;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.Utility;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IMetaEnum;
import com.chakatstormcloud.madengineering.block.MadEngBlocks;
import com.chakatstormcloud.madengineering.block.tileentity.TileEngineerDesk;
import com.chakatstormcloud.madengineering.fluid.MadEngFluids;
import com.chakatstormcloud.madengineering.item.IMetaItem;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidRegistry.FluidRegisterEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid=MadEngineering.MODID)
public class RegistryHandler {
	
	
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		Utility.getLogger().info("Registering Items - Mad Engineering...");
		IForgeRegistry<Item> registry = event.getRegistry();
		
		for(Item item: MadEngItems.Items) {
			registry.register(item);
			Utility.getLogger().info("Registered item: " + item.getUnlocalizedName());
		}
		for(Fluid fluid: MadEngFluids.Fluids) {
			FluidRegistry.registerFluid(fluid);
			FluidRegistry.addBucketForFluid(fluid);
		}
		
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		Utility.getLogger().info("Registering Blocks - Mad Engineering...");
		IForgeRegistry<Block> registry = event.getRegistry();
		
		for(Block block: MadEngBlocks.Blocks) {
			registry.register(block);
			Utility.getLogger().info("Registered block: " + block.getUnlocalizedName());
		}
		
		GameRegistry.registerTileEntity(TileEngineerDesk.class, new ResourceLocation(MadEngineering.MODID,"tileEngineerDesk"));
	}
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		Utility.getLogger().info("Registering Models - Mad Engineering...");
		
		for(Item item: MadEngItems.Items) {
			if(item instanceof IMetaItem) {
				for(IMetaEnum meta:(IMetaEnum[])((IMetaItem)item).getMetaEnums()) {
					MadEngineering.proxy.registerItemRenderer(item, meta.getMeta(),MadEngineering.MODID+":"+ item.getUnlocalizedName().substring(5)+"_"+meta.getName(), "inventory");
				}
			}else
			MadEngineering.proxy.registerItemRenderer(item, 0,MadEngineering.MODID+":"+ item.getUnlocalizedName().substring(5), "inventory");
		}
		
	}
	
	
	
	
}
