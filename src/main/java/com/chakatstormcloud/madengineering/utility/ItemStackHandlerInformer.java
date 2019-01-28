package com.chakatstormcloud.madengineering.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStackHandlerInformer extends ItemStackHandler {
	
	private IInformable te;

	public ItemStackHandlerInformer(IInformable te) {
		this(1,te);
	}

	public ItemStackHandlerInformer(int size,IInformable te) {
		super(size);
		this.te =te;
		
	}

	public ItemStackHandlerInformer(NonNullList<ItemStack> stacks,IInformable te) {
		super(stacks);
		this.te =te;
	}
	
	@Override
	protected void onContentsChanged(int slot) {
		super.onContentsChanged(slot);
		te.inform(this);
	}
	
	
	
	
}
