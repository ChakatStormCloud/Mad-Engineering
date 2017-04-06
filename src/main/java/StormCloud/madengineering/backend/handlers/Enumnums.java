package StormCloud.madengineering.backend.handlers;

import net.minecraft.util.IStringSerializable;

public class Enumnums {
	//Forgive me, I had to X3
	public interface IMetaEnum{
		public int getMeta();
		public String getName();
	}
	
	public static enum EngineerDeskTypes  implements IStringSerializable, IMetaEnum{
		DESK(0,"desk"),
		WORKSPACE(1,"workspace");
		
		private int ID;
		private String name;
		
		private EngineerDeskTypes(int ID,String name){
			this.ID = ID;
			this.name = name;
		}
		
		public int getMeta(){
			return ID;
		}
		
		public String getName(){
			return name;
		}
	}
	
	public static enum ComponentTypes implements IStringSerializable, IMetaEnum{
		IRON_SHEET(0),
		IRON_GEAR(1), //these are just placeholder for now.
		IRON_WIRE(2),
		BROKEN(3);
		
		private int ID;
		
		private ComponentTypes(int ID){
			this.ID = ID;
		}
		
		public String getName() {
			return toString();
		}
		
		public int getMeta(){
			return ID;
		}
		
		
		
	}
}
