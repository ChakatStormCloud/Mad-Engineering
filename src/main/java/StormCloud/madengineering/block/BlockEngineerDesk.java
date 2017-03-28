package StormCloud.madengineering.block;

import javax.annotation.Nullable;

import StormCloud.madengineering.MadEngineering;
//import StormCloud.madengineering.block.tileentitiy.TileEngineerDesk;
import net.minecraft.block.Block;
//import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

/**
 * @author StormCloud
 *
 */
public class BlockEngineerDesk extends Block{
	
	public static final String Name = "engineerdesk";
	
	// TODO implement facing
	// TODO implement model/render/crap I don't even know yet
	// TODO implement meta blocks for different parts of the multiblock workspace
	
	/**
	 * @author StormCloud
	 * Constructor
	 * 
	 */
	public BlockEngineerDesk() {
		super(Material.WOOD);
		
		
	}
	
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	// TODO crafting table as placeholder, fix later
            playerIn.displayGui(new BlockWorkbench.InterfaceCraftingTable(worldIn, pos));
            return true;
        }
    }
	/****** TODO implement tile entity and inventory storing
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEngineerDesk();
	}
	******/
	
	/**
	 * @author StormCloud
	 *
	 */
	public static class InterfaceEngineerDesk1 implements IInteractionObject{
		
		
		/*==============Constructor=============*/
		public InterfaceEngineerDesk1(){
			// TODO blank construtor
		}
		
		//==============IInteractionObject interface Methods=================
		public String getName() {
			return null;
		}
		public boolean hasCustomName() {
			return false;
		}
		public ITextComponent getDisplayName() {
			return null;
		}
		public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
			
			return null;
		}
		
		/**
		 *I don't really know what this is used for.... 
		 */
		public String getGuiID() {
			//TODO, find out if this is good enough
			return (MadEngineering.MODID + ":" + Name);
		}
		
	}
	
}
