package com.chakatstormcloud.madengineering.utility;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<ItemStack> dump() {
		List<ItemStack> stacks = copyList();
		this.stacks.clear();
		return stacks;
	}
	
	private NonNullList<ItemStack> copyList(){
		NonNullList<ItemStack> newlist = NonNullList.withSize(stacks.size(), ItemStack.EMPTY);
		int i=0;
		for(ItemStack st:stacks) {
			newlist.set(i,st.copy());
			i++;
		}
		
		return newlist;
	}
	
}
