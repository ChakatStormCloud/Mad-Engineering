package com.chakatstormcloud.madengineering.item;

import java.util.List;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.ComponentTypes;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemComponent extends Item implements IMetaItem {
	
	public ItemComponent(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID,unlocalizedName);
		this.setHasSubtypes(true);
	}
	
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for(int i = 0; i < ComponentTypes.values().length;i++){
			subItems.add(new  ItemStack(this,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() < ComponentTypes.values().length){
			return this.getUnlocalizedName() + "." + ComponentTypes.values()[stack.getItemDamage()].getName();
		}else{
			return this.getUnlocalizedName() + "." + ComponentTypes.BROKEN.getName();
		}
	}


	@Override
	public Enum[] getMetaEnums() {
		
		return ComponentTypes.values();
	}


	@Override
	public int[] getMetaValues() {
		Enum[] nums = getMetaEnums();
		int[] vals = new int[nums.length];
		for(int i = 0;i<nums.length;i++) {
			vals[i]=nums[i].ordinal();
		}
		return vals;
	}


	
}
