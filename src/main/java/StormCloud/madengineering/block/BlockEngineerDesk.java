package StormCloud.madengineering.block;

import java.util.List;


import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.backend.handlers.Enumnums.EngineerDeskTypes;
import StormCloud.madengineering.block.itemblock.IMetaBlockName;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


/**
 * @author StormCloud
 *
 */
public class BlockEngineerDesk extends Block implements IMetaBlockName{
	
	public static final PropertyEnum TYPE =  PropertyEnum.create("type", EngineerDeskTypes.class);
	
	
	public BlockEngineerDesk(String unlocalizedName, String registryName) {
		super(Material.WOOD);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, registryName));
		this.setHardness(2f);
		this.setResistance(2f);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EngineerDeskTypes.DESK));
	}
	/*
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	*/
	
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
		EngineerDeskTypes type = (EngineerDeskTypes)state.getValue(TYPE);
		
		return type.getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, EngineerDeskTypes.values()[meta]);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(int i = 0; i < EngineerDeskTypes.values().length; i++){
			list.add(new ItemStack(itemIn, 1, i));
		}
	}
	
	//=============Interface IMetaBlockName=============//
	
	public String getMetaName(ItemStack stack) {
		return EngineerDeskTypes.values()[stack.getItemDamage()].getName();
	}
	
}
