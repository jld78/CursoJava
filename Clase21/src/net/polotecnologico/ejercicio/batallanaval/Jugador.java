package net.polotecnologico.ejercicio.batallanaval;

import java.util.ArrayList;

public class Jugador {


	Tablero tablero;
	Tablero tableroControl;

	public Jugador() {
		this.tablero = new Tablero();
		this.tableroControl = new Tablero();
	}
	
	public boolean addEmbarcacion(int fila, int columna){
		if(fila < tablero.getFilas() && columna < tablero.getColumnas()){
			tablero.setPosicion(fila, columna, Estado.Activo);
		}
		return false;
		
	}

	public Estado disparar(int fila, int columna, Jugador jugador) {
		return jugador.recibirDisparo(fila, columna);
	}

	private Estado recibirDisparo(int fila, int columna) {
		Estado estado = tablero.getPosicion(fila, columna);
		switch (estado) {
		case Activo:
			estado = comprobarEmbarcacion(fila, columna);
			tablero.setPosicion(fila, columna, estado);
			return estado;
		case Agua:
			return Estado.Agua;
		default:
			return estado;
		}
	}

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
	
	private void hundirEmbarcacion(ArrayList<String> embarcacion){
		for (String string : embarcacion) {
			int fila = Integer.valueOf(string.substring(0, string.indexOf("-")-1));
			int columna = Integer.valueOf(string.substring(string.indexOf("-")+1,string.length()));
			tablero.setPosicion(fila, columna, Estado.Hundido);
		}
	}
}
