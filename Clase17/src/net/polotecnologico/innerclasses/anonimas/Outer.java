package net.polotecnologico.innerclasses.anonimas;

public class Outer {

	public void  metodo(){
		//Crea subclase de ClaseEjemplo
		metodo2(new InterfaceEjemplo(){
			
			private int i;
			
			//Bloque de inicialización (constructor de clase anónima)
			{
				i = 5;
			}
			@Override
			public void Imprimir() {
				//Hace algo
			}
		});
		
	}
	
	private void metodo2(InterfaceEjemplo ce){
		ce.Imprimir();
		
	}
}
