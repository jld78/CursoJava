
public class Carta {
	private int valor;
	private Palo palo;
	
	public Carta(int valor, Palo palo) {
		this.valor = valor;
		this.palo = palo;
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	public int getValor() {
		return valor;
	}
}
