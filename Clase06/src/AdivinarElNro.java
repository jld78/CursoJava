import java.util.Scanner;
import java.util.Set;


public class AdivinarElNro {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		int[] nroMaquina = new int[4];
		String[] respuesta = null;
		int intentos = 100;

		for(int i=0; i<nroMaquina.length; i++){
			nroMaquina[i] = (int) (Math.random()*9+1);
			System.out.print(nroMaquina[i]);
		}
		
		nroMaquina = new int[]{1, 2, 1, 5};
		for (int i : nroMaquina) {
			System.out.print(i);
		}
		System.out.println();

		System.out.println();
		System.out.println("Ingrese cuatro digitos");

		Scanner sc = new Scanner(System.in);


		/* Guarda los dígitos ingresados por el usuario */
		
		
		while (!sb.toString().equals("XXXX") && intentos > 0){
			
			int[] arrayUser = new int[4];
			respuesta = new String[]{"","","",""};

			System.out.println("Quedan " + intentos + " ('q' para salir)");
			
			sb.setLength(0);

			String entrada = sc.nextLine();
			
			if(entrada.equals("q")){
				intentos=0;
				continue;
			}

			for(int i=0; i<4; i++){
				arrayUser[i] = Integer.parseInt(String.valueOf(entrada.charAt(i))); 
			}
			
			/* Primera pasada marcar X */
			for(int j=0; j < nroMaquina.length; j++){
				if(nroMaquina[j]==arrayUser[j]){
					respuesta[j] = "X";
				}
			}
			
			/*  
			 * Segunda pasada _
			 * 
			*/
			
			/* En el peor de los casos dos nros repetidos */
//			int a = 0;
//			int b = 0;
//			for(int j=0; j < nroMaquina.length; j++){
//				for(int k=0; k<nroMaquina.length; k++){
//					if(j != k && nroMaquina[j] == nroMaquina[k] && !respuesta[j].equals("X") 
//							&& !respuesta[k].equals("X")){
//						if(nroMaquina[k] != a){
//							a = nroMaquina[k];
//						} else {
//							b = nroMaquina[k];
//						}
//					}
//				}
//			}
			
			int a=0;
			int b=0;
			for(int i=0; i < nroMaquina.length; i++){
				if(respuesta[i] == null && !respuesta[i].equals("X")){
					if(a != nroMaquina[i]){
						a = nroMaquina[i];
					} else if(b != nroMaquina[i]){
						b = nroMaquina[i];
					} else {
						continue;
					}
					for(int j=0; j<arrayUser.length; j++){
						if(!respuesta[j].equals("X")){
							if(nroMaquina[i] == arrayUser[j]){
								respuesta[i] = "_";
							}
						} else {
							continue;
						}
					}
				}
			}

//			for(int j=0; j < nroMaquina.length; j++){
//				boolean iteracionActual = false;
//				for(int i=0; i < nroMaquina.length; i++){
//					if(nroMaquina[j]==arrayUser[i]){
//						if (j == i) {
//							//sb.insert(0, "X");
//							respuesta[j] = "X";
//							//iteracionActual = true;
//						} else {
//							if(respuesta[j] != "X" && !iteracionActual){
//								//sb.append("_");
//								respuesta[j] = "_";
//							}
//							//iteracionActual = true;
//						}
//						iteracionActual = true;
//					}	
//				}
//			}
			System.out.println("Fin del bucle");
			//System.out.println(sb.toString());
			for(int i=0; i < respuesta.length; i++){
				if(respuesta[i]!=null){
					sb.append(respuesta[i]);
					System.out.print(respuesta[i]);
				}
			}
			System.out.println();
			System.out.println(sb.toString());
			intentos--;
		};


		/* Verifica si se adivino el nro o no antes de salir */
		if(sb.toString().equals("XXXX")){
			System.out.println("Nro correcto");
		} else {
			System.out.println("No adivino el nro");
		}

		for(int i=0; i < respuesta.length; i++){
			if(respuesta[i]!=null){
				
				System.out.print(respuesta[i]);
			}
		}

		sc.close();

	}


}
