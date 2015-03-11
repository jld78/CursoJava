public class SwitchDemo {

	// switch (exp. int){ // byte, short, int, char, enum (j1.5), String (j1.7)
	// case Const1:
	// ...
	// case Const2:
	// ...
	// case ConstN:
	// ...

	public static void main(String[] args) {

		int i = 2;

		switch (i) {
		case 1:
			System.out.println("Uno");
			break;
		case 2:
			System.out.println("Dos");
			break;
		case 3:
			System.out.println("Tres");
			break;
		default:
			System.out.println("No es ni 1 ni 2 ni 3");
		}
		
		char c = 'C', d = 'D';
		switch(c){
		case 'A':
			System.out.println("Es A");
		case 'B':
			System.out.println("Es B");
		case 'C':
			System.out.println("Es C");
		}
		
		switch(c){
		case 65:
			System.out.println("Es A");
		case 66:
		case 65535:
		// case 65536: out of int range
		}

	}
}
