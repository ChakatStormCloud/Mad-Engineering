package com.chakatstormcloud.madengineering.block.tileentity;

import java.util.List;

import com.chakatstormcloud.madengineering.fluid.MadEngFluids;
import com.chakatstormcloud.madengineering.utility.IBreakableInventory;
import com.chakatstormcloud.madengineering.utility.IInformable;
import com.chakatstormcloud.madengineering.utility.ItemStackHandlerDumpableInformer;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.oredict.OreDictionary;

public class TileSyngasGenerator extends TileEntity implements ICapabilitySerializable<NBTTagCompound>, ITickable, IInformable, IBreakableInventory{
	
	private ItemStackHandlerDumpableInformer itemHandler;
	private FluidTank fluidHandler;
	
	private int heat;
	private int burntime;
	private int fuelsize;
	
	private boolean isProcessing;
	private boolean hasFuel;
	
	public TileSyngasGenerator() {
		heat = 0;
		burntime = 0;
		fuelsize = 1;
		itemHandler = new ItemStackHandlerDumpableInformer(1, this) {
			@Override
			public boolean isItemValid(int slot, ItemStack stack) {
				return (super.isItemValid(slot, stack) && (slot==1?TileSyngasGenerator.getBurntime(stack)>0:true) );
			}
		};
		fluidHandler = new FluidTank(MadEngFluids.fluidSynGas, 0,4000);
		fluidHandler.setCanFill(false);
		//fluidHandler.setTileEntity(this); //used to fire fluidfillevents, probably not needed here.
		
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
			if(heat>1000) {	
				if(burntime > (heat-1000)/100) {
					fluidHandler.fillInternal(new FluidStack(MadEngFluids.fluidSynGas,(heat-1000)/100), true);
					burntime -= (heat-1000)/100;
				}else {
					fluidHandler.fillInternal(new FluidStack(MadEngFluids.fluidSynGas,burntime), true);
					burntime = 0;
					if (!hasFuel||!useFuel()) {
						isProcessing=false;
					}
				}
			}
			if(heat < 2000) {
				heat++;
			}

			this.markDirty();
		}else {
			if (hasFuel && useFuel()) {
				isProcessing=true;

				this.markDirty();
			}else if (heat >0) {
				heat--;

				this.markDirty();
			}
		}
		
	}
	
	private boolean useFuel() {
		if(!itemHandler.getStackInSlot(0).isEmpty()) {
			ItemStack burn = itemHandler.extractItem(0, 1, false);
			if (!burn.isEmpty()) {
				burntime = fuelsize = getBurntime(burn);
				isProcessing = true;
				if (itemHandler.getStackInSlot(0).isEmpty()) {
					hasFuel = false;
				}

				return true;
			}
		}
		return false;
	}
	
	private static int getBurntime(ItemStack stack) {
		
		int[] oreDic = OreDictionary.getOreIDs(stack);
		
		for (int i: oreDic) {
			String name = OreDictionary.getOreName(i);
			switch(name) {
			case "plankWood":
				return 250;
			case "logWood":
				return 1000;
			case "stickWood":
				return 125;
			}
		}
		return 0;
	}


	@Override
	public void inform(Object source) {
		if(source == this.itemHandler) {
			if(!itemHandler.getStackInSlot(0).isEmpty()) {
				hasFuel=true;
				if(!isProcessing) {
					useFuel();
				}
			}
			this.markDirty();
		}
		
	}
	
	//================NBT==================//
	
	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = super.serializeNBT();
		tag.setTag("Feed",itemHandler.serializeNBT());
		tag = fluidHandler.writeToNBT(tag);
		tag.setBoolean("isProcessing", isProcessing);
		tag.setInteger("Heat", heat);
		tag.setInteger("Burntime", burntime);
		tag.setInteger("Fuelsize", fuelsize);
		
		return tag;
	}
	
	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		super.deserializeNBT(nbt);
		itemHandler.deserializeNBT(nbt.getCompoundTag("Feed"));
		if(getBurntime(itemHandler.getStackInSlot(0))>0) {
			hasFuel = true;
		}
		fluidHandler.readFromNBT(nbt);
		isProcessing = nbt.getBoolean("isProcessing");
		heat = nbt.getInteger("Heat");
		burntime = nbt.getInteger("Burntime");
		fuelsize = nbt.getInteger("Fuelsize");
	}


	@Override
	public List<ItemStack> getStacksToDrop() {
		return itemHandler.dump();
	}

}
