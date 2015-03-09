public class SoloDatosTest {

	public static void main(String[] args) {

		SoloDatos sd1 = new SoloDatos();

		sd1.setI(1);

		System.out.println(sd1.getI());

		sd1.setB(true);

		System.out.println(sd1.isB());

		sd1.setC('j');

		System.out.println(sd1.getC());

		sd1.setD(47.5);

		System.out.println(sd1.getD());

		sd1.setS("Cadena");

		System.out.println(sd1.getS());

/*

		SoloDatos sd2 = sd1;
		sd1 = null;
		sd2.i = 1;

		int i = 3;
		System.out.println(i);
*/
	}

}
