package com.chakatstormcloud.madengineering.utility;

import java.util.List;

import net.minecraft.item.ItemStack;

public interface IBreakableInventory {

	List<ItemStack> getStacksToDrop();
	
}
