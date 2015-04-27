package net.polotecnologico.ejercicio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileUtils {

	public static ArrayList<String> getUnidades() {
		
		ArrayList<String> unidades = new ArrayList<>();

		File[] roots = File.listRoots();

		for (File file : roots) {
			unidades.add(file.getAbsolutePath());
		}
		
		return unidades;
	}
	
	public static ArrayList<String> buscarArchivos(String unidad, final String archivo){
		
		ArrayList<String> archivos = new ArrayList<>();
		
		File dirRoot = new File(unidad);
		
		File [] files = dirRoot.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				String expresion = archivo.replace("*", ".*").replace("?", ".");
				return name.matches(expresion);
			}
		});
		
		if(files != null){
			for (File file : files) {
				archivos.add(file.getAbsolutePath());
			}
		
			files = dirRoot.listFiles();
		
			for (File file : files) {
				if(file.isDirectory()){
					archivos.addAll(buscarArchivos(file.getAbsolutePath(), archivo));
					System.out.println("Llamando");
				}
			}
		}
		
		for (String res : archivos) {
			System.out.println(res);
		}
		
		return archivos;
	}
}
