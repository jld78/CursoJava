package net.polotecnologico.innerclasses.anonimas;

public class Outer {

	public void  metodo(){
		//Crea subclase de ClaseEjemplo
		metodo2(new InterfaceEjemplo(){
			
			private int i;
			
			//Bloque de inicializaci�n (constructor de clase an�nima)
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
