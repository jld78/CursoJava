package net.polotecnologico.ordenable;

import java.util.Date;

public class Pelicula implements Ordenable{

	String titulo;
	Date estreno;
	
	public Pelicula(String titulo, Date estreno) {
		this.titulo = titulo;
		this.estreno  = estreno;
	}
	
	public Date getEstreno() {
		return estreno;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	@Override
	public int compareTo(Ordenable ord) {
		if(ord instanceof Pelicula){
			Pelicula pelicula = (Pelicula) ord; 
			if(this.estreno.after(pelicula.estreno)){
				return 1;
			}else if(this.estreno.before(pelicula.estreno)){
				return -1;
			}
		}else{
				//throw new Exception("No es una pelicula");
		};
		
		return 0;
	}
	
	@Override
	public String toString() {
		return "Titulo: " + this.titulo + ", Estreno: " + this.estreno;
	}

}
