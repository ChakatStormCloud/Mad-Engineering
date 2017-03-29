package StormCloud.madengineering.block;

import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.Utility;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksHandler {
	
	
	public static Block blockEngineerDesk;
	
	
	public static void init(){
		blockEngineerDesk = new BlockEngineerDesk("blockEngineerDesk","blockEngineerDesk");
	}
	
	public static void register(){
		registerBlock(blockEngineerDesk);
	}
	
	public static void registerRenders(){
		registerRender(blockEngineerDesk);
	}
	
	public static void registerBlock(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utility.getLogger().info("Registered block: "+ block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(MadEngineering.MODID,block.getUnlocalizedName().substring(5)), "inventory"));
		
		Utility.getLogger().info("Registered render for block: " + block.getUnlocalizedName().substring(5));
	}
}
