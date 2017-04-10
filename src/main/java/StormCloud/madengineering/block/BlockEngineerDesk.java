package StormCloud.madengineering.block;

import java.util.List;


import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.backend.handlers.Enumnums.EngineerDeskTypes;
import StormCloud.madengineering.block.itemblock.IMetaBlockName;
import StormCloud.madengineering.block.tileentity.TileEngineerDesk;
import StormCloud.madengineering.gui.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;


/**
 * @author StormCloud
 *
 */
public class BlockEngineerDesk extends Block implements IMetaBlockName, ITileEntityProvider{
	
	public static final PropertyEnum TYPE =  PropertyEnum.create("type", EngineerDeskTypes.class);
	
	
	public BlockEngineerDesk(String unlocalizedName, String registryName) {
		super(Material.WOOD);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, registryName));
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EngineerDeskTypes.DESK));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if(state.getValue(TYPE) == EngineerDeskTypes.WORKSPACE){
			if(worldIn.isRemote){
				return true;
			}else{
				playerIn.openGui(MadEngineering.instance, GuiHandler.ENGINEERDESK_WORKSPACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
				return true;
			}
		}
		return false;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	//============Tile Entity=============//
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEngineerDesk();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEngineerDesk te = (TileEngineerDesk) world.getTileEntity(pos);
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for (int slot = 0; slot > handler.getSlots() -1;slot++){
			ItemStack stack = handler.getStackInSlot(slot);
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		}
		super.breakBlock(world, pos, state);
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
