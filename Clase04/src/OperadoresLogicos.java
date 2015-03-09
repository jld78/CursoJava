
public class OperadoresLogicos {

	public static void main(String[] args) {
		
	
	// & (and circuito largo)
	// && (and circuito corto)
	int a = 1;
	int b = 2;
	boolean b1 = a > 1 && b < 10; // evaluate the second condition only if first condition is true
	System.out.println(b1);
	boolean b2 = a > 1 && b < 10; // evaluate the second condition always, even if first condition is false
	System.out.println(b2);
	
	boolean b3 = b < 10 || a > 1;
	System.out.println(b3);
	boolean b4 = b < 10 | a > 1;
	System.out.println(b4);
	
	boolean b5 = !b3;
	System.out.println(b5);
	
	}
	
}
