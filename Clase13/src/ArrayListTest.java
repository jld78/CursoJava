import java.util.ArrayList;


public class ArrayListTest {

	public static void main(String[] args) {
		
//		List<String> lst = new ArrayList<>();
		ArrayList<String> arr1 = new ArrayList<>();
		arr1.add("Luciano");
		arr1.add("Carlos");
//		arr1.add(new Integer(6));
		
		String o = arr1.get(2);
		
		int cant = arr1.size();
		System.out.println(cant);
		
		for (String string : arr1) {
			System.out.println(string);
		}
		
		arr1.add(2, "Sopa");
		arr1.set(2, "Chau");
		
		arr1.remove("Luciano");
		
		
	}
	
}
