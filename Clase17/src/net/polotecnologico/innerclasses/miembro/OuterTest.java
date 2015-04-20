package net.polotecnologico.innerclasses.miembro;

import net.polotecnologico.innerclasses.miembro.Outer.Inner;

public class OuterTest {

	public static void main(String[] args) {
		
		Outer out = new Outer();
		out.crearInner();
		
		Outer.Inner in = out.new Inner();
		
		Outer.Inner in2 = new Outer().new Inner();
		
		in.imprimir();
	}
	
}
