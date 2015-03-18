import java.util.Scanner;
import java.util.Set;

public class AdivinarElNro {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		int[] nroMaquina = new int[4];
		String[] respuesta = null;
		int intentos = 100;

		for (int i = 0; i < nroMaquina.length; i++) {
			nroMaquina[i] = (int) (Math.random() * 9 + 1);
			System.out.print(nroMaquina[i]);
		}

		nroMaquina = new int[] { 1, 2, 1, 5 };
		for (int i : nroMaquina) {
			System.out.print(i);
		}
		System.out.println();

		System.out.println();
		System.out.println("Ingrese cuatro digitos");

		Scanner sc = new Scanner(System.in);

		/* Guarda los dígitos ingresados por el usuario */

		while (!sb.toString().equals("XXXX") && intentos > 0) {

			int[] arrayUser = new int[4];
			respuesta = new String[] { "", "", "", "" };

			System.out.println("Quedan " + intentos + " ('q' para salir)");

			sb.setLength(0);

			String entrada = sc.nextLine();

			if (entrada.equals("q")) {
				intentos = 0;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				arrayUser[i] = Integer.parseInt(String.valueOf(entrada
						.charAt(i)));
			}

			/*
			 * 
			 * Primera pasada marcar X
			 */
			for (int j = 0; j < nroMaquina.length; j++) {
				boolean procesado = false;
				if (j > 0) {
					for (int l = 0; l < j; l++) {
						if (nroMaquina[l] == nroMaquina[j]) {
							procesado = true;
							break;
						}
					}
				}

				for (int k = 0; k < nroMaquina.length; k++) {
					if (nroMaquina[j] == arrayUser[k]) {
						if (j == k) {
							respuesta[j] = "X";
							continue;
						} else {
							if(!respuesta[j].equals("X") && !procesado){
								respuesta[j] = "_";
							}
							
							continue;
						}
					}
				}
			}
			
			System.out.println("\n\nResultado:");
			System.out.println("\t'X': dígito y ubìcación correcta, el dígito puede estar repetido y se indica con otra 'X' si está en la posición correcta y no se indica si no lo esta"); 
			System.out.println("\t'_': digíto correcto y ubic. incorrecta, sólo se indica una vez" );
			for (int i = 0; i < respuesta.length; i++) {
				if (respuesta[i] != null) {
					if(respuesta[i].equals("X")){
						sb.insert(0, 'X');
					} else if(respuesta[i].equals("_")){
						sb.append('_');
					}
				}
			}
			System.out.println("\n" + sb.toString() + "\n");
			intentos--;
		};
		
		if(sb.toString().equals("XXXX")){
			System.out.println("\n Ha adivinado el número \n");
		}

		sc.close();

	}

}
