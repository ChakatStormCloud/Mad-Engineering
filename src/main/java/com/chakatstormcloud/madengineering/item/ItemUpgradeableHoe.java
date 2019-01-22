package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.ItemHoe;
import net.minecraft.util.ResourceLocation;

public class ItemUpgradeableHoe extends ItemHoe{

	public ItemUpgradeableHoe(ToolMaterial material,String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID, unlocalizedName);
	}

}
