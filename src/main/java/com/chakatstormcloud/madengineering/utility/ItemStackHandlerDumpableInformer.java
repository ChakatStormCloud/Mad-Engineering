package com.chakatstormcloud.madengineering.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemStackHandlerDumpableInformer extends ItemStackHandlerDumpable {

	private IInformable te;

	public ItemStackHandlerDumpableInformer(IInformable te) {
		this(1,te);
	}

	public ItemStackHandlerDumpableInformer(int size,IInformable te) {
		super(size);
		this.te =te;
		
	}

	public ItemStackHandlerDumpableInformer(NonNullList<ItemStack> stacks,IInformable te) {
		super(stacks);
		this.te =te;
	}
	
	@Override
	protected void onContentsChanged(int slot) {
		super.onContentsChanged(slot);
		te.inform(this);
	}
	
}
