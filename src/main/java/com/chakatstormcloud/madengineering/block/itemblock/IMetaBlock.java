package com.chakatstormcloud.madengineering.block.itemblock;

import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IMetaEnum;

import net.minecraft.item.ItemStack;

public interface IMetaBlock {
	
	String getMetaName(ItemStack stack);
	
	Class<? extends Enum> getMetaEnum();
	
}
