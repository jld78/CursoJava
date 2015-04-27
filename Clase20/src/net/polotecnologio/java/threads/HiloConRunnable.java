package net.polotecnologio.java.threads;

public class HiloConRunnable implements Runnable {

	@Override
	public void run() {
		
		for (int i = 0; i < 50; i++) {
			System.out.println("Me voy a dormir 5seg");
			try {
				Thread.sleep(5000);
				System.out.println("Que buena siesta");
			} catch (InterruptedException e) {
				System.out.println("Uy me despertaron...");;
			}
		}

	}

}
