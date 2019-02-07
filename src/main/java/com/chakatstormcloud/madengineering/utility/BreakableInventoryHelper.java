package com.chakatstormcloud.madengineering.utility;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BreakableInventoryHelper{
	private static final Random RANDOM = new Random();

	public static void dropInventoryItems(World worldIn, BlockPos pos, IBreakableInventory inventory){
		dropInventoryItems(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), inventory);
	}

	public static void dropInventoryItems(World worldIn, Entity entityAt, IBreakableInventory inventory){
		dropInventoryItems(worldIn, entityAt.posX, entityAt.posY, entityAt.posZ, inventory);
	}

	private static void dropInventoryItems(World worldIn, double x, double y, double z, IBreakableInventory inventory)
	{	
		List<ItemStack> stacks = inventory.getStacksToDrop();
		
		for(ItemStack itemstack:stacks){
			
			if (!itemstack.isEmpty())
			{
				net.minecraft.inventory.InventoryHelper.spawnItemStack(worldIn, x, y, z, itemstack);
			}
		}
	}
}