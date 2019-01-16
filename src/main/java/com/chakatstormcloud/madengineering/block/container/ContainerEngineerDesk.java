package com.chakatstormcloud.madengineering.block.container;

import com.chakatstormcloud.madengineering.block.tileentity.TileEngineerDesk;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerEngineerDesk extends Container {
	
	private TileEngineerDesk tileentity;
	private IInventory playerInv;
	
	public ContainerEngineerDesk(IInventory playerInv, TileEngineerDesk te){
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		this.addSlotToContainer(new SlotItemHandler(handler,0,80,44));
		this.addSlotToContainer(new SlotItemHandler(handler,1,80,11));
		this.addSlotToContainer(new SlotItemHandler(handler,2,113,36));
		this.addSlotToContainer(new SlotItemHandler(handler,3,100,77));
		this.addSlotToContainer(new SlotItemHandler(handler,4,59,77));
		this.addSlotToContainer(new SlotItemHandler(handler,5,47,36));
		
		int xPos = 8; // xpos for begining of main inventory
		int yPos = 113; // ypos for begining of main inventory
		
		for(int y = 0; y < 3; y++ ){
			for(int x = 0; x < 9; x++){
				this.addSlotToContainer(new Slot(playerInv,x + y*9 + 9,xPos+x*18,yPos+y*18));
			}
		}
		
		for(int x = 0; x < 9; x++){ // for the hotbar
			this.addSlotToContainer(new Slot(playerInv, x, xPos+ x*18, 171));
		}
		this.playerInv=playerInv;
		this.tileentity=te;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileentity.isUseableByPlayer(playerIn);
	}
	
}
