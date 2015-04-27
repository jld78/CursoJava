package net.polotecnologio.java.threads;

public class HiloDescarga extends Thread{

	@Override
	public void run() {
		System.out.println("Descargando...");
		try{
			Thread.sleep(2000);
			System.out.println("Finalzando la descarga");
		} catch(InterruptedException e) {
			
		}
		
	}
	
}
