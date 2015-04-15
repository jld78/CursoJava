package net.polotecnologico.exeptionsTest;

import java.util.ArrayList;
import java.util.List;


public class Pila<T> {


	private static final int DEFAULT_CAPACITY = 10;
	
	private int capacidad;
	private List<T> pila = new ArrayList<>();
	
	public Pila() {
		this(DEFAULT_CAPACITY);
	}
	
	public Pila(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public List<T> getPila() {
		return pila;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public boolean poner(T cadena) throws PilaLlenaException{
		if(pila.size()<capacidad){
			pila.add(cadena);
			return true;
		}
		//Exception
		throw new PilaLlenaException("La pila esta llena");

	}
	
	public T sacar(){
		if(pila.size()>0){
			T tmp = pila.get(pila.size()-1);
			pila.remove(pila.size()-1);
			return tmp;
		}
		//Throws exception
		throw new PilaVaciaException("La pila esta vacia");
	}
	
	public int size(){
		return pila.size();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (T element : pila) {
			builder.append(element.toString() + " ");
		}
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Pila){
			Pila pila2 = (Pila) obj;
			if(this.size() == pila2.size()){
				if(pila.containsAll(pila2.getPila())){
					return true;
				}
			}
		}
		return false;
	}
	
}
