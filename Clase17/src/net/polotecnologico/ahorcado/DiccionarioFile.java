package net.polotecnologico.ahorcado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DiccionarioFile implements Diccionario {

	ArrayList<String> diccionario;
	
	public DiccionarioFile() {
		cargarDiccionario();
	}
	
	@Override
	public String getPalabra() {
		int indice = (int) (Math.random()*diccionario.size());
		return diccionario.get(indice);
	}
	
	private void cargarDiccionario(){
		diccionario = new ArrayList<>();
		
		try {

			BufferedReader br = new BufferedReader( new FileReader("diccionario.txt"));
		
			try{
				
				String linea;
				while((linea = br.readLine()) != null){
					diccionario.add(linea);
				}
				
			}finally{
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
