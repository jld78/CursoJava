package net.polotecnologico.ejercicio.hilos;

public class Consumidor extends Thread {

	private Pila pila;
	
	public Consumidor (Pila pila, String nombre) {
		super(nombre);
		this.pila = pila;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 101; i++) {
			char caracter = pila.sacar();
			try {
				int ms = (int) (Math.random() * 10) + 1;
				System.out.println(
					Thread.currentThread().getName() +
					" SACO el caracter '" + caracter +
					"' [" + ms + "ms, " + i + ", " +
					pila.size() + "]");
				Thread.sleep(ms); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin Consumidor" + Thread.currentThread().getName());
	}

}
