
public class DimmerTest {

	public static void main(String[] args) {
//		Dimmer d = new Dimmer();
//		d.on();
//		System.out.println("Lampara encendida " + d.isPrendida());
//		d.off();
//		System.out.println("Lampara apagada" + d.isPrendida());
//		
//		Dimmer d2 = new Dimmer();
//		System.out.println("Creado d2");
//		d2.inc();
//		System.out.println("Itensidad: " + d2.getIntensidad());
//		System.out.println("d2 esta prendida " + d2.isPrendida());
//		
//		Dimmer d3 = new Dimmer();
//		System.out.println("Creado d3");
//		d3.on();
//		System.out.println("Intensidad " + d3.getIntensidad());
//		System.out.println("Prendida " + d3.isPrendida());
		
		Dimmer d4 = new Dimmer(3, 15);
		System.out.println("Creado d4");

		for(int i = 0; i < 4; i++){
			System.out.println("Encender");
			d4.on();
			System.out.println("Prendida " + d4.isPrendida() + ", Intensidad " + d4.getIntensidad());
		}

		for(int i = 0; i < 15; i++){
			System.out.println("Decrementar Intensidad");
			d4.dec();
			System.out.println("Prendida " + d4.isPrendida() + ", Intensidad " + d4.getIntensidad());
		}

		for(int i = 0; i < 15; i++){
			System.out.println("Incrementar Intensidad");
			d4.inc();
			System.out.println("Prendida " + d4.isPrendida() + ", Intensidad " + d4.getIntensidad());
		}

		for(int i = 0; i < 4; i++){
			System.out.println("Apagar");
			d4.off();
			System.out.println("Prendida " + d4.isPrendida() + ", Intensidad " + d4.getIntensidad());
		}
		
		for(int i = 0; i < 3; i++){
			System.out.println("Incrementar Intensidad");
			d4.inc();
			System.out.println("Prendida " + d4.isPrendida() + ", Intensidad " + d4.getIntensidad());
		}
		
		for(int i = 0; i < 4; i++){
			System.out.println("Encender");
			d4.on();
			System.out.println("Prendida " + d4.isPrendida() + ", Intensidad " + d4.getIntensidad());
		}
	}
}
