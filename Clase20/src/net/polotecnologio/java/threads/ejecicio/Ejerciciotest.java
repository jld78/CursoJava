package net.polotecnologio.java.threads.ejecicio;

public class Ejerciciotest {

	public static void main(String[] args) {
		
		Pila pila = new Pila();
		
		HiloProductor hp1 = new HiloProductor(pila);
		HiloProductor hp2 = new HiloProductor(pila);
		
		HilosConsumidor hc1 = new HilosConsumidor(pila);
		HilosConsumidor hc2 = new HilosConsumidor(pila);
		
		hp1.start();
		hp2.start();
		
		hc1.start();
		hc2.start();
		
	}
	
}
