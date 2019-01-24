package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.DustTypes;
import com.chakatstormcloud.madengineering.backend.handlers.Enumnums.IMetaEnum;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemDust extends Item implements IMetaItem{

	public ItemDust(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(MadEngineering.MODID, unlocalizedName);
		this.setHasSubtypes(true);
		
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for(int i = 0; i < DustTypes.values().length;i++){
			subItems.add(new  ItemStack(this,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() < DustTypes.values().length){
			return this.getUnlocalizedName() + "." + DustTypes.values()[stack.getItemDamage()].getName();
		}else{
			return this.getUnlocalizedName() + "." + DustTypes.COPPER.getName();
		}
	}
	
	//===============IMetaItem===========//
	@Override
	public Enum[] getMetaEnums() {
		return DustTypes.values();
	}

	@Override
	public int[] getMetaValues() {
		IMetaEnum[] en = DustTypes.values();
		int[] is = new int[en.length];
		for(int i = 0; i< en.length;i++) {
			is[i]=en[i].getMeta();
		}
		return is;
	}
	

}
