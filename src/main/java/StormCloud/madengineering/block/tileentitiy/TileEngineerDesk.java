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
	private String deskCustomName;
	
	//TODO ALL OF THIS
	
	public String getName() {
		return this.hasCustomName() ? this.deskCustomName : "container.engineerdesk";
	}

	public boolean hasCustomName() {
		return this.deskCustomName != null && !this.deskCustomName.isEmpty();
	}

	public int getSizeInventory() {
		return this.deskItemStacks.length;
	}

	public ItemStack getStackInSlot(int index) {
		return this.deskItemStacks[index];
	}

	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(index == 0 && stack.getItem() == new ItemNoteBook()) {
			return true;
		}
		return false;
	}


}
