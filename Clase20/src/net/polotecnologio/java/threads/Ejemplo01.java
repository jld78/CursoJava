package net.polotecnologio.java.threads;

public class Ejemplo01 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);;
			
		}
	}
	
}
