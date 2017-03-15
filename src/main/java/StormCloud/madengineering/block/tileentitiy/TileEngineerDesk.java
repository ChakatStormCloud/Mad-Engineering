package StormCloud.madengineering.block.tileentitiy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IInteractionObject;
import StormCloud.madengineering.item.ItemNoteBook;

public class TileEngineerDesk extends TileEntity implements IInventory, IInteractionObject{
	
	private ItemStack[] deskItemStacks = new ItemStack[1];
	
	
	
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSizeInventory() {
		return this.deskItemStacks.length;
	}

	public ItemStack getStackInSlot(int index) {
		return this.deskItemStacks[index];
	}

	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return true;
	}

	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(index == 0 && stack.getItem() == new ItemNoteBook()) {
			return true;
		}
		return false;
	}

	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGuiID() {
		// TODO Auto-generated method stub
		return null;
	}

}
