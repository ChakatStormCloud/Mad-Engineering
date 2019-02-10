package com.chakatstormcloud.madengineering.backend.handlers;

import net.minecraft.util.IStringSerializable;

public class Enumnums {
	//Forgive me, I had to X3
	public interface IMetaEnum{
		public int getMeta();
		
		public String getName();
		
		public static int[] getshit() {
			return null;
		}
	}
	
	public static enum EngineerDeskTypes implements IStringSerializable, IMetaEnum{
		DESK(0,"desk"),
		WORKSPACE(1,"workspace");
		
		private int ID;
		private String name;
		
		private EngineerDeskTypes(int ID,String name){
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public int getMeta(){
			return ID;
		}
		
		@Override
		public String getName(){
			return name;
		}
		
		public static int[] getshit() {
			return null;

		}
	}
	
	
	public static enum ComponentTypes implements IStringSerializable, IMetaEnum{
		ANGLE_IRON("angle_iron",0),
		COPPER_TUBE("copper_tube",1),
		PISTON("piston",2);
		
		private int ID;
		private String name;
		
		private ComponentTypes(String s,int a){
			this.name = s;
			this.ID = a;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public int getMeta(){
			return ID;
		}
	}
	
	public static enum OreTypes implements IStringSerializable, IMetaEnum{
		COPPER("copper",0),
		NICKEL("nickel",1),
		CHROME("chrome",2),
		TUNGSTEN("tungsten",3);
		
		private int ID;
		private String name;
		
		private OreTypes(String s, int a){
			this.name = s;
			this.ID = a;
		}
		
		@Override
		public int getMeta() {
			return ID;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
	}
	
	public static enum IngotTypes implements IStringSerializable, IMetaEnum{
		COPPER("copper",0),
		NICKEL("nickel",1),
		CHROME("chrome",2),
		TUNGSTEN("tungsten",3),
		MOLYBDENUM("molybdenum",4),
		COBALT("cobalt",5);
		
		private String name;
		private int ID;
		
		private IngotTypes(String s, int a) {
			this.name = s;
			this.ID = a;
		}
		
		@Override
		public int getMeta() {
			return ID;
		}
		
		@Override
		public String getName() {
			return name;
		}
	}
	public static enum DustTypes implements IStringSerializable, IMetaEnum{
		COPPER("copper",0),
		NICKEL("nickel",1),
		CHROME("chrome",2),
		TUNGSTEN("tungsten",3),
		MOLYBDENUM("molybdenum",4),
		COBALT("cobalt",5),
		VANADIUM("vanadium",6),
		MANGANESE("manganese",7),
		NEODYMIUM("neodymium",8);
		
		private String name;
		private int ID;
		
		private DustTypes(String s, int a) {
			this.name = s;
			this.ID = a;
		}
		
		@Override
		public int getMeta() {
			return ID;
		}
		
		@Override
		public String getName() {
			return name;
		}
	}
}
