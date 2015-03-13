import java.util.Scanner;


public class AdivinarElNro {

	public static void main(String[] args) {
	
	int[] nro = new int[4];
		
	for(int i=0; i<nro.length; i++){
		nro[i] = (int) (Math.random()*1001);
	}
	
	System.out.println("Ingrese cuatro dígitos");
	
	Scanner sc = new Scanner(System.in);
	
	String line = sc.nextLine();
	
	int[] arrayUser = new int[4];
	
	for(int i=0; i<4; i++){
		arrayUser[i] = (int) line.charAt(i);
	}
	
	
	StringBuilder sb = new StringBuilder();
	int j= 0;
	while(j < nro.length){
		for(int i=0; i<nro.length; i++){
			if(nro[j]==arrayUser[i]){
				if(j==i){
					sb.append("X");
				} else {
					sb.append("_");
				}
			}
			
		}
	}
	
	System.out.println(sb.toString());
	
	sc.close();
	
	}
	
	
}
