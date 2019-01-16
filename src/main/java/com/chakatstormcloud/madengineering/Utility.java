package com.chakatstormcloud.madengineering;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utility {
	
	
	private static Logger Logger;
	
	public static Logger getLogger(){
		if(Logger == null){
			Logger=LogManager.getFormatterLogger(MadEngineering.MODID);
		}
		return Logger;
	}
}
