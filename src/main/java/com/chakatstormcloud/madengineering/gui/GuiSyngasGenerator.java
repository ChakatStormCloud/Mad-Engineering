package com.chakatstormcloud.madengineering.gui;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.block.tileentity.TileSyngasGenerator;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiSyngasGenerator extends GuiContainer {
	
	private TileSyngasGenerator tileentity;
	private IInventory playerInv;
	
	public GuiSyngasGenerator(IInventory playerInv,TileSyngasGenerator te) {
		super(new ContainerSyngasGenerator(playerInv, te));
		
		this.xSize = 176;
		this.ySize = 195;
		
		this.tileentity = te;
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(MadEngineering.MODID, "textures/gui/container/SyngasGenerator.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
	}

}
