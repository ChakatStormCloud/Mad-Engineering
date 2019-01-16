package com.chakatstormcloud.madengineering.gui;

import com.chakatstormcloud.madengineering.MadEngineering;
import com.chakatstormcloud.madengineering.block.container.ContainerEngineerDesk;
import com.chakatstormcloud.madengineering.block.tileentity.TileEngineerDesk;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEngineerDesk extends GuiContainer {
	
	private TileEngineerDesk tileentity;
	private IInventory playerInv;
	
	public GuiEngineerDesk(IInventory playerInv, TileEngineerDesk te) {
		super(new ContainerEngineerDesk(playerInv, te));
		
		this.xSize = 176;
		this.ySize = 195;
		
		this.tileentity = te;
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(MadEngineering.MODID, "textures/gui/container/EngineerDesk_workspace.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
	}

}
