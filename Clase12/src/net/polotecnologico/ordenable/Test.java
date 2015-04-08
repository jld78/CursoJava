package net.polotecnologico.ordenable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		
		Ordenable[] ordenados;
		
		Libro[] libros = {
				new Libro("Libro A", 345),
				new Libro("Libro B", 123),
				new Libro("Libro C", 33),
				new Libro("Libro D", 432),
				new Libro("Libro E", 345),
				new Libro("Libro F", 123),
				new Libro("Libro G", 33),
				new Libro("Libro H", 432)
		};
		
		ordenados  = Ordenador.ordenar(libros);
		
		for (Ordenable ordenable : ordenados) {
			System.out.println(ordenable);
		}
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Pelicula[] peliculas={
			new Pelicula("Pelicula A", dateFormat.parse("03-01-2015")),
			new Pelicula("Pelicula B", dateFormat.parse("03-03-2015")),
			new Pelicula("Pelicula C", dateFormat.parse("08-04-2015")),
			new Pelicula("Pelicula D", dateFormat.parse("03-01-2015")),
			};
		
		
		ordenados  = Ordenador.ordenar(peliculas);
		
		for(int i = 0; i < ordenados.length; i++){
			System.out.println(ordenados[i]);
		}
		
		
		} catch (ParseException e){
			e.printStackTrace();
		}
		

	}

}
