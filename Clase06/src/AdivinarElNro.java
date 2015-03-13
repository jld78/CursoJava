import java.util.Scanner;


public class AdivinarElNro {

	public static void main(String[] args) {
	
	int[] nro = new int[4];
		
	for(int i=0; i<nro.length; i++){
		nro[i] = (int) (Math.random()*10+1);
	}
	
	System.out.println("Ingrese cuatro dígitos");
	
	Scanner sc = new Scanner(System.in);

	
	int[] arrayUser = new int[4];
	
	for(int i=0; i<4; i++){
		int integer = sc.nextInt();
		arrayUser[i] = integer;
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
		j++;
	}
	
	System.out.println(sb.toString());
	
	sc.close();
	
	}
	
	
}
