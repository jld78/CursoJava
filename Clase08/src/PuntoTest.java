
public class PuntoTest {

	public static void main(String[] args) {
		Punto p1 = new Punto(1,  -3);
		
		System.out.println(p1.getX());
		System.out.println(p1.getY());
		
		Punto p2 = new Punto();
		
		System.out.println(p2.getX());
		System.out.println(p2.getY());
		
		System.out.println((p2.cuadrante()));
		
		Punto p3 = new Punto(0);
		
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		
		Punto p4 = new Punto(5, -3);
		
		System.out.println(p4.distancia(p1));
	}
	
}
