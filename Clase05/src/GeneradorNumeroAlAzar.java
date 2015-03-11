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
		
		System.out.println("Menú");
		System.out.println("1-Fácil");
		System.out.println("2-Medio");
		System.out.println("3-Difícil");
		
			switch (sc.nextInt()){
			case 1:
				System.out.println("Nivel Fácil: 3 intentos en 10 nros");
				azarLimit = 10;
				break;
			case 3:
				System.out.println("Nivel Medio: 3 intentos en 100 nros");
				azarLimit = 100;
				break;
			case 2:
				System.out.println("Nivel Difícil: 3 intentos en 1000 nros");
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
		
		System.out.println("¿Cuál es el número");
		
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
