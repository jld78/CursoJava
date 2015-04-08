import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class PilaSet {


	private Set<String> pila = new TreeSet<>();
	
	public Set<String> getPila() {
		return pila;
	}
	
	public void poner(String cadena){
		pila.add(cadena);
	}
	
	public String sacar(){
		String tmp = null;
		if(pila.size()>0){
			Iterator<String> iterator = pila.iterator();

		}
		return null;
	}
	
	public int size(){
		return pila.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String element : pila) {
			builder.append(element + " ");
		}
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Pila){
			PilaSet pilaSet2 = (PilaSet) obj;
			if(this.size() == pilaSet2.size()){
				if(pila.containsAll(pilaSet2.getPila())){
					return true;
				}
			}
		}
		return false;
	}
	
}
