package net.polotecnologico.ejercicio.batallanaval;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	private boolean jugando = false;
	
	public Juego() {
		Jugador jugador1 = new JugadorHumano();
		Jugador jugador2 = new JugadorHumano();
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}
	
	public Jugador getJugador2() {
		return jugador2;
	}
	
	public boolean isJugando() {
		return jugando;
	}
	
	public void setJugando(boolean jugando) {
		this.jugando = jugando;
	}
	
	public boolean agregarEmbarcacion(int fila, int columna, Jugador jugador){
		if(!jugando){
			return jugador.addEmbarcacion(fila, columna);
		}else{
			return false;
		}
	}
	
	public Estado disparar(int fila, int columna, Jugador jugador){
		
	}
}
