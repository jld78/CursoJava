
public class Cuenta {

	private double saldo;
	private static double dolar;
	
	public Cuenta() {
		this.saldo = 10000;
	}
	
	public Cuenta(double saldo){
		this.saldo = saldo;
	}
	
	public double extraer(double cant){
		if(saldo >= cant){
			saldo -=cant;
			return cant;
		}
		return 0;
	}
	
	public double extraerDolares(double cantDolares){
		if(saldo >= cantDolares * dolar){
			saldo-= cantDolares * dolar;
		}
		return 0;
	}
	
	public void depositar(double cant) {
		saldo +=cant;
	}
	
	public double consultar() {
		return saldo;
	}
	
	public static void setDolar(double dolar){
		Cuenta.dolar = dolar;
	}
	
	public static double getDolar(){
		return dolar;
	}
	
}
