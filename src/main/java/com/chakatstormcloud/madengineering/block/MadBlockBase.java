package com.chakatstormcloud.madengineering.block;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.item.IHasModel;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class MadBlockBase extends Block implements IHasModel{

	public MadBlockBase(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(MadEngineering.MODID, name);
		
		MadEngBlocks.Blocks.add(this);
		MadEngItems.Items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}
	
	public void registerModel() {
		MadEngineering.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
}
