
public class PersonaTest {

	public static void main(String[] args) {
		
		Persona p1 = new  Persona("Luciano", "Diamand");
		Persona p2 = new  Persona("Carlos", "Perez");
		
		System.out.println(p1);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
	}
	
}
