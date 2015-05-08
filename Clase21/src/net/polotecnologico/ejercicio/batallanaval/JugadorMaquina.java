package net.polotecnologico.ejercicio.batallanaval;

public class JugadorMaquina extends Jugador {
	
	public JugadorMaquina(int casillasEmbarc) {
		super(casillasEmbarc);
	}

	@Override
	public Estado disparar(Jugador oponente) {
		int filaRespuesta = (int)Math.random() * 10;
		int columnaRespuesta = (int)Math.random() * 10;
		
		setDisparoFila(filaRespuesta);
		setDisparoColumna(columnaRespuesta);
		Estado estado = oponente.recibirDisparo(filaRespuesta, columnaRespuesta);

		return estado;
	}
	
}
