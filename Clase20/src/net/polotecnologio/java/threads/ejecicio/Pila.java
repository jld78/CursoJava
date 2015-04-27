package net.polotecnologio.java.threads.ejecicio;

public class Pila {

	String[] pila;
	
	public Pila() {
		pila = new String[10];
	}
	
	
	public String[] getPila() {
		return pila;
	}
	
	
	public boolean poner(String s){
		for(int i=0; i<pila.length; i++){
			if(pila[i]==null){
				pila[i] = s;
				return true;
			}
		}
		return false;
	}
	
	public String sacar(){
		for(int i=pila.length-1; i >= 0; i--){
			if(pila[i]!=null){
				String s = pila[i];
				pila[i] = null;
				return s;
			}
		}
		
		return null;
	}
	
}
