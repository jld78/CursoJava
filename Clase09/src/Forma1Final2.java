
public class Forma1Final2 {

	// Inicializaci�n en la declaraci�n
	private final Integer i; //Autoboxing
	
	//final blank
	public Forma1Final2(int i) {
		this.i = i;
	}
	
	public Integer getI(){
		return i;
	}
	
	public void cambiarValor() {
		// i = 0; // no compila porque i es final
	}
	
}
