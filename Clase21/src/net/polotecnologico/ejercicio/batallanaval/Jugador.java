package net.polotecnologico.ejercicio.batallanaval;

import java.util.ArrayList;

public abstract class Jugador {


	private Tablero tablero;
	private Tablero tableroControl;
	private int casillas;
	
	private int disparoFila;
	private int disparoColumna;
	private Boolean disparado = false;

	public Jugador(int casillasEmbarc) {
		this.tablero = new Tablero();
		this.tableroControl = new Tablero();
		this.casillas = casillasEmbarc;
	}
	
	public Boolean getDisparado() {
		return disparado;
	}
	
	public void setDisparado(Boolean disparado) {
		this.disparado = disparado;
	}

	public int getDisparoFila() {
		return disparoFila;
	}
	
	public void setDisparoFila(int disparoFila) {
		this.disparoFila = disparoFila;
	}
	
	public int getDisparoColumna() {
		return disparoColumna;
	}
	
	public void setDisparoColumna(int disparoColumna) {
		this.disparoColumna = disparoColumna;
	}
	
	/**
	 * Agrega un casillero como una nave o parte de ella
	 * si distinguir, siempre y cuando el estado del juego
	 *  sea jugando.
	 * 
	 * @param fila
	 * @param columna
	 * @return
	 */
	public boolean agregarEmbarcacion(int fila, int columna){
		if (!Juego.jugando) {
			if (fila < tablero.getFilas() && columna < tablero.getColumnas() && casillas > 0) {
				casillas--;
				tablero.setPosicion(fila, columna, Estado.Activo);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerEmbarcacion(int fila, int columna){
		if (!Juego.jugando) {
			if (fila < tablero.getFilas() && columna < tablero.getColumnas() && casillas > 0) {
				casillas++;
				tablero.setPosicion(fila, columna, Estado.Agua);
				return true;
			}
		}
		return false;
	}


	/**
	 * Verifica el estado del casillero objetivo,
	 * en caso de estar activo verifica si la nave
	 *  fue averiada o hundida. Luego verifica que existan 
	 *   casilleros activos o todos estan hundidos.
	 * 
	 * @param fila
	 * @param columna
	 * @return
	 */
	public Estado recibirDisparo(int fila, int columna) {
		Estado estado = tablero.getPosicion(fila, columna);
		switch (estado) {
		case Activo:
			estado = comprobarEmbarcacion(fila, columna);
			tablero.setPosicion(fila, columna, estado);
			if(tablero.juegoTerminado()){
				estado = Estado.Derrotado;
			}
			break;
		case Agua:
			estado = Estado.Agua;
			break;
		default:
			
		}
		disparado = true;
		return estado;
	}
	
	/**
	 * Registra en el tablero de control
	 *  el resultado del disparo previo 
	 * 
	 * @param estado
	 */
	public void registrarDisparo(Estado estado){
		tableroControl.setPosicion(this.disparoFila, this.disparoColumna, estado);
	}

	/**
	 * Comprueba si la nave fue hundida (todos los casilleros contiguos
	 *  estan averiados) o averiada (al menos un casillero contiguo esta activo)
	 * 
	 * @param fila
	 * @param columna
	 * @return
	 */
	private Estado comprobarEmbarcacion(int fila, int columna) {
		boolean hundido = true;
		ArrayList<String> embarcacion = new ArrayList<>();

		while(fila < 9 && (tablero.getPosicion(fila, columna) == Estado.Activo || tablero.getPosicion(fila, columna) == Estado.Averiado)){
			Estado estado = tablero.getPosicion(fila++, columna);
			if(estado == Estado.Activo){
				hundido = false;
			}else{
				embarcacion.add(fila + "-" + columna);
			}
		}

		while(fila > 0 && (tablero.getPosicion(fila, columna) == Estado.Activo || tablero.getPosicion(fila, columna) == Estado.Averiado)){
			Estado estado = tablero.getPosicion(fila--, columna);
			if(estado == Estado.Activo){
				hundido = false;
			}else{
				embarcacion.add(fila + "-" + columna);
			}
		}

		while(columna < 9 && (tablero.getPosicion(fila, columna) == Estado.Activo || tablero.getPosicion(fila, columna) == Estado.Averiado)){
			Estado estado = tablero.getPosicion(fila, columna++);
			if(estado == Estado.Activo){
				hundido = false;
			}else{
				embarcacion.add(fila + "-" + columna);
			}
		}

		while(columna > 0 && (tablero.getPosicion(fila, columna) == Estado.Activo || tablero.getPosicion(fila, columna) == Estado.Averiado)){
			Estado estado = tablero.getPosicion(fila, columna--);
			if(estado == Estado.Activo){
				hundido = false;
			}else{
				embarcacion.add(fila + "-" + columna);
			}
		}


		if(hundido){
			hundirEmbarcacion(embarcacion);
			return Estado.Hundido;
		}
		return Estado.Averiado;
	}
	
	/**
	 * Si todas las partes de la nave estan 
	 *  averiadas cambia su estado a hundida
	 * 
	 * @param embarcacion
	 */
	private void hundirEmbarcacion(ArrayList<String> embarcacion){
		for (String string : embarcacion) {
			int fila = Integer.valueOf(string.substring(0, string.indexOf("-")-1));
			int columna = Integer.valueOf(string.substring(string.indexOf("-")+1,string.length()));
			tablero.setPosicion(fila, columna, Estado.Hundido);
		}
	}
	
	public abstract Estado disparar(Jugador oponente);
	
}
