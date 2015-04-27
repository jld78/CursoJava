package net.polotecnologio.java.threads;

public class HiloInc extends Thread{

	private Contador cont;
	
	public HiloInc(Contador c) {
		this.cont = c;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			cont.inc();	
		}
		
	}
	
}
