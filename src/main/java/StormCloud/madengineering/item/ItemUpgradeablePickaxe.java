package StormCloud.madengineering.item;

import StormCloud.madengineering.MadEngineering;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

public class ItemUpgradeablePickaxe extends ItemPickaxe{
	
	
	protected ItemUpgradeablePickaxe(ToolMaterial material, String unlocalizedName){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, unlocalizedName));
		
	}
}
