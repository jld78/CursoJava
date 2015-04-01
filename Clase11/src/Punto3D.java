
public class Punto3D extends Punto {

	private int z;
	
	public Punto3D (int nx, int ny, int nz) {
		super(nx, ny);
		z = nz;
	}
	
	public Punto3D () {
		z = generaNumeroAzarMenos10y10();
	}
	
	public Punto3D (int xy) {
		super(xy);
		z = xy;
	}
	
	public String getCoordenadas() {
		return super.getCoordenadas().substring(0, super.getCoordenadas().length()-1) + ", " + z + " ]" ;
	}
	
	public int cuadrante () {
		if (super.getX() > 0 && super.getY() > 0 && z > 0) {
			return 1;
		}
		// TODO Completar!
		return 2;
	}
	
	public double distancia (Punto3D p) {
		return Math.sqrt(Math.pow(p.getX() - getX(), 2) +
			Math.pow(p.getY() - getY(), 2) + Math.pow(p.z, z));
	}
	
}
