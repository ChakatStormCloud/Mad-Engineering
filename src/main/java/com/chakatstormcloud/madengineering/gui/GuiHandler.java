package com.chakatstormcloud.madengineering.gui;

import com.chakatstormcloud.madengineering.block.container.ContainerEngineerDesk;
import com.chakatstormcloud.madengineering.block.tileentity.TileEngineerDesk;
import com.chakatstormcloud.madengineering.block.tileentity.TileSyngasGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public static final int ENGINEERDESK_WORKSPACE = 0;
	public static final int SYNGAS_GENERATOR = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case ENGINEERDESK_WORKSPACE:
			return new ContainerEngineerDesk(player.inventory, (TileEngineerDesk) world.getTileEntity(new BlockPos(x,y,z)));
		case SYNGAS_GENERATOR:
			//return new ContainerSyngasGenerator();
		}
		
		
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case ENGINEERDESK_WORKSPACE:
			return new GuiEngineerDesk(player.inventory, (TileEngineerDesk) world.getTileEntity(new BlockPos(x,y,z)));
		case SYNGAS_GENERATOR:
			return new GuiSyngasGenerator(player.inventory, (TileSyngasGenerator) world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}

}
