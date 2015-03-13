
public class Alcance {

	public static void main(String[] args) {
		
		int i = 0;
		otroMetodo();
		Test t1 = new Test();
		{
			double d = 0.0;
			d = 1.5;
			i = 6;
			t1 = new Test();
		}
		i = 9;
		// d = 1.8; 
	}
	
	
	public static void otroMetodo(){
		int i = 4;
	}
	
}
