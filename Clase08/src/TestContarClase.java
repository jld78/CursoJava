
public class TestContarClase {

	public static void main(String[] args) {
		
		ContarClase c1 = new ContarClase();
		ContarClase c2 = new ContarClase();
		System.out.println("Nro de instancia de c2 " + c2.getInstancia());
		
		System.out.println("Nro de instancias " + ContarClase.getNroInstancias());
		
		
		ContarClase c3 = new ContarClase();
		System.out.println("Nro de instancia de c3 " + c3.getInstancia());
		ContarClase c4 = new ContarClase();
		
		System.out.println("Nro de instancias " + ContarClase.getNroInstancias());
		
	}
	
}
