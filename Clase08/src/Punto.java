
public class Punto {
	private int x;
	private int y;
	
	public Punto(int nx, int ny){
		x = nx;
		y = ny;
	}
	
	public Punto(){
		x = generaNumeroAzarMenos10y10();
		y = generaNumeroAzarMenos10y10();
	}
	
	public Punto(int xy){
		x = 0;
		y = 0;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public String getCoordenadas() {
		return "["+ x + "," + y + "]";
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int cuadrante(){
		if(x > 0 && y>0){
			return 1;
		}
		// TODO completar
		// FIXME
		return 0;
	}
	
	public double distancia(Punto p){
		return Math.sqrt(Math.pow(p.x - this.x, 2)+Math.pow(p.y - this.y, 2));
		
	}

	private int generaNumeroAzar0y10(){
		return (int) (Math.random() * 11);
	}
	
	private int generaNumeroAzarMenos10y10(){
		return generaNumeroAzar0y10() - generaNumeroAzar0y10();
	}
}
