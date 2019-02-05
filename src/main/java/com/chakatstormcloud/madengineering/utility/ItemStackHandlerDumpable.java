package com.chakatstormcloud.madengineering.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStackHandlerDumpable extends ItemStackHandler {

	public ItemStackHandlerDumpable() {
	}

	public ItemStackHandlerDumpable(int size) {
		super(size);
	}

	public ItemStackHandlerDumpable(NonNullList<ItemStack> stacks) {
		super(stacks);
	}
	
	public ItemStack[] dump() {
		ItemStack[] stacks = (ItemStack[]) this.stacks.toArray();
		this.stacks.clear();
		return stacks;
	}
	
}
