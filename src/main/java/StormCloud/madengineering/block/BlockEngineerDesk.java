package StormCloud.madengineering.block;

import java.util.Random;

import javax.annotation.Nullable;

import StormCloud.madengineering.MadEngineering;
//import StormCloud.madengineering.block.tileentitiy.TileEngineerDesk;
import net.minecraft.block.Block;
//import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;

/**
 * @author StormCloud
 *
 */
public class BlockEngineerDesk extends Block{
	
	
	
	/**
	 * @author StormCloud
	 * Constructor
	 * 
	 */
	public BlockEngineerDesk(String unlocalizedName, String registryName) {
		super(Material.WOOD);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, registryName));
		this.setHardness(2f);
		this.setResistance(2f);
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
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
	
	
}
