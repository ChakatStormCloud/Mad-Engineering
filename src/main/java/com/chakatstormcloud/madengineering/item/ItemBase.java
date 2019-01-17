package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.Item;

public class ItemBase extends Item{
	
	
	public ItemBase(String name){
		setUnlocalizedName(name);
		setRegistryName(MadEngineering.MODID,name);
		
		MadEngItems.Items.add(this);
		
	}
	
	
	
	
}
