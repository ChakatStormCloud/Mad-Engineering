package com.chakatstormcloud.madengineering.backend.handlers;

import com.chakatstormcloud.madengineering.block.MadEngBlocks;
import com.chakatstormcloud.madengineering.creativetabs.TabMadEngineering;
import com.chakatstormcloud.madengineering.item.MadEngItems;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabHandler {
	
	public static CreativeTabs tabMadEngineer;
	
	public static void init(){
		tabMadEngineer = new TabMadEngineering();
	}
	
	public static void assignCreativeTabs(){
		MadEngItems.itemNoteBook.setCreativeTab(tabMadEngineer);
		MadEngItems.itemUpgradeablePickaxe.setCreativeTab(tabMadEngineer);
		//MadEngItems.itemUpgradeableAxe.setCreativeTab(tabMadEngineer);
		MadEngItems.itemUpgradeableHoe.setCreativeTab(tabMadEngineer);
		MadEngItems.itemUpgradeableShovel.setCreativeTab(tabMadEngineer);
		MadEngItems.itemUpgradeableSword.setCreativeTab(tabMadEngineer);
		MadEngItems.itemCryoPick.setCreativeTab(tabMadEngineer);
		
		MadEngItems.itemComponent.setCreativeTab(tabMadEngineer);
		MadEngItems.itemDust.setCreativeTab(tabMadEngineer);
		MadEngItems.itemIngot.setCreativeTab(tabMadEngineer);
		
		MadEngBlocks.blockEngineerDesk.setCreativeTab(tabMadEngineer);
		MadEngBlocks.blockOre.setCreativeTab(tabMadEngineer);
		MadEngBlocks.blockFrame.setCreativeTab(tabMadEngineer);
		MadEngBlocks.blockSyngasGenerator.setCreativeTab(tabMadEngineer);
	}
	
}
