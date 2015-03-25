
public class ColorTest {

	public static void main(String[] args) {
		Color negro = Color.NEGRO;
		Color gris = Color.GRIS;
		Color blanco = Color.BLANCO;
		
		System.out.println(blanco.getColor());
//		Color grisClaro = new Color(200);
		
		Color2 negro2 = Color2.NEGRO;
		Color2 gris2 = Color2.GRIS;
		Color2 blanco2 = Color2.BLANCO;
		
//		Color2 grisClaro = new Color2(200);
		System.out.println(blanco2.getColor());
		
		Color2[] colores2 = Color2.values();
		
		for (Color2 color2 : colores2) {
			System.out.println(color2);
		}
		
		Color2 c = Color2.valueOf("NEGRO");
		System.out.println(c.getColor());
		
		switch (c) {
		case BLANCO:

			break;
		case NEGRO:

			break;
		case GRIS:

			break;

		default:
			break;
		}
		
	}
 
}
