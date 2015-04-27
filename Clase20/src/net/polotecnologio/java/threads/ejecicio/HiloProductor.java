package net.polotecnologio.java.threads.ejecicio;

public class HiloProductor extends Thread{

	Pila pilaLocal;
	
	public HiloProductor(Pila pila) {
		this.pilaLocal = pila;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<200; i++){
			if(!pilaLocal.poner(producirCaracter())){
				System.out.println("Error al poner en la pila");
			};
		}
		
		try {
			Thread.sleep(generarMilis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String producirCaracter(){
		
		String s = String.valueOf((char)((Math.random()*27) + 65));
		System.out.println("Caracter generado " + s);
		return s;

	}
	
	private int generarMilis(){
		
		int milis = (int)(Math.random()*60000+20000);
		
		System.out.println("Tiempo " + milis + " miliseg");
		
		return milis;
	}
	
}
