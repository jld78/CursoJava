import java.util.Scanner;


public class IngresoPorTeclado {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		
//		String linea = teclado.nextLine();
//		
//		System.out.println(linea);
//		
//		double d = teclado.nextDouble();
//		
//		System.out.println(d);
		
		System.out.println("Verificando pool de strings");
		
		String strLocal = "Cadena";
		String strLocal2 = "Cadena";

		if(strLocal.equals(strLocal2)){
			System.out.println("Comparando strLocal y strLocal2");
			System.out.println(strLocal == strLocal2?"Está en el pool":"No está en el pool");
		}else{
			System.out.println("Las cadenas son distintas");
		};
		
		
		System.out.println("Ingresar cadena");
		String str1 = teclado.nextLine(); 
		
		if(strLocal.equals(str1)){
			System.out.println("Comparando strLocal con cadena ingrsada por teclado");
			System.out.println(strLocal == str1?"Está en el pool":"No está en el pool");
		}else{
			System.out.println("Las cadenas son distintas");
		};
		
		teclado.close();
	}
	
}
