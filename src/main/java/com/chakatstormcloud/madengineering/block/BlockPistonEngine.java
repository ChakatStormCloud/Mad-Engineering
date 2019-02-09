package com.chakatstormcloud.madengineering.block;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPistonEngine extends BlockMachineFacing {
	
	public static final PropertyBool HASFUEL = PropertyBool.create("hasfuel");
	
	
	
	public BlockPistonEngine(String name) {
		super(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(HASFUEL,false).withProperty(FACING,EnumFacing.NORTH));
	}
	
	
	
	//================BlockStates================//
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {HASFUEL,FACING});
	}
	
	
}
