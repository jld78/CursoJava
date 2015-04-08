import java.util.HashMap;
import java.util.Map;


public class MapTest {

	public static void main(String[] args) {
		
		Map<String, Integer> mapa = new HashMap<>();
		
		mapa.put("Luciano", new Integer(20));
		mapa.put("Pepe", new Integer(100));
		
		System.out.println(mapa.get("Luciano"));
		System.out.println(mapa.size());
		
		System.out.println(mapa.get("Luciano1"));
		
		System.out.println(mapa.get("Pepe"));
		mapa.put("Pepe", new Integer(101));
		System.out.println(mapa.get("Pepe"));
		
	}
	
}
