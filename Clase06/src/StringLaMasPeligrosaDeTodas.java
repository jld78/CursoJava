
public class StringLaMasPeligrosaDeTodas {

	public static void main(String[] args) {
		
		String s1 = "Luciano";
		String s2 = "Daniel";
		String s3 = "Diamand";
		String s4 = " ";
		
		String tmp = s1 + s4;
		tmp = tmp + s2 +s4;
		tmp = tmp + s3;
		
		System.out.println(tmp);
		
	}
	
}
