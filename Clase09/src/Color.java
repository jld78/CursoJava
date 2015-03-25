
public class Color {

	//Patron type safe enum
	
	public static final Color NEGRO = new Color(0);
	public static final Color GRIS = new Color(127);
	public static final Color BLANCO = new Color(255);
	
	private int color;
	
	private Color(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
}
