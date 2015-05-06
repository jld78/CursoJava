package net.polotecnologico.ejercicio.batallanaval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorBatallaThread extends Thread{
	
	private Socket socket = null;
	private Juego juego = null;
	private Jugador jugador = null;
	private Jugador oponente = null;
	
	public ServidorBatallaThread(Socket socket, Juego juego, Jugador jugador, Jugador oponente) {
		super("ServidorBatallaThread");
		this.socket = socket;
		this.juego = juego;
		this.jugador = jugador;
		this.oponente = oponente;
	}
	
	@Override
	public void run() {
		
		try(
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				){
			
			String input, output;
			
			while((input = in.readLine()) != null || juego.getActualizar() != jugador){
				if(input != null){
					out.println(procesarInput(input));
				}else if(juego.getActualizar() == jugador){
					out.println();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String procesarInput(String input){
		Estado estado = null;
		if(input.contains("Disparar")){
			int fila = Integer.valueOf(input.substring(input.indexOf("FILA")+3, input.indexOf("FILA")+5));
			int columna = Integer.valueOf(input.substring(input.indexOf("COL")+2, input.indexOf("FILA")+4));
			estado = jugador.disparar(fila, columna, oponente);
		}
		return estado.toString();
	}
	
}
