package StormCloud.madengineering.item;

import java.util.List;

import StormCloud.madengineering.MadEngineering;
import StormCloud.madengineering.backend.handlers.Enumnums.ComponentTypes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemComponent extends Item {
	
	
	public ItemComponent(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID,unlocalizedName));
		this.setHasSubtypes(true);
	}
	
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		for(int i = 0; i < ComponentTypes.values().length;i++){
			subItems.add(new  ItemStack(itemIn,1,i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getItemDamage() < ComponentTypes.values().length){
			return this.getUnlocalizedName() + "." + ComponentTypes.values()[stack.getItemDamage()].getName();
		}else{
			return this.getUnlocalizedName() + "." + ComponentTypes.BROKEN.getName();
		}
	}
	
}
