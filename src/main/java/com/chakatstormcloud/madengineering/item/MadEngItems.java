package com.chakatstormcloud.madengineering.item;

import java.util.ArrayList;
import java.util.List;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.item.MadToolMaterial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;


public class MadEngItems {
	
	public static Item itemNoteBook;
	public static Item itemComponent;
	public static Item itemIngot;
	public static Item itemDust;
	
	public static ItemPickaxe itemUpgradeablePickaxe;
	public static ItemAxe itemUpgradeableAxe;
	public static ItemHoe itemUpgradeableHoe;
	public static ItemSpade itemUpgradeableShovel;
	public static ItemSword itemUpgradeableSword;
	
	public static ItemPickaxe itemCryoPick; 
	
	
	public static final List<Item> Items = new ArrayList<Item>();
	
	
	
	
	public static void init(){
		
		Items.add(itemNoteBook = new ItemNoteBook("itemNoteBook"));
		Items.add(itemComponent = new ItemComponent("itemComponent"));
		Items.add(itemIngot = new ItemIngot("itemIngot"));
		Items.add(itemDust = new ItemDust("itemDust"));
		
		Items.add(itemUpgradeablePickaxe = new ItemUpgradeablePickaxe(MadToolMaterial.upgradeable,"itemUpgradeablePickaxe"));
		//Items.add(itemUpgradeableAxe = new ItemUpgradeableAxe(MadToolMaterial.upgradeable,"itemUpgradeableAxe"));
		Items.add(itemUpgradeableHoe = new ItemUpgradeableHoe(MadToolMaterial.upgradeable,"itemUpgradeableHoe"));
		Items.add(itemUpgradeableShovel = new ItemUpgradeableShovel(MadToolMaterial.upgradeable,"itemUpgradeableShovel"));
		Items.add(itemUpgradeableSword = new ItemUpgradeableSword(MadToolMaterial.upgradeable,"itemUpgradeableSword"));
		
		Items.add(itemCryoPick = new ItemCryoPick(MadToolMaterial.cryopick,"itemCryoPick"));
	}
	
	
}
