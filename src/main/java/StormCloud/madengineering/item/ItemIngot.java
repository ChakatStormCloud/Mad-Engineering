package StormCloud.madengineering.item;

import java.util.List;

import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.backend.handlers.Enumnums.IngotTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemIngot extends Item{
	
	public ItemIngot(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, unlocalizedName));
		this.setHasSubtypes(true);
		
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		for(int i = 0; i < IngotTypes.values().length;i++){
			subItems.add(new  ItemStack(itemIn,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() < IngotTypes.values().length){
			return this.getUnlocalizedName() + "." + IngotTypes.values()[stack.getItemDamage()].getName();
		}else{
			return this.getUnlocalizedName() + "." + IngotTypes.COPPER.getName();
		}
	}
	
}
