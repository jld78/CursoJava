import java.util.Scanner;

//Exercise course Java
public class ContarVocalesConsonates {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingresar una frase");
		String frase = s.nextLine().toLowerCase();
		
		int i = 0;
		int voc = 0;
		int cons = 0;
		
		while(i < frase.length()){
			char c = frase.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
				voc++;
			} else {
				cons++;
			}
			i++;
		}
		
		System.out.println("Nro de vocales: " + voc);
		System.out.println("Nro de consonantes: " + cons);
		
		s.close();
		
		return;
		
	}
	
}
