package StormCloud.madengineering.backend.handlers;

import StormCloud.madengineering.Utility;
import StormCloud.madengineering.block.BlocksHandler;
import StormCloud.madengineering.item.ItemsHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipies(){
		GameRegistry.addShapedRecipe(new ItemStack(BlocksHandler.blockEngineerDesk, 1, 0), new Object[]{"PPP","ICI","I I", 'P', Blocks.PLANKS, 'I', Items.IRON_INGOT, 'C', Blocks.CRAFTING_TABLE});
		GameRegistry.addShapedRecipe(new ItemStack(ItemsHandler.itemNoteBook, 1, 0), new Object[]{" P ","PQP"," P ",'P',Items.PAPER,'Q',Items.WRITABLE_BOOK});
		
		Utility.getLogger().info("Registered Crafting Recipies! :)");
	}
	
	
	public static void registerSmeltingRecipies(){
		//Input can be block, item, or itemstack, Output must be itemstack, XP is a float
		//GameRegistry.addSmelting(input, output, xp);
		
		Utility.getLogger().info("No Smelting Recipies to Register :(");
	}
	
	
}
