package StormCloud.madengineering.block.tileentity;

import StormCloud.madengineering.item.ItemsHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEngineerDesk extends TileEntity implements ICapabilityProvider{
	
	private ItemStackHandler handler;
	
	
	public TileEngineerDesk(){
		this.handler = new ItemStackHandler(6);
	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));
		super.readFromNBT(nbt);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setTag("ItemStackHandler", this.handler.serializeNBT());
		return super.writeToNBT(nbt);
	}
	
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(index == 0 && stack.getItem() == ItemsHandler.itemNoteBook) {
			return true;
		}
		return false;
	}
	
	//==============Capability Inventory=========//
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return (T) this.handler;
		}
		return null;
		
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	
	
	//==============Save me============//
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}


	public boolean isUseableByPlayer(EntityPlayer playerIn) {
		return this.worldObj.getTileEntity(this.getPos()) == this
				&& playerIn.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
}
