package assets.madengineering;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class assetbuilder {
	
	private static ArrayList<String> metas = new ArrayList<String>();
	
	private static String name;
	
	private static boolean block = false;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i =0;i<args.length;i++) {
			String s = args[i];
			if(s.startsWith("-") ) {
				switch(s.charAt(1)) {
				case 'b':
					block = true;
					break;
				case 'i':
					block = false;
					break;
				case 'n':
					name = args[1+i];i++;
					break;
				} 
			}else {
				metas.add(s);
			}
		}
		doMain();
	}
	
	
	private static void doMain() throws IOException {
		for(String m:metas) {
			if(block) {
				File n= new File("models/block/"+name+"_"+m+".json");
				makeBlockModelFile(n, m, name);
				
				n= new File("models/item/"+name+"_"+m+".json");
				makeBlockItemFile(n, m, name);
				
			}else {
				File n = new File("models/item/"+name+"_"+m+".json");
				makeItemFile(n, m, name);
				
			}
		}
		
		if(block) {
			File n = new File("blockstates/"+name+".json");
			n.createNewFile();
			PrintWriter pw = new PrintWriter(n);
			pw.print(
				"{\r\n" + 
				"	\"variants\": {\r\n");
			for(String m:metas) {
				pw.print("		\"type="+m+"\": {\"model\": \"madengineering:"+name+"_"+m+"\"},\r\n");
			}
			pw.println(
				"	}\r\n" + 
				"}\r\n" + 
				"");
			pw.close();
			
		}
	}


	private static void makeItemFile(File file, String meta, String name) throws IOException {
		
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		
		pw.println(
				
				"{\r\n" + 
				"	\"parent\": \"item/generated\",\r\n" + 
				"	\"textures\": {\r\n" + 
				"		\"layer0\": \"madengineering:items/"+name+"_"+meta+"\"\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"");
		pw.close();
		
	}
	
	private static void makeBlockModelFile(File file, String meta, String name) throws IOException {
		
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		
		pw.println(
				
				"{\r\n" + 
				"	\"parent\": \"block/cube_all\",\r\n" + 
				"	\"textures\": {\r\n" + 
				"		\"all\": \"madengineering:blocks/"+name+"_"+meta+"\"\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"");
		pw.close();
		
	}
	
	private static void makeBlockItemFile(File file, String meta, String name) throws IOException {
		
		file.createNewFile();
		PrintWriter pw = new PrintWriter(file);
		
		pw.println(
				
				"{\r\n" + 
				"	\"parent\": \"madengineering:block/"+name+"_"+meta+"\"\r\n" + 
				"}\r\n" + 
				"");
		pw.close();
		
	}
	
	

}
