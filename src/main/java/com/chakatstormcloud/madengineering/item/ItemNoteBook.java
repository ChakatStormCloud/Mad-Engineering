package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemNoteBook extends Item {
	
	
	
	public ItemNoteBook(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID,unlocalizedName);
		this.maxStackSize = 1;
	}
	
	
	public ActionResult<ItemStack> onRightItemClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){
		
		
		
		return new ActionResult(EnumActionResult.PASS,itemStackIn);
	}

}
