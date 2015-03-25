
public class Forma1Final {

	// Inicialización en la declaración
	private final Integer i = 4; //Autoboxing
	
	
	public Integer getI(){
		return i;
	}
	
	public void cambiarValor() {
		// i = 0; // no compila porque i es final
	}
	
}
