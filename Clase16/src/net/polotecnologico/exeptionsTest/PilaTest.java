package net.polotecnologico.exeptionsTest;

public class PilaTest {

	public static void main(String[] args) {
		
		Pila<String> pila = new Pila<>();

		
		for(int i = 0; i <= 12; i++){
			try {
				pila.poner("Cadena " + i);
			} catch (PilaLlenaException e) {
				// TODO Auto-generated catch block
				e.getMessage();
				e.printStackTrace();
			}
			System.out.println("Cadena " + i);
		}
		

		
		for(int i = 0; i <= 12; i++){
			System.out.println(pila.sacar());
		}
		
	}
	
}
