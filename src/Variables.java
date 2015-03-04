
public class Variables {

	public static void main(String[] args) {

		int numero;
		numero = 1;
		
		int numero2 = 2;
		
		char caracter = 'a';
		
		String palabra = "Hola Mundo";
		System.out.println(palabra);
		
		
		// toUpperCase
		System.out.println(palabra.toUpperCase());
		// toLowerCase
		System.out.println(palabra.toLowerCase());
		// length
		System.out.println(palabra.length());
		// indexOf
		System.out.println(palabra.indexOf('M'));
		//charAt
		System.out.println(palabra.charAt(2));
		//contains
		System.out.println(palabra.contains("Mundo"));
		//lastIndexOf
		System.out.println(palabra.lastIndexOf("o"));
		//equals()
		System.out.println(palabra.equals("Hola Mundo"));
		System.out.println(palabra.equals("hola mundo"));
		//equalsIgnoreCase
		System.out.println(palabra.equalsIgnoreCase("Hola Mundo"));
		System.out.println(palabra.equalsIgnoreCase("hola mundo"));
		//trim
		System.out.println("  Hola   Mundo  ".trim());
		//replace
		System.out.println(palabra.replace("Hola", "Chau"));
		//substring
		System.out.println(palabra.substring(4));
		
	}
	
}
