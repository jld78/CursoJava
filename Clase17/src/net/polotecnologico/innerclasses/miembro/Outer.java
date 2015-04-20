package net.polotecnologico.innerclasses.miembro;

public class Outer {

	private int campo1;
	
	public int getCampo1() {
		return campo1;
	}
	
	class Inner {
		
		private int campo1Inner;
		
		// más miembros internos
		
		public void imprimir()
		{
			// acceder campos de outter
			campo1 = 1;
		}
	}
	
	public void crearInner(){
		Inner inner = new Inner();
		inner.campo1Inner = 1;
	}
	
}
