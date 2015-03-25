
public class Forma1Final2 {

	// Inicialización en la declaración
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
