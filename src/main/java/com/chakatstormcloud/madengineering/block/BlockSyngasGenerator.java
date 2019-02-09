package com.chakatstormcloud.madengineering.block;

import com.chakatstormcloud.madengineering.block.tileentity.TileSyngasGenerator;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class BlockSyngasGenerator extends BlockMachineFacing {
	
	public static final PropertyBool HASFUEL = PropertyBool.create("hasfuel");
	
	public BlockSyngasGenerator(String name) {
		super(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(HASFUEL, false).withProperty(FACING, EnumFacing.NORTH));
		
	}
	//================BlockStates================//
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {HASFUEL,FACING});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i= super.getMetaFromState(state);
		
		if((Boolean)state.getValue(HASFUEL))i+=4;
		
		return i;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = super.getStateFromMeta(meta);
		
		if (meta>3)state = state.withProperty(HASFUEL, true);
		
		return state;
	}
	
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
	//================Tile Entity================//
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
		if (playerIn==null||playerIn.isSneaking()) return false;
//		IFluidHandler ifh = playerIn.getHeldItemMainhand().getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
//		if(ifh!=null) {
//			ifh.fill(resource, doFill)
//			return true;
//		}
		if(worldIn.isRemote){
			return true;
		}else{
			//playerIn.openGui(MadEngineering.instance, GuiHandler.
			return true;
			
		}
		
		
		//return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	
}
