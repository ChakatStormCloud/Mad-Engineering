package com.chakatstormcloud.madengineering.block;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.item.ItemPipe;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class BlockFrame extends Block{

	public BlockFrame(String name) {
		super(Material.IRON,MapColor.AIR);
		this.setUnlocalizedName(name);
		this.setRegistryName(MadEngineering.MODID, name);
		this.translucent = true;
		this.useNeighborBrightness = true;
		this.setResistance(30);
		this.setHardness(2);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (playerIn==null||playerIn.isSneaking()) return false;
		
		ItemStack holding = playerIn.getHeldItemMainhand(); 
		if (holding.getItem() instanceof ItemPipe) {
			//TODO add pipe to block.
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	
}
