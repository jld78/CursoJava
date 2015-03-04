
public class Cajero {

	// Campos	
	// Visibilidad | Tipo de dato | Nombre del Campo;
	private int nro;
	
	private double saldo;
	
	
	// Métodos
	// Visibilidad | Tipo de retorno | Nombre del Método (Argumentos) {...};
	public double extraer(double cant) {
		// sentencias
		//
		saldo = saldo - cant;
		return cant;
	}
	
	public void consultar(){
		System.out.println("Saldo" + saldo);
	}
	
	
}
