package net.polotecnologico.ejercicio.batallanaval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class JuegoThread extends Thread{
	
	private Socket socket = null;
	private Jugador jugador = null;
	private Jugador oponente = null;
	
	public JuegoThread(Socket socket, Jugador jugador, Jugador oponente) {
		super("ServidorBatallaThread");
		this.socket = socket;
		this.jugador = jugador;
		this.oponente = oponente;
	}
	
	@Override
	public void run() {
		
		if(jugador instanceof JugadorHumano){
		try(	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				){
			
			String input;
			
			while((input = in.readLine()) != "Terminar juego"){
				if(input != null){
					out.println(procesarInput(input));
				}
			}
			Juego.jugando = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			while(Juego.jugando){
				if((Juego.turno == jugador) && jugador.getDisparado()){
					jugador.setDisparado(false);
					jugador.disparar(oponente);
				}
			}
		}
		
	}
	
	private String procesarInput(String input) {
		if (Juego.turno == jugador) {
			Estado estado = null;
			if (input.contains("Disparar")) {
				int fila = Integer.valueOf(input.substring(
						input.indexOf("FILA") + 3, input.indexOf("FILA") + 5));
				int columna = Integer.valueOf(input.substring(
						input.indexOf("COL") + 2, input.indexOf("FILA") + 4));
				estado = oponente.recibirDisparo(fila, columna);
				return estado.toString();
			}else if(input.contains("AgregarEmb")){
				int fila = Integer.valueOf(input.substring(
						input.indexOf("FILA") + 3, input.indexOf("FILA") + 5));
				int columna = Integer.valueOf(input.substring(
						input.indexOf("COL") + 2, input.indexOf("FILA") + 4));
				if(jugador.agregarEmbarcacion(fila, columna)){
					return "Embarcacion agregada";
				}
					return "No se puede agregar la embarcacion";
				}
			}else if(input.contains("Jugar")){
				Juego.turno = jugador;
				Juego.jugando = true;
				return "Jugando";
			}
		return "No es su turno";
	}
	
}
