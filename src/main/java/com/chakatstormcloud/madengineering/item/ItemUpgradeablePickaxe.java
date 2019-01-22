package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

public class ItemUpgradeablePickaxe extends ItemPickaxe{
	
	
	protected ItemUpgradeablePickaxe(ToolMaterial material, String unlocalizedName){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID, unlocalizedName);
		
	}
}
