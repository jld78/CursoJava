package net.polotecnologico;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException{
		
		File f1 = new File("hola.bin");
	
		if(f1.exists()){
			System.out.println("Existe");
		} else {
			System.out.println("No existe");
			f1.createNewFile();
			
			FileReader fr = new FileReader(f1);
		}
		
		File f2 = new File("chau.txt");
		
		if(!f2.exists()){
			f2.mkdirs();
		}
		
		if(f2.isDirectory()){
			System.out.println("Es un directorio");
		}
		
		if(f2.isFile()){
			System.out.println("Es un archivo");
		}
	
		File dirRoot = new File("/");
		
		
		
		File f3 = new File("/", "sopa.txt");
		
		if(dirRoot.canWrite()){
			f3.createNewFile();
		} else {
			System.out.println("No puedo escribir");
		}
		
		System.out.println(f1.length());
		
		File f4 = new File(dirRoot, "sopaAC");
		
		System.out.println(f4.getAbsolutePath());
		System.out.println(f4.getCanonicalPath());
		
		System.out.println(f4.getParent());
		System.out.println(f1.getParent());
		
		// Metodos estaticos de File
		System.out.println(File.pathSeparator);
		
		System.out.println(File.separator);
		
		System.out.println("-------------------------------------------------------------");

		File [] roots = File.listRoots();
		
		for (File file : roots) {
			System.out.println(file.getAbsolutePath());
		}
		
		System.out.println("------------------------------------------------------------");
		
		File [] cont2 = dirRoot.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith("txt");
			}
		});
		
		for (File file : cont2) {
			System.out.println(file.getAbsolutePath());
		}
		
	}
	
	

	
}