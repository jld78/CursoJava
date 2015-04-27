package net.polotecnologio.java.threads;

public class Ejemplo02Test {

	public static void main(String[] args) {
		
		HiloConRunnable hcr = new HiloConRunnable();
//		hcr.start();
		Thread t1 = new Thread(hcr);
		t1.start();
		try{
			Thread.sleep(7000);
		}catch(InterruptedException e){
			
		}
		System.out.println("A levantarse!!!");
		t1.interrupt();

	}

}
