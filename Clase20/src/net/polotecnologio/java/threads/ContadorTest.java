package net.polotecnologio.java.threads;

public class ContadorTest {

	public static void main(String[] args) {
		
		Contador c = new Contador();
		
		HiloInc h1 = new HiloInc(c);
		HiloDec h2 = new HiloDec();
		h2.setCont(c);
		
		h1.start();
		h2.start();
		
		try{
			h1.join();
			h2.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println(c.getCont());
	}

}
