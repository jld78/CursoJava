package net.polotecnologico.ejercicio.batallanaval;

public class Tablero {
	
	private static final int DEFAULT_VALUE = 10;
	private int filas = DEFAULT_VALUE;
	private int columnas = DEFAULT_VALUE;
	private Estado[][] matriztablero;

	public Tablero() {
		matriztablero = new Estado[10][10];
		inicializarTablero();
	}
	
	public int getFilas() {
		return filas;
	}
	
	public int getColumnas() {
		return columnas;
	}
	
	public Estado getPosicion(int fila, int col){
		return matriztablero[fila][col];
	}
	
	public void setPosicion(int fila, int col, Estado estado){
		matriztablero[fila][col] = estado;
	}
	
	private void inicializarTablero(){
		for (Estado[] estados : matriztablero) {
			for (Estado estado : estados) {
				estado = Estado.Agua;
			}
		}
	}
	
}
