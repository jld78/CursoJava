
public class SoloDatosTest {

	public static void main(String[] args) {
		
		SoloDatos sd1 = new SoloDatos();
		
		sd1.asignarI(1);
		
		System.out.println(sd1.obtenerI());
		System.out.println(sd1.d);
		
		SoloDatos sd2 = sd1;
		sd1 = null;
		sd2.i = 1;
		
		int i = 3;
		System.out.println(i);
		
	}
	
}
