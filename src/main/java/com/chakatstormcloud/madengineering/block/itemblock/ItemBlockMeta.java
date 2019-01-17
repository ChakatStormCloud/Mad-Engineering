package com.chakatstormcloud.madengineering.block.itemblock;

import com.chakatstormcloud.madengineering.item.IMetaItem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlock implements IMetaItem{
	private Class<? extends Enum> metaenum;
	
	public  ItemBlockMeta(Block block) {
		super(block);
		if(!(block instanceof IMetaBlock)){
			throw new IllegalArgumentException(String.format("The given Block %s is not an instance of IMetaBlock", block.getUnlocalizedName()));
		}
		this.metaenum=((IMetaBlock)block).getMetaEnum();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName()+"."+((IMetaBlock)this.block).getMetaName(stack);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public int[] getMetaValues() {
		Enum[] es = metaenum.getEnumConstants();
		int[] is = new int[es.length];
		for(int i =0;i<es.length;i++) {
			is[i]=es[i].ordinal();
		}
		return is;
	}

	@Override
	public Enum[] getMetaEnums() {
		return metaenum.getEnumConstants();
	}
	
}
