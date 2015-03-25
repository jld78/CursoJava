
public enum Color2 {

	NEGRO(0), GRIS(127), BLANCO(255);
	
	private int color;
	
	// el constructor no puede ser publico
	private Color2(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
}
