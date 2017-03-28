package StormCloud.madengineering.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerEngineerDesk extends Container {
	
	
	private final World worldObj;
	/** Position of the Desk */
	private final BlockPos pos;
	
	public ContainerEngineerDesk(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
		this.worldObj = worldIn;
		this.pos = posIn;
	}
	
	public boolean canInteractWith(EntityPlayer playerIn) {
		
		return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		// TODO figure out this block state bit and add it back in.
		/*return this.worldObj.getBlockState(this.pos).getBlock() != Blocks.CRAFTING_TABLE ? 
		 * false : 
		 * playerIn.getDistanceSq(
		 * 				(double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D
		 * ) <= 64.0D;
		 */
	}

}
