package net.polotecnologico;

public class Registro {

	private int id;
	private String nombre;
	private String apellido;
	private boolean habilitado; 
	
	public Registro(int id, String nombre, String apellido, boolean habilitado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.habilitado = habilitado;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public boolean isHabilitado() {
		return habilitado;
	}
	
	
}
