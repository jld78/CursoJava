package net.polotecnologio.java.threads;

public class HiloDec extends Thread{

	private Contador cont;
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			cont.dec();	
		}
		
	}

	public void setCont(Contador c) {
		this.cont = c;
	}
	
	
}
