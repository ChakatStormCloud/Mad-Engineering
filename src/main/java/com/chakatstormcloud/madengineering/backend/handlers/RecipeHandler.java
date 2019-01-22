package com.chakatstormcloud.madengineering.backend.handlers;

import com.chakatstormcloud.madengineering.Utility;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IngotTypes;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.OreTypes;
import com.chakatstormcloud.madengineering.block.MadEngBlocks;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipies(){
		//GameRegistry.addShapedRecipe(new ItemStack(BlocksHandler.blockEngineerDesk, 1, 0), new Object[]{"PPP","IPI","I I", 'P', Blocks.PLANKS, 'I', Items.IRON_INGOT});
		//GameRegistry.addShapedRecipe(new ItemStack(BlocksHandler.blockEngineerDesk, 1, 1), new Object[]{"PPP","ICI","I I", 'P', Blocks.PLANKS, 'I', Items.IRON_INGOT, 'C', Blocks.CRAFTING_TABLE});
		//GameRegistry.addShapedRecipe(new ItemStack(ItemsHandler.itemNoteBook, 1, 0), new Object[]{" P ","PQP"," P ",'P',Items.PAPER,'Q',Items.WRITABLE_BOOK});
		
		Utility.getLogger().info("Registered Crafting Recipies!");
	}
	
	
	public static void registerSmeltingRecipies(){
		GameRegistry.addSmelting(new ItemStack(MadEngBlocks.blockOre, 1, OreTypes.COPPER.getMeta()), new ItemStack(MadEngItems.itemIngot,1,IngotTypes.COPPER.getMeta()), 0.7f);
		GameRegistry.addSmelting(new ItemStack(MadEngBlocks.blockOre, 1, OreTypes.NICKEL.getMeta()), new ItemStack(MadEngItems.itemIngot,1,IngotTypes.NICKEL.getMeta()), 0.8f);
		GameRegistry.addSmelting(new ItemStack(MadEngBlocks.blockOre, 1, OreTypes.CHROME.getMeta()), new ItemStack(MadEngItems.itemIngot,1,IngotTypes.CHROME.getMeta()), 0.9f);
		GameRegistry.addSmelting(new ItemStack(MadEngBlocks.blockOre, 1, OreTypes.TUNGSTEN.getMeta()), new ItemStack(MadEngItems.itemIngot,1,IngotTypes.TUNGSTEN.getMeta()), 1.0f);
		
		Utility.getLogger().info("Registered Smelting Recipies!");
	}
	
	
}
