public class SoloDatosTest {

	public static void main(String[] args) {

		SoloDatos sd1 = new SoloDatos();

		sd1.asignarI(1);

		System.out.println(sd1.obtenerI());

		sd1.asignarB(true);

		System.out.println(sd1.obtenerB());

		sd1.asignarC('j');

		System.out.println(sd1.obtenerC());

		sd1.asignarD(47.5);

		System.out.println(sd1.obtenerD());

		sd1.asignarS("Cadena");

		System.out.println(sd1.obtenerS());

/*

		SoloDatos sd2 = sd1;
		sd1 = null;
		sd2.i = 1;

		int i = 3;
		System.out.println(i);
*/
	}

}
