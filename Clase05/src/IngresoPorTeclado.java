import java.util.Scanner;


public class IngresoPorTeclado {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		String linea = s.nextLine();
		System.out.println(linea.equals("luciano"));
		System.out.println(linea == "luciano");
		
		s.close();
	}
	
}
