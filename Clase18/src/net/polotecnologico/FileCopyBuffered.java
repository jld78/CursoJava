package net.polotecnologico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyBuffered {

	public static void main(String[] args) {
		
		try {

			BufferedReader br = new BufferedReader( new FileReader("archivo.txt"));
			
			BufferedWriter bw = null;
			try{
			 
				bw = new BufferedWriter(new FileWriter("destino.txt"));
				
				String linea;
				while((linea = br.readLine()) != null){
					bw.write(linea);
					bw.newLine();
				}
				
			}finally{
				if(bw != null){
					bw.close();
				}
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
