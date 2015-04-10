
public class PilaSetTest {

	public static void main(String[] args) {
		
		PilaSet pilaSet = new PilaSet();
		
		for(int i = 0; i <= 100; i++){
			System.out.println("Cadena " + i);
			if(pilaSet.poner("Cadena " + i)){
				System.out.println("Agregado");
			};
		}
		
		if(pilaSet.poner("Cadena 0")){
			System.out.println("Se agrego duplicado");
		} else {
			System.out.println("No se agrego duplicado");
		}
		
		System.out.println("Tamaño de la pila " + pilaSet.size());
		System.out.println("Imprimir pila " + pilaSet);
		
		System.out.println("Sacar elementos de la pila");
		for(int i = 0; i <= 110; i++){
			System.out.println(pilaSet.sacar());
		}
		
	}
	
}
