
public class ContarClase {

	private static int nroInstancias = 0;
	private int instancia = 0;
	
	public ContarClase() {
		ContarClase.nroInstancias +=1;
		this.instancia = ContarClase.nroInstancias;
	}
	
	public static int getNroInstancias(){
		return ContarClase.nroInstancias;
	}
	
	public int getInstancia() {
		return this.instancia;
	}
	
}
