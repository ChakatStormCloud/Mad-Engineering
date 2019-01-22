package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;

public class ItemUpgradeableShovel extends ItemSpade {

	public ItemUpgradeableShovel(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID, unlocalizedName);
		
	}

}
