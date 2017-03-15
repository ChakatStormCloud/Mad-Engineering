package StormCloud.madengineering;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = MadEngineering.MODID, name = MadEngineering.MODNAME,
				version = MadEngineering.MODVERSION, acceptedMinecraftVersions = MadEngineering.MCVERSION)
public class MadEngineering {
	
	public static final String MODID = "madengineering";
	public static final String MODNAME = "Mad Engineering";
	public static final String MODVERSION = "0.1.1";
	public static final String MCVERSION = "1.10.2";
	
	@Mod.Instance(MODID)
	public static MadEngineering instance;
	
}
