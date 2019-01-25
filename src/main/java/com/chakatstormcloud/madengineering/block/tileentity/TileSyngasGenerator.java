package com.chakatstormcloud.madengineering.block.tileentity;

import com.chakatstormcloud.madengineering.fluid.MadEngFluids;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;

public class TileSyngasGenerator extends TileEntity implements ICapabilitySerializable<NBTTagCompound>, ITickable{
	
	private IItemHandler itemHandler;
	private IFluidHandler fluidHandler;
	
	private ItemStack feed;
	private float heat;
	private float burntime;
	private float fuelsize;
	private FluidStack syn;
	
	private boolean isProcessing;
	private boolean hasFuel;
	
	public TileSyngasGenerator() {
		feed = ItemStack.EMPTY;
		heat = 0f;
		burntime = 0f;
		fuelsize = 1f;
		syn = new FluidStack(MadEngFluids.fluidSynGas, 0);
	}
	
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return (T) this.itemHandler;
		}else if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
			return (T) this.fluidHandler;
		}
		return null;
		
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return true;
		}else if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	
	
	//================= Processing ================//
	
	@Override
	public void update() {
		if(isProcessing) {
			if(burntime > heat) {
				syn.amount += heat;
				burntime -= heat;
			}else {
				syn.amount += burntime;
				burntime = 0;
				if (!useFuel()) {
					isProcessing=false;
				}
			}
			if(heat < 10) {
				heat = (heat+0.5 > 10 ? 10f :heat+0.5f);
			}
		}else {
			if (heat >0) {
				heat = (heat-0.3f < 0 ? 0f :heat-0.3f);
			}
			if (hasFuel && useFuel()) {
				isProcessing=true;
			}
		}
		
	}
	
	private boolean useFuel() {
		if((!feed.isEmpty()) && getBurntime()) {
			if(feed.getCount() <= 1)
				feed = ItemStack.EMPTY;
			else
				feed.setCount(feed.getCount()-1);
			
			return true;
		}
		return false;
	}
	
	private boolean getBurntime() {
		
		if (feed.getCount() <= 0) {feed=ItemStack.EMPTY;return false;}
		
		int[] oreDic = OreDictionary.getOreIDs(feed);
		
		for (int i: oreDic) {
			String name = OreDictionary.getOreName(i);
			switch(name) {
			case "plankWood":
				burntime = fuelsize = 250;
				return true;
			case "logWood":
				
				burntime = fuelsize = 1000;
				return true;
			case "stickWood":
				
				burntime = fuelsize = 125;
				return true;
			}
		}
		return false;
	}
	
	
	
}
