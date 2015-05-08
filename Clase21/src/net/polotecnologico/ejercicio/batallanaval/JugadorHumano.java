package net.polotecnologico.ejercicio.batallanaval;

public class JugadorHumano extends Jugador {

	public JugadorHumano(int casillasEmbarc) {
		super(casillasEmbarc);
	}

	@Override
	public Estado disparar(Jugador oponente) {
		Estado estado = oponente.recibirDisparo(getDisparoFila(), getDisparoColumna()); 
		return estado;
	}

	
	
}
