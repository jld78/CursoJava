package net.polotecnologico.ordenable;

public class Ordenador {

	public static Ordenable[] ordenar(Ordenable[] ord){
		// Array para guardar objetos ordenados
		Ordenable temp;
		for(int j=0; j <= ord.length; j++){
			for(int i=0; i < ord.length-1; i++){
				int resultado = ord[i].compareTo(ord[i+1]);
				if(resultado > 0){
					temp=ord[i+1];
					ord[i+1] = ord[i];
					ord[i] = temp;
				}
			}
		}
		return ord;
	}
	
}
