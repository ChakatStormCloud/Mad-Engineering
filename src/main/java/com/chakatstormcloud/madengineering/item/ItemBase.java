package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	
	public ItemBase(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		
		//TODO setCreativeTab(tab);
		
		MadEngItems.Items.add(this);
		
	}
	
	
	@Override
	public void registerModel() {
		MadEngineering.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	
}
