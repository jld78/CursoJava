package net.polotecnologico.ejercicio.batallanaval;

public class Juego {
	
	private static final int DEFAULT_FILASYCOLUMNAS = 100;
	private static final int DEFAULT_CASILLASEMB = 20;

	private static Juego instance= null;
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	static int tableroFilas = DEFAULT_FILASYCOLUMNAS;
	static int tableroColumnas = DEFAULT_FILASYCOLUMNAS;
	static int casillasEmb = DEFAULT_CASILLASEMB;
	static boolean jugando = false;
	static Jugador turno;
	private Jugador actualizar;
	
	private Juego() {
		Jugador jugador1 = new JugadorHumano(casillasEmb);
		Jugador jugador2 = new JugadorHumano(casillasEmb);
		turno = jugador1;
	}
	
	public static Juego getInstance() {
		if(instance == null){
			instance = new Juego();
		}
		return instance;
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}
	
	public Jugador getJugador2() {
		return jugador2;
	}
	
	public Jugador getActualizar() {
		return actualizar;
	}
	
	public boolean isJugando() {
		return jugando;
	}
	
	public void setJugando(boolean jugando) {
		this.jugando = jugando;
	}
	
	public String disparar(int fila, int columna, Jugador origen, Jugador destino){
		
		Estado estado = origen.disparar(fila, columna, destino);
		actualizar = destino;
		
		return estado.toString();
	}
	
}
