
public class ArregloDeReferencias {

	public static void main(String[] args) {
		
		String [] arr1 = new String[3];
		
		System.out.println(arr1[1]); // las referencias se inicializan en "null"
		
		arr1[0] = "Hola";
		
		String s = new String("Luciano"); //horrible
		String s2 = "Luciano";
		
		arr1[1] = s2; // la referencia apunta ahora pool de strings
	}
	
}
