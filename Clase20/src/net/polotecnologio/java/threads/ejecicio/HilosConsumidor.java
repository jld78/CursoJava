package net.polotecnologio.java.threads.ejecicio;

public class HilosConsumidor extends Thread{
	
	Pila pilaLocal;
	
	public HilosConsumidor(Pila pila) {
		this.pilaLocal = pila; 
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			String s = pilaLocal.sacar();
			if(s != null){
				System.out.println("Sacando " + s);
			} else {
				System.out.println("No hay más elementos en la pila");
			}
		}
		
		try {
			Thread.sleep(generarMilis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int generarMilis(){
		
		int milis = (int)(Math.random()*60000+20000);
		
		System.out.println("Tiempo " + milis + " miliseg");
		
		return milis;
	}

}
