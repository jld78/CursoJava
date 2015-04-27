package net.polotecnologio.java.threads;

public class DescargaTest {

	public static void main(String[] args) {
		
		HiloDescarga h1 = new HiloDescarga();
		
		h1.start();
		
		System.out.println("Espero a que termine...");

		try{
			h1.join(); //h1.join(1500)
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("Buenisimo!!!");
		
		if(h1.isAlive()){
			System.out.println("Esta vivo");
		} else {
			System.out.println("Palmo");
		}

		System.out.println(h1.getName());
		
		h1.start();
		
	}

}
