package StormCloud.madengineering.block;

import java.util.ArrayList;

import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.Utility;
import StormCloud.madengineering.backend.handlers.Enumnums.EngineerDeskTypes;
import StormCloud.madengineering.backend.handlers.Enumnums.IMetaEnum;
import StormCloud.madengineering.backend.handlers.Enumnums.OreTypes;
import StormCloud.madengineering.block.itemblock.ItemBlockMetaBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlocksHandler {
	
	public static Block blockEngineerDesk;
	public static Block blockOre;
	
	
	public static void init(){
		blockEngineerDesk = new BlockEngineerDesk("blockEngineerDesk","blockEngineerDesk");
		blockOre = new BlockOre("blockOre");
	}
	
	public static void register(){
		registerBlock(blockEngineerDesk, new ItemBlockMetaBlock(blockEngineerDesk));
		registerBlock(blockOre, new ItemBlockMetaBlock(blockOre));
	}
	public static void registerRenders(){
		registerRenderMeta(blockEngineerDesk, EngineerDeskTypes.values());
		registerRenderMeta(blockOre, OreTypes.values());
	}
	
	//===========Block Registers=====
	
	public static void registerBlock(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utility.getLogger().info("Registered block: "+ block.getUnlocalizedName().substring(5));
	}
	// for meta
	public static void registerBlock(Block block, ItemBlock itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utility.getLogger().info("Registered block: "+ block.getUnlocalizedName().substring(5));
	}
	
	
	//===========Renger Registers====
	
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
