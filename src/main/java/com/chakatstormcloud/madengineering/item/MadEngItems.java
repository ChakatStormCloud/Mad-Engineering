package com.chakatstormcloud.madengineering.item;

import java.util.ArrayList;
import java.util.List;

import com.chakatstormcloud.madengineering.MadEngineering;

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
	
	public static ToolMaterial upgradeable = EnumHelper.addToolMaterial(MadEngineering.MODID + ".upgradeable", 2, 400, 4F, 3F, 9);
	
	public static ItemPickaxe itemUpgradeablePickaxe;
	public static ItemAxe itemUpgradeableAxe;
	public static ItemHoe itemUpgradeableHoe;
	public static ItemSpade itemUpgradeableShovel;
	public static ItemSword itemUpgradeableSword;
	
	
	public static final List<Item> Items = new ArrayList<Item>();
	
	
	
	
	public static void init(){
		
		Items.add(itemNoteBook = new ItemNoteBook("itemNoteBook"));
		Items.add(itemComponent = new ItemComponent("itemComponent"));
		Items.add(itemIngot = new ItemIngot("itemIngot"));
		Items.add(itemDust = new ItemDust("itemDust"));
		
		Items.add(itemUpgradeablePickaxe = new ItemUpgradeablePickaxe(upgradeable,"itemUpgradeablePickaxe"));
		//Items.add(itemUpgradeableAxe = new ItemUpgradeableAxe(upgradeable,"itemUpgradeableAxe"));
		Items.add(itemUpgradeableHoe = new ItemUpgradeableHoe(upgradeable,"itemUpgradeableHoe"));
		Items.add(itemUpgradeableShovel = new ItemUpgradeableShovel(upgradeable,"itemUpgradeableShovel"));
		Items.add(itemUpgradeableSword = new ItemUpgradeableSword(upgradeable,"itemUpgradeableSword"));
		
		
	}
	
	
}
