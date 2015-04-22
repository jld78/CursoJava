package net.polotecnologico.ahorcado;

import java.util.ArrayList;

public class DiccionarioArray implements Diccionario {

	private ArrayList<String> diccionario;
	
	public DiccionarioArray() {
		diccionario = new ArrayList<>();
		diccionario.add("Palabra");
		diccionario.add("Diccionario");
		diccionario.add("Polo");
		diccionario.add("Linux");
	}
	
	@Override
	public String getPalabra() {
		int indice = (int) (Math.random()*diccionario.size());
		return diccionario.get(indice);
	}

}
