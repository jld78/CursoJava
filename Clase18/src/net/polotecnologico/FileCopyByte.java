package net.polotecnologico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyByte {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("archivo.txt");
			FileOutputStream fos = null;
			try{
			 
				fos = new FileOutputStream("destino.txt");
			
				int caracter;
				while((caracter = fis.read()) != -1){
					fos.write(caracter);
				}
				
			}finally{
				if(fos != null){
					fos.close();
				}
				fis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
