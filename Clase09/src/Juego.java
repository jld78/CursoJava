
public class Juego {
	
	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		
		Carta carta1 = mazo.cartaAlAzar();
		Carta carta2 = mazo.cartaAlAzar();
		
		if(carta1 != null && carta2 != null){
			if(carta1.getValor() == carta2.getValor()){
				System.out.println("Empate");
			} else if(carta1.getValor() > carta2.getValor()){
				System.out.println("Gano Jugador 1");
			}
		} else {
			System.out.println("No hay más cartas");
			return;
		}
			System.out.println("Gano Jugador 2");
	}

}
