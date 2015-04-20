package net.polotecnologico.innerclasses.estaticas;

import static net.polotecnologico.innerclasses.estaticas.Outer.Inner;
import static java.lang.System.out;

public class OuterTest {

	public static void main(String[] args) {
		
		Outer.Inner in = new Outer.Inner(); 
		
		//Con static import
		Inner in2 = new Inner();
		
		
		out.println("Static import");
	}
	
}
