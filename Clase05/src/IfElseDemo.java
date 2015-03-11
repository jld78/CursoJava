
public class IfElseDemo {

	public static void main(String[] args) {

		// if(cond. boolean){
		// cuerpo del if
		// } else {
		//	cuerpo del else
		// }
		int a = 10;

		if (a > 5) {
			System.out.println("A es mayor a 5");
		}
		
		
		if(a > 5){
			System.out.println("A es mayor a 5");
		} else {
			System.out.println("No es mayor a 5");
		}
		
		// if{} else if{} ....
		if(a < 5){
			System.out.println("A es mayor a 5");
		} else if (a < 5){
			System.out.println("A es menor a 5");
		} else {
			System.out.println("A es igual a 5");
		}

	}
	
}