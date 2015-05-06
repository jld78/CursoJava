package net.polotecnologico.ejercicio.batallanaval;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorBatalla {

	private static final int MAX_CONN = 2;

	public static void main(String[] args) {
		
		int conexiones = 0;
		Juego juego = Juego.getInstance();
		
		try(ServerSocket servidor = new ServerSocket(4444)) {
			
			while(conexiones < MAX_CONN){
				if(conexiones == 0){
					new ServidorBatallaThread(servidor.accept(), juego, juego.getJugador1(), juego.getJugador2()).start();
				} else {
					new ServidorBatallaThread(servidor.accept(), juego, juego.getJugador2(), juego.getJugador1()).start();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
