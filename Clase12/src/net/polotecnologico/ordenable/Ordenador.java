package net.polotecnologico.ordenable;

public class Ordenador {

	private Ordenador() {
		// TODO Auto-generated constructor stub
	}
	
	public static Ordenable[] ordenar(Ordenable[] ord){
		// Array para guardar objetos ordenados
		Ordenable temp;
		for(int j=0; j <= ord.length-1; j++){
			for(int i=0; i+1 < ord.length; i++){
				int resultado = ord[j].compareTo(ord[i]);
				if(resultado > 0){
					temp=ord[i];
					ord[i] = ord[j];
					ord[j] = temp;
				}
			}
		}
		return ord;
	}
	
}
