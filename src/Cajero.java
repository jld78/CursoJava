
public class Cajero {

	// Campos	
	// Visibilidad | Tipo de dato | Nombre del Campo;
	private int nro;
	
	private double saldo;
	
	
	// M�todos
	// Visibilidad | Tipo de retorno | Nombre del M�todo (Argumentos) {...};
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
