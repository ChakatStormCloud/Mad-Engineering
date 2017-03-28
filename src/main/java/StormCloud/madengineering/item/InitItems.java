package StormCloud.madengineering.item;


import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.Utility;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitItems {
	
	public static Item itemNoteBook;
	
	
	
	public static void init(){
		itemNoteBook = new ItemNoteBook("item_notebook","item_notebook");
	}
	
	public static void register(){
		registerItem(itemNoteBook);
	}
	
	public static void registerRenders(){
		registerRender(itemNoteBook);
	}
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
		Utility.getLogger().info("Register item " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(
						new ResourceLocation(MadEngineering.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utility.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}

}
