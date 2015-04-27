package net.polotecnologio.java.threads.exercise;

public class HilosTest {

	public static void main(String[] args) {
		
		System.out.println("Inicio Main Thread");
		
		Hilo01 h1 = new Hilo01();
		
		Hilo02 h2 = new Hilo02();
		
		h1.start();
		
		h2.start();
		
		System.out.println("Fin de Main Thread");
		
	}
	
}
