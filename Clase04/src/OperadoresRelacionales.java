
public class OperadoresRelacionales {

	public static void main(String[] args) {
		
		boolean b1 = false;
		boolean b2 = true;
		
		boolean b3 = b1 == b2;
		
		boolean b4 = b1 != b2;
		
		boolean b5 = 'A' > 'B';
		System.out.println(b5);
		
		String s1 = "Hola";
		String s2 = "Chau";
		boolean b6 = s1 == s2; //¿apuntan al mismo objeto?
		boolean b7 = s1 != s2; //¿apuntan al mismo objeto?
	}
	
}
