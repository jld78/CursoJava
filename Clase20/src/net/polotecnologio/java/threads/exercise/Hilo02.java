package net.polotecnologio.java.threads.exercise;

public class Hilo02 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i > (-1000000); i--) {
			System.out.println("\t " + i);
			
		}
	}
	
	
}
