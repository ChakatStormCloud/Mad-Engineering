package StormCloud.madengineering.backend.handlers;

import StormCloud.madengineering.block.BlocksHandler;
import StormCloud.madengineering.creativetabs.TabMadEngineering;
import StormCloud.madengineering.item.ItemsHandler;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabHandler {
	
	public static CreativeTabs tabMadEngineer;
	
	public static void init(){
		tabMadEngineer = new TabMadEngineering();
	}
	
	public static void assignCreativeTabs(){
		ItemsHandler.itemNoteBook.setCreativeTab(tabMadEngineer);
		ItemsHandler.itemUpgradeablePickaxe.setCreativeTab(tabMadEngineer);
		//ItemsHandler.itemUpgradeableAxe.setCreativeTab(tabMadEngineer);
		ItemsHandler.itemUpgradeableHoe.setCreativeTab(tabMadEngineer);
		ItemsHandler.itemUpgradeableShovel.setCreativeTab(tabMadEngineer);
		ItemsHandler.itemUpgradeableSword.setCreativeTab(tabMadEngineer);
		
		BlocksHandler.blockEngineerDesk.setCreativeTab(tabMadEngineer);
		
	}
	
}
