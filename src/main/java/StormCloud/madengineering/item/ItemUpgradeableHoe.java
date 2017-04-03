package StormCloud.madengineering.item;

import StormCloud.madengineering.MadEngineering;
import net.minecraft.item.ItemHoe;
import net.minecraft.util.ResourceLocation;

public class ItemUpgradeableHoe extends ItemHoe{

	public ItemUpgradeableHoe(ToolMaterial material,String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(MadEngineering.MODID, unlocalizedName));
	}

}