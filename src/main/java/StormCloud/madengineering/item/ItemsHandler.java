package StormCloud.madengineering.item;


import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.Utility;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemsHandler {
	
	public static Item itemNoteBook;
	
	public static final ToolMaterial upgradeable = EnumHelper.addToolMaterial(MadEngineering.MODID + ".upgradeable", 2, 400, 5F, 3F, 9);
	
	public static ItemPickaxe itemUpgradeablePickaxe;
	public static ItemAxe itemUpgradeableAxe;
	public static ItemHoe itemUpgradeableHoe;
	public static ItemSpade itemUpgradeableShovel;
	public static ItemSword itemUpgradeableSword;
	
	public static void init(){
		itemNoteBook = new ItemNoteBook("itemNoteBook","itemNoteBook");
		
		
		itemUpgradeablePickaxe = new ItemUpgradeablePickaxe(upgradeable,"itemUpgradeablePickaxe");
		itemUpgradeableAxe = new ItemUpgradeableAxe(upgradeable,"itemUpgradeableAxe");
		itemUpgradeableHoe = new ItemUpgradeableHoe(upgradeable,"itemUpgradeableHoe");
		itemUpgradeableShovel = new ItemUpgradeableShovel(upgradeable,"itemUpgradeableShovel");
		itemUpgradeableSword = new ItemUpgradeableSword(upgradeable,"itemUpgradeableSword");
		
		
	}
	
	public static void register(){
		registerItem(itemNoteBook);
		
		registerItem(itemUpgradeablePickaxe);
		registerItem(itemUpgradeableAxe);
		registerItem(itemUpgradeableHoe);
		registerItem(itemUpgradeableShovel);
		registerItem(itemUpgradeableSword);
	}
	
	public static void registerRenders(){
		registerRender(itemNoteBook);
		
		registerRender(itemUpgradeablePickaxe);
		registerRender(itemUpgradeableAxe);
		registerRender(itemUpgradeableHoe);
		registerRender(itemUpgradeableShovel);
		registerRender(itemUpgradeableSword);
	}
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
		Utility.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}
	/*
	 *please work 
	 */
	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(MadEngineering.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utility.getLogger().info("Registered render for item: " + item.getUnlocalizedName().substring(5));
	}

}
