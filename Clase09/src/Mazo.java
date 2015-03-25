
public class Mazo {
	
	public Mazo() {
		generarMazo();
	}
	
	private Carta[] cartas = new Carta[48];
	
	public Carta[] getCartas() {
		return cartas;
	}
	
	private void generarMazo(){
		for(int i = 0; i < 12; i++){
			cartas[i] = new Carta(i+1, Palo.ESPADA);
			cartas[i+12] = new Carta(i+1, Palo.BASTO);
			cartas[i+24] = new Carta(i+1, Palo.ORO);
			cartas[i+36] = new Carta(i+1, Palo.COPA);
		};
	}
	
	
	public Carta cartaAlAzar(){
		Carta carta; 
		int nro = 0;
		while(nro<0 && nro>47 && cartas[nro]==null){
			nro = (int) Math.random() * 10;
		}
		carta = cartas[nro];
		cartas[nro] = null;
		return carta;
	}
	
}
