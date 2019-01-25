package com.chakatstormcloud.madengineering.fluid;

import java.util.ArrayList;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class MadEngFluids {
	
	public static Fluid fluidSynGas;
	public static ArrayList<Fluid> Fluids = new ArrayList<Fluid>();;
	
	public static void init() {
		Fluids.add(fluidSynGas = new Fluid("fluidSynGas",
				new ResourceLocation(MadEngineering.MODID,"fluidSynGas_still"),
				new ResourceLocation(MadEngineering.MODID,"fluidSynGas_flowing")).setColor(0xFFFFFF44).setGaseous(true).setUnlocalizedName("fluidSynGas")
				.setDensity(-200).setViscosity(500));
		
		
		
	}
	
	
}
