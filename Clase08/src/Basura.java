
public class Basura {

	private String nombre;
	
	public Basura(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void finalize(){
		System.out.println("Eliminando basura " + this.nombre);
	}
}
