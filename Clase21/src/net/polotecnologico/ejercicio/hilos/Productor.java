package net.polotecnologico.ejercicio.hilos;

public class Productor extends Thread {

	private Pila pila;
	
	public Productor (Pila pila, String nombre) {
		super(nombre);
		this.pila = pila;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 101; i++) {
			char caracter = (char)
				((int) (Math.random() * 27) + 'A');
			pila.poner(caracter);
			try {
				int ms = (int) (Math.random() * 10) + 1;
				System.out.println(
					Thread.currentThread().getName() +
					" PUSO el caracter '" + caracter +
					"' [" + ms + "ms, " + i + ", " +
					pila.size() + "]");
				Thread.sleep(ms); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin Productor" + Thread.currentThread().getName());
	}
}
