
public class Persona {

	private String nombre;
	private String apellido;
	
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Persona){
			Persona tmp = (Persona) obj;
			return tmp.nombre.equals(this.nombre) && tmp.apellido.equals(this.apellido);
		}
	return false;
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.apellido;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
