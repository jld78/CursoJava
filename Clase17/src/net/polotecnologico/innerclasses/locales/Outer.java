package net.polotecnologico.innerclasses.locales;

public class Outer {

	private int campo1;
	
	public void metodo(){
		campo1 = 0;
		//puedo crear inner despues de la def y dentro del metodo()
		class Inner{
			public void metodointerno(){
				
			}
		}
		
		campo1 = 1;
		
		Inner i = new Inner();
		i.metodointerno();
	}
	
	public void metodoExterno(){
//		Inner i2 = new Inner();
	}
	
}
