
public class Punto3DTest {

	
	public static void main(String[] args) {
		

	Punto3D p1 = new Punto3D(1, -3, 4);
	
//	System.out.println(p1.getX());
//	System.out.println(p1.getY());
	
	System.out.println(p1.getCoordenadas());
	
	Punto3D p2 = new Punto3D();
	
//	System.out.println(p2.getX());
//	System.out.println(p2.getY());
	
	System.out.println(p2.getCoordenadas());
	
	System.out.println(p2.cuadrante());
	
	Punto3D p3 = new Punto3D(0);
	
//	System.out.println(p3.getX());
//	System.out.println(p3.getY());
	
	System.out.println(p3.getCoordenadas());
	
	Punto3D p4 = new Punto3D (5, -3, 4);
	System.out.println(p4.distancia(p1));
}
	
}
