
public class PilaSetTest {

	public static void main(String[] args) {
		
		PilaSet pila = new PilaSet();
		
		for(int i = 0; i <= 100; i++){
			pila.poner("Cadena " + i);
			System.out.println("Cadena " + i);
		}
		
		System.out.println(pila.size());
		System.out.println(pila);
		
		for(int i = 0; i <= 110; i++){
			System.out.println(pila.sacar());
		}
		
	}
	
}
