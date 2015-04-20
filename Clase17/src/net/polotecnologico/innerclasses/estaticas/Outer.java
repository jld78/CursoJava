package net.polotecnologico.innerclasses.estaticas;

public class Outer {

	private int campo1;
	
	private static int campoStatic;
	
	static class Inner {
		
		private int campo2;
		
		public void metodo1(){
//			campo1 = 1;
			campoStatic = 1;
		}
		
	}
	
}
