package net.polotecnologico.ejercicio.hilos;

public class Pila {

	private char [] elementos;
	
	private int indice;
	
	private static final int MAX = 10;
	
	public Pila () {
		elementos = new char[MAX];
	}
	
	public Pila (int cant) {
		elementos = new char[cant];
	}
	
	public synchronized void poner (char c) {
		while(indice == elementos.length){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		elementos[indice++] = c;
		notifyAll();	
		
	}
	
	public synchronized char sacar () {
		while (indice == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		char c = elementos[--indice];
		notifyAll();
		return c;
	}
	
	public int size () {
		return indice;
	}

}
