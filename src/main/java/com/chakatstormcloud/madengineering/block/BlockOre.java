package com.chakatstormcloud.madengineering.block;

import java.util.List;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IMetaEnum;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.OreTypes;
import com.chakatstormcloud.madengineering.block.itemblock.IMetaBlock;

import nc.enumm.MetaEnums.OreType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockOre extends Block implements IMetaBlock{
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", OreTypes.class);

	public BlockOre(String unlocalizedName){
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, unlocalizedName));
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreTypes.COPPER));
	}
	
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	
	//============BlockStates============//
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		OreTypes type = (OreTypes)state.getValue(TYPE);
		
		return type.getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, OreTypes.values()[meta]);
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for(int i = 0; i < OreTypes.values().length; i++){
			list.add(new ItemStack(this, 1, i));
		}
		OreTypes.values();
	}
	
	//=============Interface IMetaBlock=============//
	
	public String getMetaName(ItemStack stack) {
		return OreTypes.values()[stack.getItemDamage()].getName();
	}


	public Class<? extends Enum> getMetaEnum() {
		return OreTypes.class;
	}

	
	
	
	
}
