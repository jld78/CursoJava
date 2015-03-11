import java.util.Scanner;

//Exercise course Java
public class GeneradorNumeroAlAzar {
	
	public static void main(String[] args) {
		
		int intento = 0;
		int azarLimit = 0;
		int nro = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		
		/* Menu */
		boolean condicion = true;
		while(condicion){
		
		System.out.println("Men�");
		System.out.println("1-F�cil");
		System.out.println("2-Medio");
		System.out.println("3-Dif�cil");
		
			switch (sc.nextInt()){
			case 1:
				System.out.println("Nivel F�cil: 3 intentos en 10 nros");
				azarLimit = 10;
				break;
			case 3:
				System.out.println("Nivel Medio: 3 intentos en 100 nros");
				azarLimit = 100;
				break;
			case 2:
				System.out.println("Nivel Dif�cil: 3 intentos en 1000 nros");
				azarLimit = 100;
				break;
				default:
					continue;
			};
			condicion = false;
		};
		/* Menu End */
		
		
		double azar = Math.round(Math.random()*azarLimit);
		
		System.out.println(azar);
		
		System.out.println("�Cu�l es el n�mero");
		
		do{
			nro = sc.nextInt();
			intento++;
		} while(nro != azar && intento < 3);
		
		sc.close();
		
		if(nro!=azar){
			System.out.println("No adivino el nro");
			return;
		}
		
System.out.println("Correcto");
		
	}

}
