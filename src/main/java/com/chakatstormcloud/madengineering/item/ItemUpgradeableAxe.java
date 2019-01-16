package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;

public class ItemUpgradeableAxe extends ItemAxe {

	protected ItemUpgradeableAxe(ToolMaterial material,String unlocalizedName){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, unlocalizedName));
		
	}
	

}
