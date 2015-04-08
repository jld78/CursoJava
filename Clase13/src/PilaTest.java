
public class PilaTest {

	public static void main(String[] args) {
		
		Pila pila = new Pila();
		
		Pila pila2 = new Pila();
		
		for(int i = 0; i <= 100; i++){
			pila.poner("Cadena " + i);
			pila2.poner("Cadena " + i);
			System.out.println("Cadena " + i);
		}
		
		System.out.println(pila.equals(pila2));
		
		System.out.println(pila.size());
		
		for(int i = 0; i <= 110; i++){
			System.out.println(pila.sacar());
		}
		
	}
	
}
