package com.chakatstormcloud.madengineering.block;

import java.util.ArrayList;
import java.util.List;

import com.chakatstormcloud.madengineering.block.itemblock.IMetaBlock;
import com.chakatstormcloud.madengineering.block.itemblock.ItemBlockMeta;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;


public class MadEngBlocks {
	public static final List<Block> Blocks = new ArrayList<Block>();
	
	public static Block blockEngineerDesk;
	public static Block blockOre;
	public static Block blockFrame;
	

	public static void init() {
		
		Blocks.add(blockEngineerDesk = new BlockEngineerDesk("blockEngineerDesk"));
		Blocks.add(blockOre = new BlockOre("blockOre"));
		Blocks.add(blockFrame = new BlockFrame("blockFrame"));
		
		for(Block block:Blocks) {
			if (block instanceof IMetaBlock) {
				MadEngItems.Items.add(new ItemBlockMeta(block).setRegistryName(block.getRegistryName()));
				
			}else {	
				MadEngItems.Items.add(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			}
		}
	}
	
	
}
