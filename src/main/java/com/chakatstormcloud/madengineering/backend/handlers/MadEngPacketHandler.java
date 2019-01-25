
package com.chakatstormcloud.madengineering.backend.handlers;

import com.chakatstormcloud.madengineering.MadEngineering;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class MadEngPacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(MadEngineering.MODID);
	
	
	
}
