package StormCloud.madengineering.block;

import javax.annotation.Nullable;

import StormCloud.madengineering.block.tileentitiy.TileEngineerDesk;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEngineerDesk extends BlockContainer{

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
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
    }

	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEngineerDesk();
	}
	
	
}
