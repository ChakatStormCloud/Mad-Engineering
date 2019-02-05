package com.chakatstormcloud.madengineering.block;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.block.tileentity.TileSyngasGenerator;
import com.chakatstormcloud.madengineering.utility.BreakableInventoryHelper;
import com.chakatstormcloud.madengineering.utility.IBreakableInventory;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockMachine extends Block {

	public BlockMachine(String name) {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setRegistryName(MadEngineering.MODID, name);
		this.translucent = true;
		this.setResistance(30);
		this.setHardness(3);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity te = worldIn.getTileEntity(pos);
		if (te instanceof IBreakableInventory) {
			BreakableInventoryHelper.dropInventoryItems(worldIn, pos, (IBreakableInventory)te);
		}
		super.breakBlock(worldIn, pos, state);
	}
}
