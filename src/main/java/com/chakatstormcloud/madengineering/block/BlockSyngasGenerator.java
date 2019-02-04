package com.chakatstormcloud.madengineering.block;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.block.tileentity.TileSyngasGenerator;
import com.chakatstormcloud.madengineering.gui.GuiHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSyngasGenerator extends BlockMachine {

	public BlockSyngasGenerator(String name) {
		super(name);
	}
	
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileSyngasGenerator();
	}
	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(worldIn.isRemote){
			return true;
		}else{
			//playerIn.openGui(MadEngineering.instance, GuiHandler.
			return true;
			
		}
		
		//return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}
