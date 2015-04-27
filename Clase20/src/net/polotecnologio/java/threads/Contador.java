package net.polotecnologio.java.threads;

public class Contador {

	private int cont;
	
	public int getCont() {
		return cont;
	}
	
	public synchronized void inc(){
		cont++;
	}
	
	public synchronized void dec(){
		cont--;
	}
	
}
