import java.util.HashSet;
import java.util.Iterator;


public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet<String> lista = new HashSet();
		
		lista.add("Luciano");
		System.out.println(lista.add("Cecilia"));
		System.out.println(lista.add("Luciano"));
		
		System.out.println(lista.size());
		
		for (String string : lista) {
			System.out.println(string);
		}
		
		Iterator<String> iterator = lista.iterator();
		
		while(iterator.hasNext()){
			String s = iterator.next();
			System.out.println(s);
		}
	}
	
}
