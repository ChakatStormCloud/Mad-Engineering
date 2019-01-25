package com.chakatstormcloud.madengineering.block;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMachine extends Block {

	public BlockMachine(String name) {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setRegistryName(MadEngineering.MODID, name);
		this.translucent = true;
		this.setResistance(30);
		this.setHardness(3);
	}

}
