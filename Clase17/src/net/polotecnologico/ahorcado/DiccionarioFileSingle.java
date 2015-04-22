package net.polotecnologico.ahorcado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DiccionarioFileSingle implements Diccionario {

	private int tamañoDiccionario;
	int nroLinea;
	boolean cargando;
	
	public DiccionarioFileSingle() {
		cargando = true;
		cargarDiccionario();
		cargando = false;
	}
	
	@Override
	public String getPalabra() {
		nroLinea = (int) (Math.random()*tamañoDiccionario);
		return cargarDiccionario();
	}
	
	private String cargarDiccionario(){
		try {
			int contador = 0;
			BufferedReader br = new BufferedReader( new FileReader("diccionario.txt"));
		
			try{
				
				String linea;
				while((linea = br.readLine()) != null){
					if(cargando){
						tamañoDiccionario++;
					}else{
						if(contador == nroLinea){
							return linea;
						}
						contador++;
					}
				}
				
			}finally{
				br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
