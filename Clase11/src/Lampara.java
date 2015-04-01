
public class Lampara {

	private boolean apagada ;
	
	public Lampara() {
		apagada = true;
	}
	
	public void on() {
		apagada = false;
	}
	
	public void off() {
		apagada = true;
	}
	
	public boolean isPrendida() {
		return !apagada;
	}
}
