package com.chakatstormcloud.madengineering.creativetabs;

import com.chakatstormcloud.madengineering.item.ItemsHandler;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;;

public class TabMadEngineering extends CreativeTabs {
	
	
	public TabMadEngineering() {
		super("madenginering");
	}
	
	@Override
	public ItemStack getTabIconItem(){
		return new ItemStack(MadEngItems.itemNoteBook);
	}

}
