import java.util.Scanner;


public class Conversion {

	public static void main(String[] args) {
		System.out.println("Ingrese algo: ");
		Scanner s = new Scanner(System.in);
		String linea = s.nextLine();
		System.out.println(linea);
		
		int i = Integer.parseInt(linea);
		System.out.println(i);
		
		Integer i2 = Integer.valueOf(linea);
		System.out.println(i);
		
		String numero = i + "";
		String numero2 = String.valueOf(i);
		
	}
	
}
