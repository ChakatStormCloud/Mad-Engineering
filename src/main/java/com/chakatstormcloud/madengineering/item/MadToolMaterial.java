package com.chakatstormcloud.madengineering.item;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MadToolMaterial{
	
	public static ToolMaterial cryopick;
	public static ToolMaterial upgradeable;
	
	public static void initToolMaterials() {
		
		cryopick = EnumHelper.addToolMaterial(MadEngineering.MODID + ".cryopick", 3, 400, 6.5F, 2.0F, 10);
		upgradeable = EnumHelper.addToolMaterial(MadEngineering.MODID + ".upgradeable", 2, 400, 4F, 3F, 9);
		
	}
	
}
