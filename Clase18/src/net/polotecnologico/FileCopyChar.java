package net.polotecnologico;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyChar {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("archivo.txt");
			FileWriter fw = null;
			try{
			 
				fw = new FileWriter("destino.txt");
			
				int caracter;
				while((caracter = fr.read()) != -1){
					fw.write(caracter);
				}
				
			}finally{
				if(fw != null){
					fw.close();
				}
				fr.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
