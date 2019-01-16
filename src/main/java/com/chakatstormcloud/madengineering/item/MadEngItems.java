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
	
	public static final Item itemNoteBook;
	public static final Item itemComponent;
	public static final Item itemIngot;
	
	public static final ToolMaterial upgradeable = EnumHelper.addToolMaterial(MadEngineering.MODID + ".upgradeable", 2, 400, 4F, 3F, 9);
	
	public static final ItemPickaxe itemUpgradeablePickaxe;
	public static final ItemAxe itemUpgradeableAxe;
	public static final ItemHoe itemUpgradeableHoe;
	public static final ItemSpade itemUpgradeableShovel;
	public static final ItemSword itemUpgradeableSword;
	
	
	public static final List<Item> Items = new ArrayList<Item>();
	
	
	static {
		itemNoteBook = new ItemNoteBook("itemNoteBook","itemNoteBook");
		itemComponent = new ItemComponent("itemComponent");
		itemIngot = new ItemIngot("itemIngot");
		
		itemUpgradeablePickaxe = new ItemUpgradeablePickaxe(upgradeable,"itemUpgradeablePickaxe");
		itemUpgradeableAxe = new ItemUpgradeableAxe(upgradeable,"itemUpgradeableAxe");
		itemUpgradeableHoe = new ItemUpgradeableHoe(upgradeable,"itemUpgradeableHoe");
		itemUpgradeableShovel = new ItemUpgradeableShovel(upgradeable,"itemUpgradeableShovel");
		itemUpgradeableSword = new ItemUpgradeableSword(upgradeable,"itemUpgradeableSword");
	}
	
	
	public static void init(){
		
		
		Items.add(itemNoteBook);
		Items.add(itemComponent);
		Items.add(itemIngot);
		
		Items.add(itemUpgradeablePickaxe);
		Items.add(itemUpgradeableAxe);
		Items.add(itemUpgradeableHoe);
		Items.add(itemUpgradeableShovel);
		Items.add(itemUpgradeableSword);
		
	}
	
	
}
