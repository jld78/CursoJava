package net.polotecnologico;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBuffByte {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("archivo.txt");
			FileOutputStream fos = null;
			try{
			 
				fos = new FileOutputStream("destino.txt");
			
				int cant;
				byte [] buff = new byte[4096];
				while((cant = fis.read(buff)) != -1){
					fos.write(buff, 0, cant);
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
