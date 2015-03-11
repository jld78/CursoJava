
public class IfElseDemo {

	public static void main(String[] args) {

		// if(cond. boolean){
		// cuerpo del if
		// } else {
		//	cuerpo del else
		// }
		int a = 10;

		System.out.println("Example 1");
		if (a > 5) {
			System.out.println("A es mayor a 5");
		}
		
		System.out.println("");
		System.out.println("Example 2");
		if(a > 5){
			System.out.println("A es mayor a 5");
		} else {
			System.out.println("No es mayor a 5");
		}
		
		// if{} else if{} ....
		System.out.println("");
		System.out.println("Example 3");
		if(a < 5){
			System.out.println("A es mayor a 5");
		} else if (a < 5){
			System.out.println("A es menor a 5");
		} else {
			System.out.println("A es igual a 5");
		}
		
		System.out.println("");
		System.out.println("Example 4");
		int i = 100;
		if(i > 100)
			if(i==100)
				System.out.println("A");
			//the else is own to more near if
			else 
				System.out.println("B");
		
		System.out.println("");
		System.out.println("Example 4");
		boolean b = false;
		if(b = true){
			System.out.println("¡Rebuscado!");
		}
			

	}
	
}