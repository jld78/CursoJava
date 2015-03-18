import java.io.IOException;


public class TestBasura {

	public static void main(String[] args) throws IOException {
		
		for(int i = 0; i < 1000000; i++){
			new Basura("Nombre " + (i+10));
			System.gc();
			System.in.read();
			
		}
		
	}
	
}
