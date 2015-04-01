
public class Punto {

	private int x;
	
	private int y;
	
	
	public Punto (int nx, int ny) {
		x = nx;
		y = ny;
	}
	
	public Punto () {
		x = generaNumeroAzarMenos10y10();
		y = generaNumeroAzarMenos10y10();
	}
	
	public Punto (int xy) {
		x = xy;
		y = xy;
	}
	
	protected int getX() {
		return x;
	}
	
	protected int getY() {
		return y;
	}

	public String getCoordenadas() {
		return "[ " + x + ", " + y + "]";
	}
	
	public int cuadrante () {
		if (x > 0 && y > 0) {
			return 1;
		}
		// TODO Completar!
		return 2;
	}
	
	public double distancia (Punto p) {
		return Math.sqrt(Math.pow(p.x - x, 2) +
			Math.pow(p.y - y, 2));
	}
	
	private int generaNumeroAzar0y10() {
		return (int) (Math.random() * 11);
	}
	
	protected int generaNumeroAzarMenos10y10 () {
		return generaNumeroAzar0y10() - generaNumeroAzar0y10();
	}
}
