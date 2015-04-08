import java.util.ArrayList;
import java.util.List;


public class Pila {


	private List<String> pila = new ArrayList<>();
	
	public List<String> getPila() {
		return pila;
	}
	
	public void poner(String cadena){
		pila.add(cadena);
	}
	
	public String sacar(){
		if(pila.size()>0){
			String tmp = pila.get(pila.size()-1);
			pila.remove(pila.size()-1);
			return tmp;
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
			Pila pila2 = (Pila) obj;
			if(this.size() == pila2.size()){
				if(pila.containsAll(pila2.getPila())){
					return true;
				}
			}
		}
		return false;
	}
	
}
