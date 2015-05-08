package net.polotecnologico.ejercicio.batallanaval;

import java.io.IOException;
import java.net.ServerSocket;

public class Juego {
	
	private static final int DEFAULT_CASILLASEMB = 20;
	private static final int MAX_CONN = 2;
	
	static boolean jugando = false;
	static Jugador turno;
	
	public static void main(String[] args) {

		try (ServerSocket servidor = new ServerSocket(4444)) {

			int conexiones = 0;
			Jugador jugador1 = new JugadorHumano(DEFAULT_CASILLASEMB);
			Jugador  jugador2 = new JugadorMaquina(DEFAULT_CASILLASEMB);
			while (conexiones < MAX_CONN) {
				if (conexiones == 0) {
					new JuegoThread(servidor.accept(),
							jugador1, jugador2).start();
				} else {
					new JuegoThread(servidor.accept(), 
							jugador2, jugador1).start();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
