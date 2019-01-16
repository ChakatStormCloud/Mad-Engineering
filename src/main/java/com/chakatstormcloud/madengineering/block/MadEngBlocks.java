package com.chakatstormcloud.madengineering.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;


public class MadEngBlocks {
	public static final List<Block> Blocks = new ArrayList<Block>();
	
	public static final Block blockEngineerDesk;
	public static final Block blockOre;
	public static final Block blockFrame;
	
	
	
	static {
		blockEngineerDesk = new BlockEngineerDesk("blockEngineerDesk","blockEngineerDesk");
		blockOre = new BlockOre("blockOre");
		blockFrame = new BlockFrame("blockFrame");
		
	}



	public static void init() {
		// TODO Auto-generated method stub
	}
	
	
}
