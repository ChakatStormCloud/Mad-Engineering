package StormCloud.madengineering.creativetabs;

import StormCloud.madengineering.item.ItemsHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;;

public class TabMadEngineering extends CreativeTabs {
	
	
	public TabMadEngineering() {
		super("madenginering");
	}
	
	@Override
	public Item getTabIconItem(){
		return ItemsHandler.itemNoteBook;
	}

}
