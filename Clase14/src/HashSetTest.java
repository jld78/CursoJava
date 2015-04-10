import java.util.HashSet;
import java.util.Set;

import net.polotecnologico.ordenable.Libro;


public class HashSetTest {

	public static void main(String[] args) {
		
		Set<Libro> libros = new HashSet<>();
		
		for(int i=0, j=0; i < 10; i++){
			Libro libro = new Libro("Titulo " + i, generarIsbn());
			System.out.println(libro);
			if(libros.add(libro)){
				System.out.println("Se agrego");
			}else{
				System.out.println("No se agrego");
			}
			j++;
			if(j == 3){
				j=0;
				if(libros.add(libro)){
					System.out.println("Se agrego duplicado");
				}else{
					System.out.println("No se agrego duplicado");
				}
			}
		}
		
		System.out.println("\nMostrar contenido");
		for (Libro libro : libros) {
			System.out.println(libro);
		}
		
	}
	
	private static int generarIsbn(){
		return (int) (Math.random()*1000);
	}
	
}
