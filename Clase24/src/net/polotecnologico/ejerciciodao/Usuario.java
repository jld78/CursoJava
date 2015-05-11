package net.polotecnologico.ejerciciodao;

public class Usuario {

	private Integer id;
	private String nombre;
	private String clave;
	private String email;
	
	public Usuario(Integer id, String nombre, String clave, String email) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getClave() {
		return clave;
	}
	
	public String getEmail() {
		return email;
	}
	
}
