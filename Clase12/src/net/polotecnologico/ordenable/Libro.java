package net.polotecnologico.ordenable;

public class Libro implements Ordenable{

	String titulo;
	long isbn;
	
	public Libro(String titulo, long isbn) {
		this.titulo = titulo;
		this.isbn  = isbn;
	}
	
	public long getEstreno() {
		return isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public int compareTo(Ordenable ord) {
		if(ord instanceof Libro){
			Libro libro = (Libro) ord; 
			if(this.isbn > libro.isbn){
				return 1;
			}else if(this.isbn < libro.isbn){
				return -1;
			};
			
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.titulo + ", Estreno: " + this.isbn;
	}
	
}
