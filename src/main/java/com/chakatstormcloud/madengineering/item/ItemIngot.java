package com.chakatstormcloud.madengineering.item;

import java.util.List;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IngotTypes;

import nc.enumm.MetaEnums.IngotType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemIngot extends Item implements IMetaItem{
	
	public ItemIngot(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, unlocalizedName));
		this.setHasSubtypes(true);
		
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for(int i = 0; i < IngotTypes.values().length;i++){
			subItems.add(new  ItemStack(this,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() < IngotTypes.values().length){
			return this.getUnlocalizedName() + "." + IngotTypes.values()[stack.getItemDamage()].getName();
		}else{
			return this.getUnlocalizedName() + "." + IngotTypes.COPPER.getName();
		}
	}

	@Override
	public Enum[] getMetaEnums() {
		return IngotType.values();
	}

	@Override
	public int[] getMetaValues() {
		Enum[] en = IngotType.values();
		int[] is = new int[en.length];
		for(int i = 0; i< en.length;i++) {
			is[i]=en[i].ordinal();
		}
		return is;
	}
	
}
