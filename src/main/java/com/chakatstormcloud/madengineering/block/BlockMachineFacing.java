package com.chakatstormcloud.madengineering.block;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockMachineFacing extends BlockMachine{
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockMachineFacing(String name) {
		super(name);
	}
	
	//================BlockStates================//
	@Override
	protected abstract BlockStateContainer createBlockState();
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i=0;
		
		switch(state.getValue(FACING)){
		case EAST:
			i+=1;
			break;
		case SOUTH:
			i+=2;
			break;
		case WEST:
			i+=3;
			break;
		default:
			i+=0;
			break;
		}
		
		return i;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		
		switch(meta%4) {
		case 1:
			state = state.withProperty(FACING, EnumFacing.EAST);
			break;
		case 2:
			state = state.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 3:
			state = state.withProperty(FACING, EnumFacing.WEST);
		default:
		}
		
		return state;
	}
	
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
}
