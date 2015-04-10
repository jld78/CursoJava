
public class PilaSet extends Pila{
	
	@Override
	public boolean poner(String cadena){
		if(!getPila().contains(cadena)){
			getPila().add(cadena);
			return true;
		}
		return false;		
	}
	
}
